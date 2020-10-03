package main.java.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import main.java.model.Persona;

//Test para comprobar si los objetos de la clase "Persona" se suman correctamente en su ArrayList

public class PersonaTest {

	@Test
	public void testAdd() throws JAXBException {
		
		// Inicializamos tres trabajadores que utilizaremos para las pruebas.
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		
		// Creamos un listado de personas.
		List<Persona> listadoPersonas = new ArrayList<Persona>();
		assertEquals(0, listadoPersonas.size());
		//Agregamos los objetos pasados como parametros a la lista en "add()"
		listadoPersonas.add(p1); 
		assertEquals(1, listadoPersonas.size()); 
		listadoPersonas.add(p2);
		assertEquals(2, listadoPersonas.size());
		listadoPersonas.add(p3);
		assertEquals(3, listadoPersonas.size());

	}

}
