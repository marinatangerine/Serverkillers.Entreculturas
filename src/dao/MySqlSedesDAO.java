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
	public void add(Sede sede) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "insert into sede (ciudad, direccion, telefono, email) values (?, ?, ?, ?);"
		try {
			PreparedStatement st = cn.prepareStatement(query);
			st.setString(1, sede.getCiudad());
			st.setString(2, sede.getDireccion());
			st.setString(3, sede.getTelefono());
			st.setString(4, sede.getEmail());
			
			st.execute();
			cn.close();
		}
		catch(SQLException e) {
			System.out.print("Error al insertar los datos de la sede: " + e.getMessage());
	}

	@Override
	public void saveAll() {
		// Not used in MySQL
		
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
			ResulSet rs = st.executeQuery("SELECT * FROM sede");
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
			return true
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de sedes: " + e.getMessage());
			return false;
		}
	}

}
