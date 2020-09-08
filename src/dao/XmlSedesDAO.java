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

import main.DuplicateEntityException;
import main.Sede;

/** Carga los datos anteriores del Xml (para poder comprobar información de ellos y mostrarlo)
* Lista los datos de las personas guardadas
* Trata las excepciones definidas
* @versión 1.0 23/05/2020
* @author suare
*
*/

@XmlRootElement(name = "sedes")
@XmlAccessorType (XmlAccessType.FIELD)
public class XmlSedesDAO implements DAO<Sede> {
	
    @XmlElement(name = "sede")
    public List<Sede> sedes;
    
    public XmlSedesDAO() {
    	this.sedes = new ArrayList<Sede>();
    }

	@Override
	public int add(Sede t) throws DuplicateEntityException {
		if(sedes.stream().filter(sede -> sede.getIdSede() == t.getIdSede()).findFirst().orElse(null) == null) {
			sedes.add(t);
			return t.getIdSede();
		}
		else throw new DuplicateEntityException();
	}

	@Override
	public void saveAll() {
	    String fileName = "Sedes.xml";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlSedesDAO.class);
			if(this.sedes != null){
	            FileOutputStream file = new FileOutputStream(fileName, false);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Sedes guardadas");
		}catch(Exception e){
            System.out.println("Error al guardar el fichero de sedes: " + e.getMessage());
		}
		
	}

	@Override
	public Sede get(String id) {
		int sedeId = Integer.parseInt(id);
		return sedes.stream().filter(sede -> sede.getIdSede() == sedeId).findFirst().orElse(null);
	}

	@Override
	public List<Sede> list() {
		return this.sedes;
	}

	@Override
	public boolean loadData() {

		String fileName = "Sedes.xml";
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlSedesDAO.class);
        	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream inStream = new FileInputStream(fileName);
            XmlSedesDAO sedesDAO = (XmlSedesDAO) jaxbUnmarshaller.unmarshal(inStream);
            this.sedes = sedesDAO.sedes;
            return true;
        }catch(FileNotFoundException e){
            //System.out.println("No hay sedes guardadas");
            return false;
        }catch(JAXBException e){
            //System.out.println("Error al leer fichero de sedes: " + e.getMessage());
            return false;
        }
	
		
	}

}
