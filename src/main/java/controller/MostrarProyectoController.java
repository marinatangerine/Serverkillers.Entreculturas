package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.java.dao.DAO;
import main.java.dao.DAOFactory;
import main.java.dao.MySqlPersonasDAO;
import main.java.dao.MySqlProyectosDAO;
import main.java.dao.MySqlSedesDAO;
import main.java.model.Persona;
import main.java.model.Proyecto;
import main.java.model.Sede;

public class MostrarProyectoController implements Initializable{
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	private static DAO<Proyecto> mysqlproyectosDAO = (MySqlProyectosDAO) MySqlDAOFactory.getProyectosDAO();
	
	@FXML
	private TableView<Proyecto> tablaProyecto;
	
	@FXML
	private TableColumn<Proyecto, Integer> columnId;
	
	@FXML
	private TableColumn<Proyecto, String> columnNombre;
	
	@FXML
	private TableColumn<Proyecto, String> columnLineaAccion;
	
	@FXML
	private TableColumn<Proyecto, String> columnSublinea;
	
	@FXML
	private TableColumn<Proyecto, String> columnPais;
	
	@FXML
	private TableColumn<Proyecto, String> columnLocalizacion;
	
	@FXML
	private TableColumn<Proyecto, LocalDate> columnFechaInicio;
	
	@FXML
	private TableColumn<Proyecto, LocalDate> columnFechaFin;
	
	@FXML
	private TableColumn<Proyecto, String> columnAcciones;
	
	@FXML
	private TableColumn<Proyecto, Integer> columnSede;
	
	
	@FXML
	private Button inicio;
	
	@FXML
	ObservableList<Proyecto> proyectoList; 
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mysqlproyectosDAO.loadData();

		columnId.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("codProyecto"));
		columnNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nombre"));
		columnLineaAccion.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("lineaAccion"));
		columnSublinea.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("subLinea"));
		columnPais.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("pais"));
		columnLocalizacion.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("localizacion"));
		columnFechaInicio.setCellValueFactory(new PropertyValueFactory<Proyecto, LocalDate>("fechaInicio"));
		columnFechaFin.setCellValueFactory(new PropertyValueFactory<Proyecto, LocalDate>("fechaFin"));
		columnAcciones.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("acciones"));
		columnSede.setCellValueFactory(new PropertyValueFactory<Proyecto, Integer>("idSede"));
		
		proyectoList = FXCollections.observableArrayList(mysqlproyectosDAO.list());
		
		tablaProyecto.setItems(proyectoList);
		
	}
	
	public void salir(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}

	@FXML 
	private void inicio(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
		Parent root = loader.load();
		MenuController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.inicio.getScene().getWindow();
		myStage.close();
		
		
	}

	public void terminate() {
		// TODO Auto-generated method stub
		
	}

	public Object closeWindow() {
		// TODO Auto-generated method stub
		return null;
	}
}
