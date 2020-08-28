package dao;

/*Devuelve el Xml DAO de cada entidad
 * @return Xml DAO de cada entidad (Persona, Voluntario, Sede y Proyecto)
 */
public class XmlDAOFactory extends DAOFactory {
	
	public XmlPersonasDAO getPersonasDAO() {
		return new XmlPersonasDAO();
	}
    
    public XmlVoluntariosDAO getVoluntariosDAO() {
        return new XmlVoluntariosDAO();
    }

	public XmlSedesDAO getSedesDAO() {
		return new XmlSedesDAO();
	}

	public XmlProyectosDAO getProyectosDAO() {
		return new XmlProyectosDAO();
	}
}
