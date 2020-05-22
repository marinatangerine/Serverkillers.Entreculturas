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

import main.Sede;

@XmlRootElement(name = "sedes")
@XmlAccessorType (XmlAccessType.FIELD)
public class XmlSedesDAO implements DAO<Sede> {
	
    @XmlElement(name = "sede")
    public List<Sede> sedes;
    
    public XmlSedesDAO() {
    	this.sedes = new ArrayList<Sede>();
    }

	@Override
	public void add(Sede t) {
		sedes.add(t);
		
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
	public Optional<Sede> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Sede t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Sede t) {
		// TODO Auto-generated method stub
		
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
