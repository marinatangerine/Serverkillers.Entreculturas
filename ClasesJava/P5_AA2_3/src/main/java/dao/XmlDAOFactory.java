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
public class XmlDAOFactory extends DAOFactory {
    public XmlPersonasDAO getXmlPersonasDAO() throws JAXBException {
        return new XmlPersonasDAO();
    }
}
