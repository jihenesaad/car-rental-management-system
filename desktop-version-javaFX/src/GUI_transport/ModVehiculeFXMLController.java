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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModVehiculeFXMLController implements Initializable {

    
    @FXML
    private TextField TxtMatModif;
    @FXML
    private ComboBox cmbTypeModif;
    @FXML
    private ComboBox cmbMrqModif;
    @FXML 
    private Button btnSauvVeh;
    @FXML
    private Button previous2;

    public TextField getTxtMatModif() {
        return TxtMatModif;
    }

    public ComboBox getCmbTypeModif() {
        return cmbTypeModif;
    }

    public ComboBox getCmbMrqModif() {
        return cmbMrqModif;
    }

    public Button getBtnSauvVeh() {
        return btnSauvVeh;
    }

    public void setTxtMatModif(TextField TxtMatModif) {
        this.TxtMatModif = TxtMatModif;
    }

    public void setCmbTypeModif(ComboBox cmbTypeModif) {
        this.cmbTypeModif = cmbTypeModif;
    }

    public void setCmbMrqModif(ComboBox cmbMrqModif) {
        this.cmbMrqModif = cmbMrqModif;
    }

    public void setBtnSauvVeh(Button btnSauvVeh) {
        this.btnSauvVeh = btnSauvVeh;
    }
    
    public void initializeData(String selectedVehicule) {
    String[] lines = selectedVehicule.split("\n");
    Service_vehicule sv = new Service_vehicule();
    ModVehiculeFXMLController mod = new ModVehiculeFXMLController();
        String modmat = mod.getTxtMatModif().getText();
        int MOD = Integer.parseInt(modmat);
        String modtyp = mod.getCmbTypeModif().getSelectionModel().getSelectedItem().toString();
        String mrqtyp = mod.getCmbMrqModif().getSelectionModel().getSelectedItem().toString();
        
        Vehicule v = new Vehicule();
        mod.getTxtMatModif().setText(String.valueOf(MOD));
        mod.getCmbTypeModif().getItems().addAll(modtyp);
        mod.getCmbMrqModif().getItems().addAll(mrqtyp);

       
        
    }
    @FXML 
    private void btnSauvVeh(ActionEvent event){
      
        String Id2= TxtMatModif.getText();
        int id2 =Integer.parseInt(Id2);
        Service_vehicule sv = new Service_vehicule();
        Vehicule v = new Vehicule(cmbTypeModif.getSelectionModel().getSelectedItem().toString(),cmbMrqModif.getSelectionModel().getSelectedItem().toString(),id2);
        sv.modifier_vehicule(v);
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> LisTypev = FXCollections.observableArrayList("Voiture","Sprinter","Minibus");
        cmbTypeModif.setItems(LisTypev);
        ObservableList<String> ListMarquev = FXCollections.observableArrayList("KIA","Peugeot","Audi","Volkswagen");
        cmbMrqModif.setItems(ListMarquev);
    }    

    void setMatricule(int matVehicule) {
        TxtMatModif.setText(String.valueOf(matVehicule));
    }

    void setType(String typemod) {
        cmbTypeModif.setValue(typemod);
    }

    void setMarque(String marque) {
        cmbMrqModif.setValue(marque);
    }

    @FXML
    private void previous2(ActionEvent event) {
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
