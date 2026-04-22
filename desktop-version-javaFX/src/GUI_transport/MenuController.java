/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MenuController implements Initializable {

    @FXML
    private Button gestionVeh;
    @FXML
    private Button gestionLoc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionVeh(ActionEvent event) {
          try{
            Parent parent2=FXMLLoader .load(getClass().getResource("vehiculeFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Ajouter un véhicule");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }

    @FXML
    private void gestionLoc(ActionEvent event) {
          try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AjouterLocationFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Ajouter une location ");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }
    
}
