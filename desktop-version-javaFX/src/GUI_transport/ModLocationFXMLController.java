/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;
import service_transport.Service_location;


public class ModLocationFXMLController implements Initializable {

    @FXML
    private TextField refModLoc;
    @FXML
    private TextField cinModLoc;
    @FXML
    private TextField matModLoc;
    @FXML
    private TextField durModLoc;
    @FXML
    private DatePicker pickModLoc;
    @FXML
    private DatePicker retModLoc;
    @FXML
    private Button btnModLoc;
    @FXML
    private Button previous4;
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
        cinModLoc.setTextFormatter(cinFormatter);
    }  
    @FXML
     private void btnModLoc(ActionEvent event) {
        String CinV=cinModLoc.getText();
        int cinV=Integer.parseInt(CinV);
        String matVeh=matModLoc.getText();
        int MatV=Integer.parseInt(matVeh);
        String refLoc=refModLoc.getText();
        int Ref=Integer.parseInt(refLoc);
        Vehicule v = new Vehicule ();
        v.setMatriculeV(MatV);
        Service_location sl = new Service_location();
        if (validateDates(pickModLoc.getValue().toString(), retModLoc.getValue().toString())) {
        sl.modifier_transport(new Location_vehicule(Ref,cinV,durModLoc.getText(),pickModLoc.getValue().toString(),retModLoc.getValue().toString(),v));
        }else{
            JOptionPane.showMessageDialog(null, "Dates invalides ");
        
        }
    }
     
     private boolean validateDates(String d1,String d2) {
        String dateStr1 = pickModLoc.getValue().toString();
        String dateStr2 = retModLoc.getValue().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          
      
        try {
             Date date1 = sdf.parse(dateStr1);
             Date date2 = sdf.parse(dateStr2);
        
                    return !date1.after(date2);
         
           
        } catch (Exception e) {
            return false;
        }
    
}

    void setReferenceloc(int refLocation) {
        refModLoc.setText(String.valueOf(refLocation));
    }

    void setCinloc(int cinVoy) {
        cinModLoc.setText(String.valueOf(cinVoy));
    }

    void setMatriculeLocation(int matloc) {
        matModLoc.setText(String.valueOf(matloc));
    }

    void setDureeLoc(String durloc) {
        durModLoc.setText(durloc);
    }

    void setpickdate(String datepick) {
       try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(datepick, formatter);
        pickModLoc.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
        
    }


    void setretdate(String dateret) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateret, formatter);
        retModLoc.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
    }

    @FXML
    private void previous4(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("AfficherLocationFXML.fxml"));
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
