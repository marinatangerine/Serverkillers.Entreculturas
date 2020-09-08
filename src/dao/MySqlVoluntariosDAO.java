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
import main.Voluntario;

public class MySqlVoluntariosDAO implements DAO<Voluntario> {

	public List<Voluntario> voluntarios; //Arraylist de Voluntario
	
	@Override
	public int add(Voluntario voluntario) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "call insertVoluntario(?, ?, @id)";
		int newId = -1;
		try {
			PreparedStatement st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, voluntario.getAreaActividades());
			st.setInt(2, voluntario.getPersonId());
			
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
			System.out.print("Error al insertar los datos del voluntario: " + e.getMessage());
			return newId;
		}
		
	}

	@Override
	public void saveAll() {
		// Not used in MySQL
		
	}
	
	@Override
	public Voluntario get(String id) {
		int personId = Integer.parseInt(id);
		Voluntario v = null;
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			String query = "SELECT * FROM voluntario WHERE personId = ?";
			PreparedStatement st = cn.prepareStatement(query);
			st.setInt(1, personId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				v = new Voluntario();
				v.setPersonId(rs.getInt("personId"));
				v.setAreaActividades(rs.getString("areaActividades"));
			}
			cn.close();
			return v;
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de voluntarios: " + e.getMessage());
			return v;
		}
	}

	@Override
	public List<Voluntario> list() {
		return this.voluntarios;
	}

	@Override
	public boolean loadData() {
		voluntarios = new ArrayList<Voluntario>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM voluntario");
			while (rs.next()) {
				Voluntario voluntario = new Voluntario();
				voluntario.setPersonId(rs.getInt("personId"));
				voluntario.setAreaActividades(rs.getString("areaActividades"));
				
				voluntarios.add(voluntario);
			}
			cn.close();
			return true;
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de voluntarios: " + e.getMessage());
			return false;
		}
	}		
}		
