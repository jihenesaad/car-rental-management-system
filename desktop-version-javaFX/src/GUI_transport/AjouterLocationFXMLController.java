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
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;
import service_transport.Service_location;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterLocationFXMLController implements Initializable {

    @FXML
    private TextField TxtdureeVeh;
    @FXML
    private TextField TxtCinVeh;
    @FXML
    private TextField TxtMatLoc;
    @FXML
    private TextField refLocation;
    @FXML
    private DatePicker pickVeh;
    @FXML
    private DatePicker returnVeh;
    @FXML
    private Button btnConfVeh;
    @FXML
    private Button menu2;
    @FXML
    private Button locations;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TextFormatter<Integer> cinFormatter = new TextFormatter<>(new IntegerStringConverter(), null, change -> {
        if (change.isContentChange()) {
            String newText = change.getControlNewText();
            if (newText.length() <= 8) {
                return change;
            }
        }
        return null;
    });
        TxtCinVeh.setTextFormatter(cinFormatter);
    }  
    @FXML
     private void btnConfVeh(ActionEvent event) {
     String matriculeText = TxtMatLoc.getText().trim();
String cinText = TxtCinVeh.getText().trim();
String refText = refLocation.getText().trim();
String dureeText = TxtdureeVeh.getText().trim();
//String picktText = pickVeh.getValue().toString();
//String returnText = returnVeh.getValue().toString();

// Vérifiez si les champs sont vides
if (cinText.isEmpty() || matriculeText.isEmpty() || refText.isEmpty() || dureeText.isEmpty() ) {
    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
}else{
        String CinV=TxtCinVeh.getText();
        int cinV=Integer.parseInt(CinV);
        String matVeh=TxtMatLoc.getText();
        int MatV=Integer.parseInt(matVeh);
        String refLoc=refLocation.getText();
        int Ref=Integer.parseInt(refLoc);
        Vehicule v = new Vehicule ();
        v.setMatriculeV(MatV);
        Service_location sl = new Service_location();
       
        if (validateDates(pickVeh.getValue().toString(), returnVeh.getValue().toString())) {
        sl.ajouter_transport(new Location_vehicule(Ref,cinV,TxtdureeVeh.getText(),pickVeh.getValue().toString(),returnVeh.getValue().toString(),v));
        
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AfficherLocationFXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene); 
            stage.setTitle("Liste des locations");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AfficherLocationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
        }else{
            JOptionPane.showMessageDialog(null, "Dates invalides ");
        
        }
    }}
      private boolean validateDates(String d1,String d2) {
        String dateStr1 = pickVeh.getValue().toString();
        String dateStr2 = returnVeh.getValue().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          
      
        try {
             Date date1 = sdf.parse(dateStr1);
             Date date2 = sdf.parse(dateStr2);
        
                    return !date1.after(date2);
         
           
        } catch (Exception e) {
            return false;
        }
    
}

    @FXML
    private void menu2(ActionEvent event) {
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
    private void locations(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AfficherLocationFXML.fxml"));
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
