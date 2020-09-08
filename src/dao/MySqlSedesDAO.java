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
import main.Sede;

public class MySqlSedesDAO implements DAO<Sede> {
	
	public List<Sede> sedes; //Arraylist de Sede

	@Override
	public int add(Sede sede) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "call insertSede(?, ?, ?, ?, @id)";
		int newId = -1;
		try {
			PreparedStatement st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, sede.getCiudad());
			st.setString(2, sede.getDireccion());
			st.setString(3, sede.getTelefono());
			st.setString(4, sede.getEmail());
			
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
			System.out.print("Error al insertar los datos de la sede: " + e.getMessage());
			return newId;
		}
	}

	@Override
	public void saveAll() {
		// No se utiliza con MYSQL		
	}

	@Override
	public Sede get(String id) {
		int idSede = Integer.parseInt(id);
		return sedes.stream().filter(sede -> sede.getIdSede() == idSede).findFirst().orElse(null);
	}

	@Override
	public List<Sede> list() {
		return this.sedes;
	}

	@Override
	public boolean loadData() {
		sedes = new ArrayList<Sede>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM sede");
			while (rs.next()) {
				Sede sede = new Sede();
				sede.setIdSede(rs.getInt("idSede"));
				sede.setCiudad(rs.getString("ciudad"));
				sede.setDireccion(rs.getString("direccion"));
				sede.setTelefono(rs.getString("telefono"));
				sede.setEmail(rs.getString("email"));
				
				sedes.add(sede);
			}
			cn.close();
			return true;
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de sedes: " + e.getMessage());
			return false;
		}
	}

}
