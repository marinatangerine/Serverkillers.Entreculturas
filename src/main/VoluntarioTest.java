package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VoluntarioTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Before realizado");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After realizado");
	}

	@Test
	public void testSetAreaActividades() {
		Voluntario voluntario = new Voluntario();
		assertNotNull(voluntario);   
	}

	@Test 
	public void testVoluntario() {
		
		int pPersonId = 1;
		String pUserName = "J";
		String pPass = "0000";
		boolean bool = true;
		String pName = "Juan";
		String pAddress = "Barcelona, Spain";
		String pPhone = "93 0000000";
		int idVoluntario = 10;
		int idSede = 150;
		String areaActividades = "Talleres";
		
		Voluntario voluntario = new Voluntario(pPersonId, pUserName, pPass, bool, pName, pAddress, pPhone, areaActividades, areaActividades, idVoluntario, idSede, areaActividades);
		assertNotNull(voluntario);   

	}
	@Test 
	public void testsetAreaActividades() {
		String areaActividades = "Actividades Deportivas";
		assertNotNull(areaActividades);
	}
		
}
