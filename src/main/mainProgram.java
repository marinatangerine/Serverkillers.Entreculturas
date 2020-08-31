package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DAOFactory;
import dao.DAO;

import dao.XmlPersonasDAO;
import dao.XmlProyectosDAO;
import dao.XmlSedesDAO;
import dao.XmlVoluntariosDAO;

import dao.MySqlPersonasDAO;
import dao.MySqlProyectosDAO;
import dao.MySqlSedesDAO;
import dao.MySqlVoluntariosDAO;


/**Programa principal que muestra varias opciones en un menú
 * Guarda información introducida por teclado en un Xml para cada clase
 * Carga el contenido del Xml 
 * Muestra por pantalla el contenido del Xml
 * @versión 1.0 23/05/2020
 * @author Serverkillers
 *
 */
public class mainProgram {
	private static DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> xmlpersonasDAO = (XmlPersonasDAO) xmlDAOFactory.getPersonasDAO();
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) xmlDAOFactory.getPersonasDAO();
	private static DAO<Voluntario> xmlvoluntariosDAO = (XmlVoluntariosDAO) xmlDAOFactory.getVoluntariosDAO();
	private static DAO<Voluntario> mysqlvoluntariosDAO = (MySqlVoluntariosDAO) xmlDAOFactory.getVoluntariosDAO();
	private static DAO<Sede> xmlsedesDAO = (XmlSedesDAO) xmlDAOFactory.getSedesDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) xmlDAOFactory.getSedesDAO();
	private static DAO<Proyecto> xmlproyectosDAO = (XmlProyectosDAO) xmlDAOFactory.getProyectosDAO();
	private static DAO<Proyecto> mysqlproyectosDAO = (MySqlProyectosDAO) xmlDAOFactory.getProyectosDAO();


	/**Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		//Carga los datos previos de personas, sedes y proyectos
		xmlpersonasDAO.loadData();
		xmlsedesDAO.loadData();
		xmlproyectosDAO.loadData();
		boolean exitMenu = false; //se inicializa la variable exitMenu para poder salir del flujo del programa cuando sea verdadera
		while(!exitMenu) {
			printMenu(); 
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt(); //se inicializa la variable option que se recoge por teclado
			switch(option) {
			case 1: //la opción 1 permite crear una nueva persona desde consola y guarda los datos en el Xml
				if(xmlsedesDAO.list().size() > 0) {
					Persona persona = createPersonaFromInput();
					System.out.println(persona);
					try {
						xmlpersonasDAO.add(persona);
						xmlpersonasDAO.saveAll();
					}
					catch(DuplicateEntityException ex) {//Con la excepción personalizada nos aseguramos que no existan personas duplicadas (mismo Id)
						System.out.println(ex.getMessage());
					}
				}
				else System.out.println("No hay sedes guardadas. Cree primero una sede para añadir una persona");
				break;
			case 2: //la opción 2 muestra los datos guardados en el Xml creado para personas
				ArrayList<Persona> personas = (ArrayList<Persona>) xmlpersonasDAO.list();
				if(personas.size() > 0) {
					for(int i = 0; i < personas.size(); i++) {
						Persona p = personas.get(i);
						Sede s = xmlsedesDAO.get(Integer.toString(p.getIdSede()));
						String strSede = ". Ciudad Sede: " + s.getCiudad();
						System.out.println(p + strSede);
					}
				}
				else System.out.println("No hay personas guardadas");
				break;
			case 3: //la opción 3 crea un nuevo voluntario desde consola y guarda los datos en el Xml
				if(xmlsedesDAO.list().size() > 0) {
					Voluntario voluntario = createVoluntarioFromInput();
					System.out.println(voluntario);
					try {
						xmlvoluntariosDAO.add(voluntario);
						xmlvoluntariosDAO.saveAll();
					}
					catch(DuplicateEntityException ex) {//Excepción que indica que es necesario crear una sede previamente a la que asociar a una persona (mismo Id)
						System.out.println(ex.getMessage());
					}
				}
				else System.out.println("No hay sedes guardadas. Cree primero una sede para añadir una persona");
				break;
			case 4: //la opción 4 muestra los datos guardados en el Xml creado para voluntarios
				ArrayList<Voluntario> voluntarios = (ArrayList<Voluntario>) xmlvoluntariosDAO.list();
				if(voluntarios.size() > 0) {
					for(int i = 0; i < voluntarios.size(); i++) {
						Voluntario v = voluntarios.get(i);
						Sede s = xmlsedesDAO.get(Integer.toString(v.getIdSede()));//Mostramos en el voluntario la sede a la que pertenece
						String strSede = ". Ciudad Sede: " + s.getCiudad();//Mostramos también la ciudad a la que pertenece la sede
						System.out.println(v + strSede);
					}
				}
				else System.out.println("No hay voluntarios guardados");
				break;
			case 5: //la opción 5 crea una nueva sede desde consola y guarda los datos en el Xml
				Sede sede = createSedeFromInput();
				System.out.println(sede);
				try {
					xmlsedesDAO.add(sede);
					xmlsedesDAO.saveAll();
				}
				catch(DuplicateEntityException ex) {//Utilizamos la excepción personalizada para que no existan sedes duplicadas (mismo Id)
					System.out.println(ex.getMessage());
				}
				break;
			case 6: //la opción 6 muestra los datos guardados en el Xml creado para sedes
				listSedes();
				break;
			case 7: //la opción 7 crea un nuevo proyecto desde consola y guarda los datos en el Xml
				if(xmlsedesDAO.list().size() > 0) {
					Proyecto proyecto = createProyectoFromInput();
					System.out.println(proyecto);
					try {
						xmlproyectosDAO.add(proyecto);
						xmlproyectosDAO.saveAll();
					}
					catch(DuplicateEntityException ex) { //Con esta excepción nos aseguramos que no existan proyectos con el mismo identificador
						System.out.println(ex.getMessage());
					}
				}
				else System.out.println("No hay sedes guardadas. Cree primero una sede para añadir un proyecto");
				break;
			case 8: //la opción 8 muestra los datos guardados en el Xml creado para proyectos
				ArrayList<Proyecto> proyectos = (ArrayList<Proyecto>) xmlproyectosDAO.list();
				if(proyectos.size() > 0) {
					for(int i = 0; i < proyectos.size(); i++) {
						Proyecto p = proyectos.get(i);
						Sede s = xmlsedesDAO.get(Integer.toString(p.getIdSede()));
						String strSede = ". Ciudad Sede: " + s.getCiudad();
						System.out.println(p + strSede);
					}
				}
				else System.out.println("No hay proyectos guardados");
				break;
			case 9: //la opción 9 es la salida del programa
				exitMenu = true;
				System.out.println("Hasta otra");
				break;
			default: 
				System.out.println("Introduce una opción válida");
			}
		}

	}
	//menú mostrado 
	public static void printMenu() {
		System.out.println("-----------------------------");
		System.out.println("Bienvenido/a a Entreculturas");
		System.out.println("-----------------------------");
		System.out.println("Seleccione una opción:");
		System.out.println("1. Crear una persona");
		System.out.println("2. Mostrar personas");
		System.out.println("3. Crear un voluntario");
		System.out.println("4. Mostrar voluntarios");
		System.out.println("5. Crear una sede");
		System.out.println("6. Mostrar sedes");
		System.out.println("7. Crear un proyecto");
		System.out.println("8. Mostrar proyectos");
		System.out.println("9. Salir");
	}
	/**
	 * Crea una persona a partir de los atributos definidos en la clase
	 * @param los atributos definidos en la clase persona
	 * @return una instancia de la clase persona
	 */
	public static Persona createPersonaFromInput() {
		Scanner scanner = new Scanner(System.in);
		Persona persona = new Persona();
		
		System.out.println("Identificador de persona: ");
		persona.setPersonId(scanner.nextInt());
		
		System.out.println("Nombre de usuario: ");
		persona.setUserName(scanner.next());
		
		System.out.println("Contraseña: ");
		persona.setPass(scanner.next());
		scanner.nextLine();
		
		System.out.println("Nombre: ");
		persona.setName(scanner.nextLine());
		
		System.out.println("Apellidos: ");
		persona.setSurname(scanner.nextLine());
		
		System.out.println("Dirección: ");
		persona.setAddress(scanner.nextLine());
		
		System.out.println("Teléfono: ");
		persona.setPhone(scanner.next());
		
		System.out.println("Email: ");
		persona.setEmail(scanner.next());
		
		System.out.println("¿Crear como administrador? S/N ");
		String input = "";
		while((!input.equalsIgnoreCase("S")) && (!input.equalsIgnoreCase("N"))) {
			input = scanner.next();
			switch(input.toUpperCase()) {
			case "S":
				persona.setAdmin(true);
				break;
			case "N":
				persona.setAdmin(false);
				break;
			default: 
				System.out.println("Escriba S/N");
			}
		}
		
		persona.setIdSede(selectSede());
		
		return persona;
	}
	
	/**
	 * Crea un voluntario a partir de los atributos definidos en la clase
	 * @param los atributos definidos en la clase voluntario más los que hereda de la clase persona
	 * @return una instancia de la clase voluntario
	 */
	public static Voluntario createVoluntarioFromInput() {
		Scanner scanner = new Scanner(System.in);
		Voluntario voluntario = new Voluntario(createPersonaFromInput());
		
		System.out.println("Número de voluntario: ");
		voluntario.setNumVoluntario(scanner.nextInt());
		
		scanner.nextLine();
		
		System.out.println("Área de actividad: ");
		voluntario.setAreaActividades(scanner.nextLine());
		
		return voluntario;
	}
	/**
	 * Crea una sede a partir de los atributos definidos en la clase
	 * @param los atributos definidos en la clase sede
	 * @return una instancia de la clase sede
	 */
	public static Sede createSedeFromInput() {
		Scanner scanner = new Scanner(System.in);
		Sede sede = new Sede();
		
		System.out.println("Identificador de Sede: ");
		sede.setIdSede(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Ciudad: ");
		sede.setCiudad(scanner.nextLine());
		
		System.out.println("Dirección: ");
		sede.setDireccion(scanner.nextLine());
		
		System.out.println("Teléfono: ");
		sede.setTelefono(scanner.next());
		
		System.out.println("Email: ");
		sede.setEmail(scanner.next());
		
		System.out.println("¿Crear como central? S/N ");
		String input = "";
		while((!input.equalsIgnoreCase("S")) && (!input.equalsIgnoreCase("N"))) {
			input = scanner.next();
			switch(input.toUpperCase()) {
			case "S":
				sede.setCentral(true);
				break;
			case "N":
				sede.setCentral(false);
				break;
			default: 
				System.out.println("Escriba S/N");
			}
		}
		return sede;
	}
	/**
	 * Crea una proyecto a partir de los atributos definidos en la clase
	 * @param los atributos definidos en la clase proyecto
	 * @return una instancia de la clase proyecto
	 */
	public static Proyecto createProyectoFromInput() {
		Scanner scanner = new Scanner(System.in);
		Proyecto proyecto = new Proyecto();
		
		System.out.println("Código del Proyecto: ");
		proyecto.setCodProyecto(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Nombre del Proyecto: ");
		proyecto.setNombre(scanner.nextLine());
		
		System.out.println("Línea de acción: ");
		proyecto.setLineaAccion(scanner.nextLine());
		
		System.out.println("Sublínea de acción: ");
		proyecto.setSubLinea(scanner.nextLine());
		
		System.out.println("País: ");
		proyecto.setPais(scanner.nextLine());
		
		System.out.println("Localización: ");
		proyecto.setLocalizacion(scanner.nextLine());
		
		System.out.println("Fecha de inicio: ");
		boolean dateOk = false;
		while(!dateOk) {
			try{
				proyecto.setFechaInicio(Utils.toDate(scanner.next()));
				dateOk = true;
			}
			catch(DateFormatException ex) { //Excepción personalizada para introducir la fecha en el formato adecuado
				System.out.println(ex.getMessage() + ". Vuelva a introducir la fecha.");
			}
		}
		
		System.out.println("Fecha de fin: ");
		dateOk = false;
		while(!dateOk) {
			try{
				proyecto.setFechaFin(Utils.toDate(scanner.next()));
				dateOk = true;
			}
			catch(DateFormatException ex) { //Exceoción personalizada para introducir la fecha en el formato adecuado
				System.out.println(ex.getMessage() + ". Vuelva a introducir la fecha.");
			}
		}
		
		System.out.println("Acciones: ");
		proyecto.setAcciones(scanner.next());
		
		proyecto.setIdSede(selectSede());
		return proyecto;
	}
	
	/**
	 * Lista las sedes guardadas
	 * @param Arraylist de sedes
	 */
	public static void listSedes() {
		ArrayList<Sede> sedes = (ArrayList<Sede>) xmlsedesDAO.list();
		if(sedes.size() > 0) {
			for(int i = 0; i < sedes.size(); i++) {
				System.out.println(sedes.get(i));
			}
		}
		else System.out.println("No hay sedes guardadas");
	}
	
	/**
	 * Muestra las sedes guardadas con todos sus datos para que el usuario pueda seleccionar la sede deseada
	 * @param método listSedes()
	 * @return identificador de la sede
	 */
	public static int selectSede() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione una sede");
		listSedes();
		int idSede = 0;
		boolean sedeOk = false;
		while(!sedeOk) {
			idSede = scanner.nextInt();
			Sede sede = xmlsedesDAO.get(Integer.toString(idSede));
			if(sede != null) {
				sedeOk = true;
			}
			else System.out.println("La sede seleccionada no existe. Por favor, introduzca el identificador de una sede de la lista");
		}
		return idSede;
	}
}
