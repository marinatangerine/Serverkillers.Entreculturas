package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import main.DatabaseUtil;
import main.DuplicateEntityException;

import main.Proyecto;

public class MySqlProyectosDAO implements DAO<Proyecto>{

	public List<Proyecto> proyectos; //Arraylist de Proyecto
	
	@Override
	public int add(Proyecto proyecto) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		int newId = -1;
		String query = "call insertProyecto(?, ? , ?, ?, ?, ?, ?, ?, ?, @id)";
		try {
			PreparedStatement st = cn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, proyecto.getNombre());
			st.setString(2, proyecto.getLineaAccion());
			st.setString(3, proyecto.getSubLinea());
			st.setString(4, proyecto.getPais());
			st.setString(5, proyecto.getLocalizacion());
			st.setObject(6, proyecto.getFechaInicio());
			st.setObject(7, proyecto.getFechaFin());
			st.setString(8, proyecto.getAcciones());
			st.setInt(9, proyecto.getIdSede());
			
			st.executeQuery();
			Statement st1 = cn.createStatement();
			ResultSet rs = st1.executeQuery("select @id");
			if(rs.next()) {
				newId = rs.getInt(1);
			}
			cn.close();
			loadData();
			return newId;
		}
		catch(SQLException e) {
			System.out.print("Error al insertar los datos del proyecto: " + e.getMessage());
			return newId;
		}
	}

	@Override
	public void saveAll() {
		// No se utiliza con MySQL
		
	}

	@Override
	public Proyecto get(String id) {
		int codProyecto = Integer.parseInt(id);
		return proyectos.stream().filter(proyecto -> proyecto.getCodProyecto() == codProyecto).findFirst().orElse(null);
	}

	@Override
	public List<Proyecto> list() {
		return this.proyectos;
	}

	@Override
	public boolean loadData() {
		proyectos = new ArrayList<Proyecto>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM proyecto");
			while (rs.next()) {
				Proyecto proyecto = new Proyecto();
				proyecto.setCodProyecto(rs.getInt("codProyecto"));
				proyecto.setNombre(rs.getNString("nombre"));
				proyecto.setLineaAccion(rs.getNString("lineaAccion"));
				proyecto.setSubLinea(rs.getNString("subLinea"));
				proyecto.setPais(rs.getNString("pais"));
				proyecto.setLocalizacion(rs.getNString("localizacion"));
				proyecto.setFechaInicio(rs.getObject("fechaInicio", LocalDate.class));
				proyecto.setFechaFin(rs.getObject("fechaFin", LocalDate.class));
				proyecto.setAcciones(rs.getNString("acciones"));
				proyecto.setIdSede(rs.getInt("fk_sedeProyecto"));
				
				proyectos.add(proyecto);
			}
			cn.close();
			return true;
		}
		catch(SQLException e) {
			System.out.print("Error al obtener los datos de proyectos: " + e.getMessage());
			return false;
		}
	}
}
