/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_transport;

import java.util.Objects;
import service_transport.IService_location;
import service_transport.Service_location;

/**
 *
 * @author HP
 */
public class Location_vehicule {
    private int id_loc_vehicule;
    private int refLoc;
    private int cin_client_vehicule;
    private String duree_loc_vehicule;
    private String pickup_vehicule;
    private String return_vehicule;
    private Vehicule vehicule;

    public Location_vehicule() {
    }

    public Location_vehicule(int id_loc_vehicule, int refLoc, int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule, Vehicule vehicule) {
        this.id_loc_vehicule = id_loc_vehicule;
        this.refLoc = refLoc;
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
        this.vehicule = vehicule;
    }

    public Location_vehicule(int refLoc, int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule, Vehicule vehicule) {
        this.refLoc = refLoc;
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
        this.vehicule = vehicule;
    }

    
   

    public Vehicule getVehicule(){
    return vehicule;
    }
    
    
    public int getId_loc_vehicule() {
        return id_loc_vehicule;
    }

    public int getRefLoc() {
        return refLoc;
    }
    

    public int getCin_client_vehicule() {
        return cin_client_vehicule;
    }

    public String getDuree_loc_vehicule() {
        return duree_loc_vehicule;
    }

    public String getPickup_vehicule() {
        return pickup_vehicule;
    }

    public String getReturn_vehicule() {
        return return_vehicule;
    }

   
    
    public void setId_loc_vehicule(int id_loc_vehicule) {
        this.id_loc_vehicule = id_loc_vehicule;
    }

    public void setRefLoc(int refLoc) {
        this.refLoc = refLoc;
    }
    

    public void setCin_client_vehicule(int cin_client_vehicule) {
        this.cin_client_vehicule = cin_client_vehicule;
    }

    public void setDuree_loc_vehicule(String duree_loc_vehicule) {
        this.duree_loc_vehicule = duree_loc_vehicule;
    }

    public void setPickup_vehicule(String pickup_vehicule) {
        this.pickup_vehicule = pickup_vehicule;
    }

    public void setReturn_vehicule(String return_vehicule) {
        this.return_vehicule = return_vehicule;
    }
    public void setVehicule(Vehicule vehicule){
        this.vehicule=vehicule;
    }

    @Override
    public String toString() {
        return "Location_vehicule{" + "id_loc_vehicule=" + id_loc_vehicule + ", refLoc=" + refLoc + ", cin_client_vehicule=" + cin_client_vehicule + ", duree_loc_vehicule=" + duree_loc_vehicule + ", pickup_vehicule=" + pickup_vehicule + ", return_vehicule=" + return_vehicule + ", vehicule=" + vehicule + '}';
    }

    

   

   


   
   

   
}
