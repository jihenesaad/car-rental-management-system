/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import entities_transport.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AfficherVehiculeFXMLController implements Initializable {

    @FXML
    private Button supprimerVeh;
    @FXML
    private Button actualiserVeh;
    @FXML
    private ListView<String> ListVeh;
    @FXML
    private Button modifierVeh;
    @FXML
    private Button previousVeh;

    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Service_vehicule sv = new Service_vehicule();
        List<Vehicule> vehicules = sv.afficher_vehicule();
        // Convertissez les données vehicule en chaînes
        List<String> itemsvehicule= new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
        String matStr = "Matricule : "+ String.valueOf(vehicule.getMatriculeV());    
        String typeStr = "Type de véhicule : " +vehicule.getType_vehicule();
        String marqueStr = "Marque : "+ vehicule.getMarque();
        String vehiculeString = matStr+"\n"+ typeStr +"\n"+ marqueStr;


            itemsvehicule.add(vehiculeString);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(itemsvehicule);
       ListVeh.setItems( observableList);
    }    

    @FXML
    private void supprimerVeh(ActionEvent event) {
        Service_vehicule sv = new Service_vehicule();
        int selectedIndex = ListVeh.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedVehicule = ListVeh.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient la matricule
        String[] lines = selectedVehicule.split("\n");
        String matVehiculeLine = null;
        for (String line : lines) {
            if (line.startsWith("Matricule :")) {
                matVehiculeLine = line;
                break;
            }
        }

        if (matVehiculeLine != null) {
            // Extrait le numéro de facture de la ligne
            String matVehicule = matVehiculeLine.replace("Matricule :", "").trim();

            // Convertissez le numéro de facture en int
            int idVehicule = Integer.parseInt(matVehicule);

            // Supprimez la facture de la base de données
            sv.supprimer_vehicule(idVehicule);

            // Supprimez l'élément de la ListView
            ListVeh.getItems().remove(selectedIndex);
    }}}
    
    @FXML
    private void actualiserVeh(ActionEvent event) {
        Service_vehicule sv = new Service_vehicule();
        List<Vehicule> vehicules = sv.afficher_vehicule();
        // Convertissez les données vehicule en chaînes
        List<String> itemsvehicule= new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
        String matStr = "Matricule : "+ String.valueOf(vehicule.getMatriculeV());    
        String typeStr = "Type de véhicule : " +vehicule.getType_vehicule();
        String marqueStr = "Marque : "+ vehicule.getMarque();
        String vehiculeString = matStr+"\n"+ typeStr +"\n"+ marqueStr;


            itemsvehicule.add(vehiculeString);
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(itemsvehicule);
       ListVeh.setItems( observableList);
    }
    
    @FXML
    private void modifierVeh(ActionEvent event) {
       String selectedItem = ListVeh.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModVehiculeFXML.fxml"));
        Parent root = loader.load();
        ModVehiculeFXMLController modVehController = loader.getController(); // Obtenez le contrôleur de l'interface de modification
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        // Obtenez les données de la ligne sélectionnée et remplissez les champs de l'interface de modification
        // Vous devrez peut-être analyser la chaîne pour extraire les données
        String[] data = selectedItem.split("\n");
        // Exemple : numFactureLine doit être de la forme "Numéro de facture : 123"
       
for (String line : data) {
    if (line.startsWith("Matricule :")) {
        int matVehicule = Integer.parseInt(line.replace("Matricule : ", "").trim());
        modVehController.setMatricule(matVehicule);
    } else if (line.startsWith("Type de véhicule :")) {
        String typemod = String.valueOf(line.replace("Type de véhicule : ", "").trim());
        modVehController.setType(typemod);
    } else if (line.startsWith("Marque :")) {
        String marque = String.valueOf(line.replace("Marque : ", "").trim());
        modVehController.setMarque(marque);
    } 
}

        // Faites de même pour les autres données (montant, référence, date de paiement, etc.)

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    }

    @FXML
    private void previousVeh(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("VehiculeFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Ajouter un véhicule");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }
}
    
    
    


            
    

