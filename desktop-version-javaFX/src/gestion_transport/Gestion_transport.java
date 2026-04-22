/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_transport;

import DB_transport.Connexion_transport;
import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import service_transport.Service_location;
import service_transport.IService_vehicule;
import service_transport.IService_location;
import service_transport.Service_vehicule;


/**
 *
 * @author HP
 */
public class Gestion_transport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion_transport.getInstance();
        //Location_vehicule lv = new Location_vehicule(1478965,"5 jours","1 avril","5 avril",4);
        
        //sl.ajouter_transport(lv);
        //Location_vehicule lv1 = new Location_vehicule(12,5536,"25 jours","3 mai","27 mai",2);
        //Service_location sl1 = new Service_location();
       // sl1.modifier_transport(lv1);
        //List<Location_vehicule> locs = new ArrayList<>();
       // Service_location s2 = new Service_location();
        //s2.afficher_Location();
        
        //Vehicule v = new Vehicule(4,"sprinter","Audi",6784);
        //Vehicule v1 = new Vehicule("van","Mercedes");
        //Service_vehicule sv = new Service_vehicule();
        //sv.modifier_vehicule(v);
       // sv.ajouter_vehicule(v);
      // sv.supprimer_vehicule(3);
       //sv.afficher_vehicule();
       Vehicule vehicule = new Vehicule("Voiture", "bm", 9632);
       Service_vehicule sv = new Service_vehicule();
       sv.afficher_vehicule();
       
       
     /* Location_vehicule location = new Location_vehicule(140271,147896, "10 jours", "10 avril", "20 avril", vehicule);
      Service_location sl = new Service_location();
       sl.afficher_Location();*/
    
}
}