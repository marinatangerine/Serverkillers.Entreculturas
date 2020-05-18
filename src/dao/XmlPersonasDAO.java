/**
 * 
 */
package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.List;
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
public class XmlPersonasDAO implements IPersonasDAO {
	private JAXBContext jaxbContext = null;
    private String fileName = null;
    
    @XmlElement(name = "persona")
    public List<Persona> personas;
    
    public XmlPersonasDAO() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(XmlPersonasDAO.class);
        this.fileName = "Personas.xml";
        this.personas = new ArrayList<Persona>(); 
    }

	@Override
	public void savePersonas() throws JAXBException, FileNotFoundException {
		try {
			if(this.personas != null){
	            FileOutputStream file = new FileOutputStream(fileName, false);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Personas guardadas");
		}catch(Exception e){
            System.out.println("Error al guardar el fichero de personas");
		}
	}

	@Override
	public List<Persona> getPersonas() throws JAXBException, FileNotFoundException {       
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        try{
            InputStream inStream = new FileInputStream(fileName);
            XmlPersonasDAO personasDAO = (XmlPersonasDAO) jaxbUnmarshaller.unmarshal(inStream);
            return personasDAO.personas;
        }catch(FileNotFoundException e){
            System.out.println("No hay personas guardadas");
            return new ArrayList<Persona>();
        }catch(JAXBException e){
            System.out.println("Error al leer fichero de personas: " + e.getMessage());
            return new ArrayList<Persona>();
        }
	}

}
