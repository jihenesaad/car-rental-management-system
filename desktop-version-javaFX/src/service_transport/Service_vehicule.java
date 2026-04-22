/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_transport;

import DB_transport.Connexion_transport;
import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Service_vehicule implements IService_vehicule {
    Connection cnx = Connexion_transport.getInstance().getCnx();
    

    @Override
    public void ajouter_vehicule(Vehicule v) {
         String req = "INSERT INTO `vehicule`(`type_vehicule`, `marque_vehicule`, `matricule`)VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, v.getType_vehicule());
            ps.setString(2, v.getMarque());
            ps.setInt(3, v.getMatriculeV());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vehicule ajoutée avec succès!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ajout echoué!");
        } 
        
    }

    @Override
    public void modifier_vehicule(Vehicule v) {
         String req = "UPDATE `vehicule` SET `type_vehicule`=?,`marque_vehicule`=? WHERE `matricule`= ?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setString(1, v.getType_vehicule());
        ps.setString(2, v.getMarque());
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        ps.setInt(3, v.getMatriculeV());
        
       
        int res = ps.executeUpdate();

        if (res== 0) {
        JOptionPane.showMessageDialog(null, "Véhicule avec Matricule " + v.getMatriculeV() + " n'existe pas");
           
        } else {
       JOptionPane.showMessageDialog(null, "Véhicule avec Matricule " + v.getMatriculeV() + " est modifiée avec succès!");
           
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Modification echouée");
    }
    }
    public void supprimer_vehicule(int mt_v) {
        
        String req = "DELETE FROM `vehicule` WHERE `matricule`=?";
            try{
                
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, mt_v);
            
           int res =ps.executeUpdate();
           if(res==0){
                JOptionPane.showMessageDialog(null, "Suppression echouée");
           }
           else{JOptionPane.showMessageDialog(null, "Supprimé avec succès");
           }        
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Echec");
        }
    }
     public List<Vehicule> afficher_vehicule(){
        List<Vehicule> vehicules = new ArrayList<>();
         //1
         String req = "SELECT `type_vehicule`, `marque_vehicule`, `matricule` FROM vehicule";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vehicule v = new Vehicule();
                //v.setId_vehicle(rs.getInt("id_vehicule"));
                v.setType_vehicule(rs.getString("type_vehicule"));
                v.setMarque(rs.getString("marque_vehicule"));
                v.setMatriculeV(rs.getInt("matricule"));

                vehicules.add(v);
                System.out.println(v);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_location.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return vehicules;
    }
     
    
}
