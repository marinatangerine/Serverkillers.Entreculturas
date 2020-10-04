package main.java.main;

import java.io.IOException;

import main.java.controller.MenuController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class Startup extends Application {
	
	private static MenuController controller;
	
	@Override
	public void start(Stage stage) throws IOException {
	  // set up the scene
	  FXMLLoader loader = new FXMLLoader(Startup.class.getResource("/view/MenuVista.fxml"));
	  Parent root = loader.load();
	  controller = loader.getController();
	  Scene scene = new Scene(root);

	  // set up the stage
	  stage.setTitle("Entreculturas");
	  stage.setScene(scene);
	  stage.show();
	}
	
	/**
	   * Stops and releases all resources used in application.
	   */
	  @Override
	  public void stop() {
	    controller.terminate();
	  }

	  /**
	   * Opens and runs application.
	   *
	   * @param args arguments passed to this application
	   */
	  public static void main(String[] args) {
	    Application.launch(args);
	  }
 
 
}