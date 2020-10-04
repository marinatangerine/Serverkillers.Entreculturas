package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.main.DuplicateEntityException;
import main.java.model.Persona;
import main.java.model.Proyecto;
import main.java.model.Sede;
import main.java.dao.DAO;
import main.java.dao.DAOFactory;
import main.java.dao.MySqlPersonasDAO;
import main.java.dao.MySqlProyectosDAO;
import main.java.dao.MySqlSedesDAO;

public class CrearProyectoController implements Initializable {
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	private static DAO<Proyecto> mysqlproyectosDAO = (MySqlProyectosDAO) MySqlDAOFactory.getProyectosDAO();
	
	
	@FXML
	ObservableList<Integer> sedeList;
	
	@FXML
	private TextField nombreProyecto;
	
	@FXML
	private TextField lineaAccion;
	
	@FXML
	private TextField sublinea;
	
	@FXML
	private TextField acciones;
	
	@FXML
	private TextField pais;
	
	@FXML
	private TextField localizacion;
	
	@FXML
	private DatePicker fechaInicio;
	
	@FXML
	private DatePicker fechaFin;
	
	@FXML 
	private Button inicio;
	
	@FXML 
	private Button guardar;
	
	
	@FXML 
	private ChoiceBox sede;
	
	
	

	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mysqlsedesDAO.loadData();
		List<Integer> idSedes = mysqlsedesDAO.list().stream().map(Sede::getIdSede).collect(Collectors.toList());
		sedeList = FXCollections.observableArrayList(idSedes);
		sede.setItems(sedeList);
		
	}
	
	
	@FXML
	private void guardar(ActionEvent event) throws DuplicateEntityException, IOException {
		String nombre = this.nombreProyecto.getText();
		String lineaAccion = this.lineaAccion.getText();
		String subLinea = this.sublinea.getText();
		String acciones = this.acciones.getText();
		String pais = this.pais.getText();
		String localizacion = this.localizacion.getText();
		LocalDate fechaInicio = this.fechaInicio.getValue();
		LocalDate fechaFin = this.fechaFin.getValue();
		Integer idSede = Integer.parseInt(this.sede.getSelectionModel().getSelectedItem().toString());
		
		Proyecto proyecto = new Proyecto(nombre, lineaAccion, subLinea, pais, localizacion, fechaInicio, fechaFin, acciones,idSede);
		mysqlproyectosDAO.add(proyecto);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
		Parent root = loader.load();
		MenuController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.guardar.getScene().getWindow();
		myStage.close();
		
	}
	

	
	
	@FXML
	public void closeWindow() {
		
		
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
	

	
	
	@FXML
	public void terminate() {
		// TODO Auto-generated method stub
		
	}


}
