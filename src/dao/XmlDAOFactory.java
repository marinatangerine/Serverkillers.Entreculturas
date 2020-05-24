package dao;

/*Devuelve el Xml DAO de cada entidad
 * @return Xml DAO de cada entidad (Persona, Voluntario, Sede y Proyecto)
 */
public class XmlDAOFactory extends DAOFactory {
	
	public XmlPersonasDAO getXmlPersonasDAO() {
		return new XmlPersonasDAO();
	}
    
    public XmlVoluntariosDAO getXmlVoluntariosDAO() {
        return new XmlVoluntariosDAO();
    }

	public XmlSedesDAO getXmlSedesDAO() {
		return new XmlSedesDAO();
	}

	public XmlProyectosDAO getXmlProyectosDAO() {
		return new XmlProyectosDAO();
	}
}
