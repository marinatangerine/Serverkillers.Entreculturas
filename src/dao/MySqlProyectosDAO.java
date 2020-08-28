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
import main.DuplicateEntityException;

import main.Proyecto;

public class MySqlProyectosDAO implements DAO<Proyecto>{

	@Override
	public void add(Proyecto t) throws DuplicateEntityException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Proyecto get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadData() {
		// TODO Auto-generated method stub
		return false;
	}

}
