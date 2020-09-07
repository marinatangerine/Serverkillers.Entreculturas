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
	public void add(Voluntario voluntario) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "insert into voluntario (areaActividades, userName, pass, administrator, namePersona, surname, address, phone, email, fk_sedeVoluntario, fk_personaVoluntario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = cn.prepareStatement(query);
			st.setString(1, voluntario.getAreaActividades());
			st.setString(2, voluntario.getUserName());
			st.setString(3, voluntario.getPass());
			st.setBoolean(4, voluntario.getAdmin());
			st.setString(5, voluntario.getName());
			st.setString(6, voluntario.getSurname());
			st.setString(7, voluntario.getAddress());
			st.setString(8, voluntario.getPhone());
			st.setString(9, voluntario.getEmmail());
			st.setInt(10, voluntario.getIdSede());
			st.setInt(11, voluntario.getPersonId());
			
			st.execute();
			cn.close();	
		}
		catch(SQLException e) {
		System.out.print("Error al insertar los datos del voluntario: " + e.getMessage());
		
	}

	@Override
	public void saveAll() {
		// Not used in MySQL
		
	}

	@Override
	public Voluntario get(String id) {
		int numVoluntario = Integer.parseInt(id);
		return voluntario.stream().filter(voluntario -> voluntario.getNumVomuntario == numVoluntario).findFirst().orElse(null);
	}

	@Override
	public List<Voluntario> list() {
		return this.voluntarios;
	}

	@Override
	public boolean loadData() {
		voluntarios = new ArrayList<Voluntarios>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM voluntario");
			while (rs.next()) {
				Voluntario volintario = new Volintario();
				voluntario.setPersonId(rs.getInt("fk_personaVoluntario"));
				voluntario.setUserName(rs.getString("userName"));
				voluntario.setPass(rs.getString("pass"));
				voluntario.setAdmin(rs.getBoolean("administrator"));
				voluntario.setName(rs.getString("namePersona"));
				voluntario.setSurname(rs.getNString("surname"));
				voluntario.setAddress(rs.getString("address"));
				voluntario.setPhone(rs.getString("phone"));
				voluntario.setEmail(rs.getString("email"));
				voluntario.setIdSede(rs.getInt("fk_sedeVoluntario"));
				voluntario.setAreaActividades(rs.getString("areaActividades"));
				voluntario.setNumVoluntario(rs.getInt("idVoluntario"));
				
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
