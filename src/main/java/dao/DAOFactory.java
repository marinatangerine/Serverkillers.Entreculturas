package main.java.dao;

import main.java.main.Proyecto;
import main.java.main.Voluntario;
import main.java.model.Persona;
import main.java.main.Sede;
/**Métodos que devuelve el DAO de cada una de las clases
 * Se incluye (comentado) el caso para utilizar una base de datos relacional
 * @versión 1.0 23/05/2020
 * @author Serverkillers
 *
 */
public abstract class DAOFactory {
	public static final int XML = 1;
	public static final int MYSQL = 2;
 
	public abstract DAO<Persona> getPersonasDAO();
	public abstract DAO<Sede> getSedesDAO();
	public abstract DAO<Voluntario> getVoluntariosDAO();
	public abstract DAO<Proyecto> getProyectosDAO();
 
	public static DAOFactory getDAOFactory (int factoryType){
		switch (factoryType) {
        	case XML:
        		return new XmlDAOFactory();
            case MYSQL:
            	return new MySqlDAOFactory();
        	default:
        		return null;
		}
 	}
}