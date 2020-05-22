package dao;

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBException;
import main.Sede;
import java.util.List;

public interface ISedesDAO {
	public void savePersonas() throws JAXBException, FileNotFoundException;
    public List<Sede> getPersonas() throws JAXBException, FileNotFoundException;
}
