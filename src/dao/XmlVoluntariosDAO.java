/**
 * 
 */
package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.Voluntario;

/**
 * @author suare
 *
 */
@XmlRootElement(name = "voluntarios")
@XmlAccessorType (XmlAccessType.FIELD)
public class XmlVoluntariosDAO implements DAO<Voluntario> {
    
    @XmlElement(name = "voluntario")
    public List<Voluntario> voluntarios;
    
    public XmlVoluntariosDAO() {
    	this.voluntarios = new ArrayList<Voluntario>();
    }

	@Override
	public void saveAll() {
	    String fileName = "Voluntarios.xml";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlVoluntariosDAO.class);
			if(this.voluntarios != null){
	            FileOutputStream file = new FileOutputStream(fileName, false);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Voluntarios guardadas");
		}catch(Exception e){
            System.out.println("Error al guardar el fichero de voluntarios: " + e.getMessage());
		}
	}

	@Override
	public Optional<Voluntario> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voluntario t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Voluntario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voluntario> list() {
        return this.voluntarios;
	}

	@Override
	public void add(Voluntario t) {
		voluntarios.add(t);
	}
	
	@Override
	public boolean loadData() {
		String fileName = "Voluntarios.xml";
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlVoluntariosDAO.class);
        	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream inStream = new FileInputStream(fileName);
            XmlVoluntariosDAO voluntariosDAO = (XmlVoluntariosDAO) jaxbUnmarshaller.unmarshal(inStream);
            this.voluntarios = voluntariosDAO.voluntarios;
            return true;
        }catch(FileNotFoundException e){
            //System.out.println("No hay voluntarios guardados");
            return false;
        }catch(JAXBException e){
            //System.out.println("Error al leer fichero de voluntarios: " + e.getMessage());
            return false;
        }
	}
}