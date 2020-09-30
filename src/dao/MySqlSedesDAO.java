package dao;

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
import main.DatabaseUtil;
import main.DuplicateEntityException;
import main.Sede;

public class MySqlSedesDAO implements DAO<Sede> {
	
	public List<Sede> sedes; //Arraylist de Sede
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	public MySqlSedesDAO() {
		sedes = new ArrayList<Sede>();
		emf = Persistence.createEntityManagerFactory("ong");
		manager = emf.createEntityManager();
	}

	@Override
	public int add(Sede sede) throws DuplicateEntityException {
		manager.getTransaction().begin();
		manager.persist(sede);
		manager.flush();
		manager.getTransaction().commit();
		return sede.getIdSede();
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
		sedes = manager.createQuery("FROM Sede").getResultList();
		return true;
	}

}
