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
import main.java.model.Persona;

public class MySqlPersonasDAO implements DAO<Persona> {
	
	public List<Persona> personas; //Arraylist de Persona
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public MySqlPersonasDAO() {
		personas = new ArrayList<Persona>();
		emf = Persistence.createEntityManagerFactory("ong");
		manager = emf.createEntityManager();
	}

	@Override
	public int add(Persona persona) throws DuplicateEntityException {
		try {
			manager.getTransaction().begin();
			manager.persist(persona);
			manager.flush();
			manager.getTransaction().commit();
			return persona.getPersonId();
		}
		catch(Exception ex) {
			throw ex;
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
		personas = manager.createQuery("FROM Persona").getResultList();
		return true;
	}

}
