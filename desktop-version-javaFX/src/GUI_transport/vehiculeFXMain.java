/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class vehiculeFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Louer un véhicule");
            primaryStage.show();
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }
    
    /*public void start(Stage primaryStage) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("ModVehiculeFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Modifier un véhicule");
            primaryStage.show();
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }*/
    
    /*public void start(Stage primaryStage) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherVehiculeFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Affiche véhicule");
            primaryStage.show();
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }*/
    /*public void start(Stage primaryStage) {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("ModVehiculeFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Louer un véhicule");
            primaryStage.show();
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }*/
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
