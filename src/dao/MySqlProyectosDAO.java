package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import main.DatabaseUtil;
import main.DuplicateEntityException;

import main.Proyecto;

public class MySqlProyectosDAO implements DAO<Proyecto>{

	public List<Proyectos> proyectos; //Arraylist de Proyecto
	
	@Override
	public void add(Proyecto proyecto) throws DuplicateEntityException {
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dbUtils.connect();
		String query = "insert into proyecto (nombre, lineaAccion, subLinea, pais, localizacion, fechaInicio, fechaFin, acciones, fk_sedeProyecto) values (?, ? , ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = cn.prepareStatement(query);
			st.setString(1, proyecto.getNombre());
			st.setString(2, proyecto.getLineaAccion());
			st.setString(3, proyecto.getSubLinea());
			st.setString(4, proyecto.getPais());
			st.setString(5, proyecto.getLocalizacion());
			st.setDate(6, proyecto.getFechaInicio());
			st.setDate(7, proyecto.getFechaFin());
			st.setString(8, proyecto.getAcciones());
			st.setInt(9, proyecto.getIdSede());
			
			st.execute();
			cn.close();
		}
		catch(SQLException e) {
			System.out.print("Error al insertar los datos del proyecto: " + e.getMessage());
		}
	}

	@Override
	public void saveAll() {
		// Not used in MySQL
		
	}

	@Override
	public Proyecto get(String id) {
		int codProyecto = Integer.parseInt(id);
		return proyectos.stream().filler(proyecto -> proyecto.getCodProyecto() == codProyecto).findFirst().orElse(null);
	}

	@Override
	public List<Proyecto> list() {
		return this.proyectos;
	}

	@Override
	public boolean loadData() {
		proyectos = new ArrayList<Proyecto>();
		DatabaseUtil dbUtils = new DatabaseUtil();
		Connection cn = dnUtils.connect();
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM proyecto");
			while (rs.next()) {
				Proyecto proyecto =new Proyecto();
				proyecto.setCodProyecto(rs.getInt("codProyecto"));
				proyecto.setNombre(rs.getString("nombre"));
				proyecto.setLineaAccion(rs.getString("lineaAccion"));
				proyecto.setSubLinea(rs.getString("subLinea"));
				proyecto.setPais(rs.getString("pais"));
				proyecto.setLocalizacion(rs.getString("localizacion"));
				proyecto.setFechaInicio(rs.getDate("fechaInicio"));
				proyecto.setFechaFin(rs.getDate("fechaFin"));
				proyecto.setAcciones(rs.setString("acciones"));
				proyecto.setIdSede(rs.setString("fk_sedeProyecto"));
				
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
