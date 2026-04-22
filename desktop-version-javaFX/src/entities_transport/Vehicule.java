/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_transport;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP
 */
    
    public class Vehicule {
    private int id_vehicle;
    private String type_vehicule;
    private String marque;
    private int matriculeV;

    
    public Vehicule() {
    }
    public Vehicule(int id_vehicle, String type_vehicule, String marque, int matriculeV) {
        this.id_vehicle = id_vehicle;
        this.type_vehicule = type_vehicule;
        this.marque = marque;
        this.matriculeV = matriculeV;
    }

    public Vehicule(String type_vehicule, String marque, int matriculeV) {
        this.type_vehicule = type_vehicule;
        this.marque = marque;
        this.matriculeV = matriculeV;
    }
   

    public int getId_vehicle() {
        return id_vehicle;
    }

    public String getType_vehicule() {
        return type_vehicule;
    }

    public String getMarque() {
        return marque;
    }
     public int getMatriculeV() {
        return matriculeV;
    }

    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }

    public void setType_vehicule(String type_vehicule) {
        this.type_vehicule = type_vehicule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    public void setMatriculeV(int matriculeV) {
        this.matriculeV = matriculeV;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "id_vehicle=" + id_vehicle + ", type_vehicule=" + type_vehicule + ", marque=" + marque + ", matriculeV=" + matriculeV + '}';
    }
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_vehicle;
        hash = 79 * hash + Objects.hashCode(this.type_vehicule);
        hash = 79 * hash + Objects.hashCode(this.marque);
        hash = 79 * hash + this.matriculeV;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicule other = (Vehicule) obj;
        if (this.id_vehicle != other.id_vehicle) {
            return false;
        }
        if (this.matriculeV != other.matriculeV) {
            return false;
        }
        if (!Objects.equals(this.type_vehicule, other.type_vehicule)) {
            return false;
        }
        if (!Objects.equals(this.marque, other.marque)) {
            return false;
        }
        return true;
    }

   
    
}

