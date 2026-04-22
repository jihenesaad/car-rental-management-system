/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import entities_transport.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.ConditionalFeature.FXML;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VehiculeFXMLController implements Initializable {

    @FXML
    private TextField TxtMatV;
    @FXML
    private ComboBox cmbTypeV;
    @FXML
    private ComboBox cmbMrqV;
    @FXML
    private Button btnEngV;
    @FXML
    private Button menu;
    @FXML
    private Button vehicules;

    public TextField getTxtMatV() {
        return TxtMatV;
    }

    public ComboBox getCmbTypeV() {
        return cmbTypeV;
    }

    public ComboBox getCmbMrqV() {
        return cmbMrqV;
    }

    public void setTxtMatV(TextField TxtMatV) {
        this.TxtMatV = TxtMatV;
    }

    public void setCmbTypeV(ComboBox cmbTypeV) {
        this.cmbTypeV = cmbTypeV;
    }

    public void setCmbMrqV(ComboBox cmbMrqV) {
        this.cmbMrqV = cmbMrqV;
    }
    
    
   

    
    
       
    @FXML
    private void btnEngV(ActionEvent event) {
        String matriculeText = TxtMatV.getText().trim();

         // Vérifiez si les champs sont vides
    if (matriculeText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez saisir la matricule", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
    
    }else{
        String MATv=TxtMatV.getText();
        int matriV=Integer.parseInt(MATv);
        Service_vehicule sv = new Service_vehicule();
        sv.ajouter_vehicule(new Vehicule(cmbTypeV.getSelectionModel().getSelectedItem().toString(),cmbMrqV.getSelectionModel().getSelectedItem().toString(),matriV));
          
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AfficherVehiculeFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Liste des véhicules");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }
       
     
      
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> LisTypev = FXCollections.observableArrayList("Voiture","Sprinter","Minibus");
        cmbTypeV.setItems(LisTypev);
        ObservableList<String> ListMarquev = FXCollections.observableArrayList("KIA","Peugeot","Audi","Volkswagen");
        cmbMrqV.setItems(ListMarquev);
        
    }  

    @FXML
    private void menu(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("menu.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Liste des véhicules");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    @FXML
    private void vehicules(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AfficherVehiculeFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Liste des véhicules");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
    
    

   

    
}
