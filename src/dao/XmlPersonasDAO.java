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

import main.Persona;

/**
 * @author suare
 *
 */
@XmlRootElement(name = "personas")
@XmlAccessorType (XmlAccessType.FIELD)
public class XmlPersonasDAO implements DAO<Persona> {
    
    @XmlElement(name = "persona")
    public List<Persona> personas;
    
    public XmlPersonasDAO() {
    	this.personas = new ArrayList<Persona>();
    }

	@Override
	public void saveAll() {
	    String fileName = "Personas.xml";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlPersonasDAO.class);
			if(this.personas != null){
	            FileOutputStream file = new FileOutputStream(fileName, false);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Personas guardadas");
		}catch(Exception e){
            System.out.println("Error al guardar el fichero de personas: " + e.getMessage());
		}
	}

	@Override
	public Optional<Persona> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Persona t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Persona t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persona> list() {
        return this.personas;
	}

	@Override
	public void add(Persona t) {
		personas.add(t);
	}
	
	@Override
	public boolean loadData() {
		String fileName = "Personas.xml";
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlPersonasDAO.class);
        	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream inStream = new FileInputStream(fileName);
            XmlPersonasDAO personasDAO = (XmlPersonasDAO) jaxbUnmarshaller.unmarshal(inStream);
            this.personas = personasDAO.personas;
            return true;
        }catch(FileNotFoundException e){
            //System.out.println("No hay personas guardadas");
            return false;
        }catch(JAXBException e){
            //System.out.println("Error al leer fichero de personas: " + e.getMessage());
            return false;
        }
	}
}
