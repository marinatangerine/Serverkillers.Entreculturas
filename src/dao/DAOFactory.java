/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import main.Persona;
import main.Proyecto;
import main.Voluntario;
import main.Sede;
/**
 *
 * @author suare
 */
public abstract class DAOFactory {
	public static final int XML = 1;
	public static final int MYSQL = 2;
 
	public abstract DAO<Persona> getXmlPersonasDAO();
	public abstract DAO<Sede> getXmlSedesDAO();
	public abstract DAO<Voluntario> getXmlVoluntariosDAO();
	public abstract DAO<Proyecto> getXmlProyectosDAO();
 
	public static DAOFactory getDAOFactory (int factoryType){
		switch (factoryType) {
        	case XML:
        		return new XmlDAOFactory();
            //case MYSQL:
            //	return new MySqlDAOFactory();
        	default:
        		return null;
		}
 	}
}