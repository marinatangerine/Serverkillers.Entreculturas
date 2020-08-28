package dao;

/*Devuelve el SQL DAO de cada entidad
 * @return SQL DAO de cada entidad (Persona, Voluntario, Sede y Proyecto)
 */

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public MySqlPersonasDAO getPersonasDAO() {
		return new MySqlPersonasDAO();
	}

	@Override
	public MySqlSedesDAO getSedesDAO() {
		return new MySqlSedesDAO();
	}

	@Override
	public MySqlVoluntariosDAO getVoluntariosDAO() {
		return new MySqlVoluntariosDAO();
	}

	@Override
	public MySqlProyectosDAO getProyectosDAO() {
		return new MySqlProyectosDAO();
	}

}
