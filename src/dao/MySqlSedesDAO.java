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
import main.Sede;

import main.DuplicateEntityException;

public class MySqlSedesDAO implements DAO<Sede> {

	@Override
	public void add(Sede t) throws DuplicateEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sede get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sede> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadData() {
		// TODO Auto-generated method stub
		return false;
	}

}
