package main.java.main;

import static org.junit.Assert.*;


import org.junit.Test;

public class VoluntarioTest {

	//Test para comprobar si los parametros añadidos al constructor lo inicializan correctamente
	
	@Test 
	public void testVoluntario() {
		
		int pPersonId = 1;
		String pUserName = "J";
		String pPass = "0000";
		boolean bool = true;
		String pName = "Juan";
		String pAddress = "Barcelona, Spain";
		String pPhone = "93 0000000";
		int idSede = 150;
		String areaActividades = "Talleres";
		
		Voluntario voluntario = new Voluntario(pPersonId, pUserName, pPass, bool, pName, pAddress, pPhone, areaActividades, areaActividades, idSede, areaActividades);
		assertNotNull(voluntario);   

		
	}
	
	
}
