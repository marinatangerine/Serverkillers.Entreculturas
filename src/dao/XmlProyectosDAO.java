/**
 * 
 */
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import main.DuplicateEntityException;
import main.Proyecto;

//* Carga los datos anteriores del Xml (para poder comprobar información de ellos y mostrarlo)
* Lista los datos de las personas guardadas
* Trata las excepciones definidas
* @versión 1.0 23/05/2020
* @author Serverkillers
*
*/
@XmlRootElement(name = "proyectos")
@XmlAccessorType (XmlAccessType.FIELD)

public class XmlProyectosDAO implements DAO<Proyecto> {
	   
    @XmlElement(name = "proyecto")
    public List<Proyecto> proyectos;
    
    public XmlProyectosDAO() {
    	this.proyectos = new ArrayList<Proyecto>();
    }

	@Override
	public void saveAll() {
	    String fileName = "Proyectos.xml";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlProyectosDAO.class);
			if(this.proyectos != null){
	            FileOutputStream file = new FileOutputStream(fileName, false);
	            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	            jaxbMarshaller.marshal(this, file); 
	        }
	        
	        System.out.println("Proyectos guardados");
		}catch(Exception e){
            System.out.println("Error al guardar el fichero de proyectos: " + e.getMessage());
		}
	}

	@Override
	public Proyecto get(String id) {
		int codProyecto = Integer.parseInt(id);
		return proyectos.stream().filter(proyecto -> proyecto.getCodProyecto() == codProyecto).findFirst().orElse(null);
	}

	@Override
	public List<Proyecto> list() {
        return this.proyectos;
	}

	@Override
	public void add(Proyecto t) throws DuplicateEntityException{
		if(proyectos.stream().filter(proyecto -> proyecto.getCodProyecto() == t.getCodProyecto()).findFirst().orElse(null) == null) {
			proyectos.add(t);
		}
		else throw new DuplicateEntityException();
	}
	
	@Override
	public boolean loadData() {
		String fileName = "Proyectos.xml";
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlPersonasDAO.class);
        	Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InputStream inStream = new FileInputStream(fileName);
            XmlProyectosDAO proyectosDAO = (XmlProyectosDAO) jaxbUnmarshaller.unmarshal(inStream);
            this.proyectos = proyectosDAO.proyectos;
            return true;
        }catch(FileNotFoundException e){
            //System.out.println("No hay proyectos guardados");
            return false;
        }catch(JAXBException e){
            //System.out.println("Error al leer fichero de proyectos: " + e.getMessage());
            return false;
        }
	}
}
