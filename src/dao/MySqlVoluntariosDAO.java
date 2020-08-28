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
import main.Voluntario;
import main.DuplicateEntityException;

public class MySqlVoluntariosDAO implements DAO<Voluntario> {

	@Override
	public void add(Voluntario t) throws DuplicateEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Voluntario get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voluntario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadData() {
		// TODO Auto-generated method stub
		return false;
	}

}
