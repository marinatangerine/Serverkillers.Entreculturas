/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.xml.bind.JAXBException;
/**
 *
 * @author suare
 */
public abstract class DAOFactory {
	public static final int XML = 1;
	public static final int MYSQL = 2;
 
	public abstract XmlPersonasDAO getXmlPersonasDAO() throws JAXBException;
 
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