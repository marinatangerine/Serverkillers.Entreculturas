package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import main.DatabaseUtil;
import main.DuplicateEntityException;
import main.Persona;

public class MySqlPersonasDAO implements DAO<Persona> {
	
	public List<Persona> personas; //Arraylist de Persona

	@Override
	public int add(Persona persona) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "call insertPersona(?, ?, ?, ?, ?, ?, ?, ?, ?, @id)";
		int newId = -1;
		try {
			PreparedStatement st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, persona.getUserName());
			st.setString(2, persona.getPass());
			st.setBoolean(3, persona.getAdmin());
			st.setString(4, persona.getName());
			st.setString(5, persona.getSurname());
			st.setString(6, persona.getAddress());
			st.setString(7, persona.getPhone());
			st.setString(8, persona.getEmail());
			st.setInt(9, persona.getIdSede());
			
			st.executeQuery();
			Statement st1 = cn.createStatement();
			ResultSet rs = st1.executeQuery("select @id");
			if (rs.next()) {
			  newId = rs.getInt(1);
			}
			cn.close();
			loadData();
			return newId;
		}
		catch(SQLException e) {
			System.out.print("Error al insertar los datos de la persona: " + e.getMessage());
			return newId;
		}
	}

	@Override
	public void saveAll() {
		// No se utiliza con MySQL
		
	}

	@Override
	public Persona get(String id) {
		int personId = Integer.parseInt(id);
		return personas.stream().filter(persona -> persona.getPersonId() == personId).findFirst().orElse(null);
	}

	@Override
	public List<Persona> list() {
		return this.personas;
	}

	@Override
	public boolean loadData() {
		personas = new ArrayList<Persona>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM persona");
			while (rs.next()) {
				Persona persona = new Persona();
				persona.setPersonId(rs.getInt("personId"));
				persona.setUserName(rs.getString("userName"));
				persona.setPass(rs.getString("pass"));
				persona.setAdmin(rs.getBoolean("administrator"));
				persona.setName(rs.getString("namePersona"));
				persona.setSurname(rs.getNString("surname"));
				persona.setAddress(rs.getString("address"));
				persona.setPhone(rs.getString("phone"));
				persona.setEmail(rs.getString("email"));
				persona.setIdSede(rs.getInt("fk_sedePersona"));
				
				personas.add(persona);
			}
			cn.close();
			return true;
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de personas: " + e.getMessage());
			return false;
		}
	}

}
