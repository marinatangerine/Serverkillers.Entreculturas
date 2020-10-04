package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import main.java.main.DatabaseUtil;
import main.java.main.DuplicateEntityException;
import main.java.model.Voluntario;

public class MySqlVoluntariosDAO implements DAO<Voluntario> {

	public List<Voluntario> voluntarios; //Arraylist de Voluntario
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public MySqlVoluntariosDAO() {
		voluntarios = new ArrayList<Voluntario>();
		emf = Persistence.createEntityManagerFactory("ong");
		manager = emf.createEntityManager();
	}
	
	@Override
	public int add(Voluntario voluntario) throws DuplicateEntityException {
		manager.getTransaction().begin();
		manager.persist(voluntario);
		manager.flush();
		manager.getTransaction().commit();
		return voluntario.getPersonId();	
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
		voluntarios = manager.createQuery("FROM Voluntario").getResultList();
		return true;
		}		
}		
