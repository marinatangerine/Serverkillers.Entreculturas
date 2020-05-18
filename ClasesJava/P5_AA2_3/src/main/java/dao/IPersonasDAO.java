/**
 * 
 */
package dao;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import clasesP5_AA2.Persona;
import java.util.List;

/**
 * @author suare
 *
 */
public interface IPersonasDAO {
	public void savePersonas() throws JAXBException, FileNotFoundException;
    public List<Persona> getPersonas() throws JAXBException, FileNotFoundException;
}
