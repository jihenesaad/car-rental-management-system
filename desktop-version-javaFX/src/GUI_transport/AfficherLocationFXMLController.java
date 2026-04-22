/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import service_transport.Service_location;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AfficherLocationFXMLController implements Initializable {

    @FXML
    private Button actualiserLoc;
    @FXML
    private Button supprimerLoc;
    @FXML
    private ListView<String> ListLoc;
    @FXML
    private Button modifierLoc;
    @FXML
    private Button previous3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Service_location sv = new Service_location();
        ObservableList<String> itemslocation = FXCollections.observableArrayList();

        // Convertissez les données vehicule en chaînes
        List<Location_vehicule> locations = sv.afficher_Location();
        for (Location_vehicule lv : locations) {
        String RefStr = "Référence : "+ String.valueOf(lv.getRefLoc());  
        String CinStr = "Cin voyageur : "+ String.valueOf(lv.getCin_client_vehicule()); 
        String durStr = "Durée de location : "+ lv.getDuree_loc_vehicule();
        String pickStr = "Date de récupération : "+ lv.getPickup_vehicule();
        String retStr = "Date de retour : "+ lv.getReturn_vehicule();
        String matStr = "Matricule du véhicule associé : "+ String.valueOf(lv.getVehicule().getMatriculeV()); 


        
        String locationString = RefStr +"\n"+ CinStr + "\n" + durStr+"\n"+ pickStr + "\n" + retStr+ "\n" + matStr;


            itemslocation.add(locationString);
        }
       ListLoc.setItems(itemslocation);
    }    

    @FXML
    private void actualiserLoc(ActionEvent event) {
        Service_location sv = new Service_location();
        ObservableList<String> itemslocation = FXCollections.observableArrayList();

        // Convertissez les données vehicule en chaînes
        List<Location_vehicule> locations = sv.afficher_Location();
        for (Location_vehicule lv : locations) {
        String RefStr = "Référence : "+ String.valueOf(lv.getRefLoc());  
        String CinStr = "Cin client : "+ String.valueOf(lv.getCin_client_vehicule()); 
        String durStr = "Durée de location : "+ lv.getDuree_loc_vehicule();
        String pickStr = "Date de récuperation : "+ lv.getPickup_vehicule();
        String retStr = "Date de récuperation : "+ lv.getReturn_vehicule();
        String matStr = "Matricule du véhicule associé : "+ String.valueOf(lv.getVehicule().getMatriculeV()); 


        
        String locationString = RefStr +"\n"+ CinStr + "\n" + durStr+"\n"+ pickStr + "\n" + retStr+ "\n" + matStr;


            itemslocation.add(locationString);
        }
       ListLoc.setItems(itemslocation);
    }

    @FXML
    private void supprimerLoc(ActionEvent event) {
        Service_location sv = new Service_location();
        int selectedIndex = ListLoc.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedLocation = ListLoc.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient la matricule
        String[] lines = selectedLocation.split("\n");
        String refLocationLine = null;
        for (String line : lines) {
            if (line.startsWith("Référence :")) {
                refLocationLine = line;
                break;
            }
        }

        if (refLocationLine != null) {
            // Extrait le numéro de facture de la ligne
            String refLocation = refLocationLine.replace("Référence :", "").trim();

            // Convertissez le numéro de facture en int
            int idLocation = Integer.parseInt(refLocation);

            // Supprimez la facture de la base de données
            sv.supprimer_transport(idLocation);

            // Supprimez l'élément de la ListView
            ListLoc.getItems().remove(selectedIndex);
    }}
    }

    @FXML
    private void modifierLoc(ActionEvent event) {
          String selectedItem = ListLoc.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModLocationFXML.fxml"));
        Parent root = loader.load();
        ModLocationFXMLController modLocController = loader.getController(); // Obtenez le contrôleur de l'interface de modification
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        // Obtenez les données de la ligne sélectionnée et remplissez les champs de l'interface de modification
        // Vous devrez peut-être analyser la chaîne pour extraire les données
        String[] data = selectedItem.split("\n");
        // Exemple : numFactureLine doit être de la forme "Numéro de facture : 123"
       
for (String line : data) {
    if (line.startsWith("Référence :")) {
        int refLocation = Integer.parseInt(line.replace("Référence : ", "").trim());
        modLocController.setReferenceloc(refLocation);
    } else if (line.startsWith("Cin voyageur :")) {
        int cinVoy = Integer.parseInt(line.replace("Cin voyageur : ", "").trim());
        modLocController.setCinloc(cinVoy);
    } else if (line.startsWith("Matricule du véhicule associé :")) {
        int matloc = Integer.parseInt(line.replace("Matricule du véhicule associé : ", "").trim());
        modLocController.setMatriculeLocation(matloc);
    } else if (line.startsWith("Durée de location :")) {
        String durloc = String.valueOf(line.replace("Durée de location : ", "").trim());
        modLocController.setDureeLoc(durloc);
    } else if (line.startsWith("Date de récupération :")) {
        String datepick = String.valueOf(line.replace("Date de récupération : ", "").trim());
        modLocController.setpickdate(datepick);
    } else if (line.startsWith("Date de retour :")) {
        String dateret = String.valueOf(line.replace("Date de retour : ", "").trim());
        modLocController.setretdate(dateret);
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
    private void previous3(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AjouterLocationFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Ajouter une location");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherVehiculeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
    
}
