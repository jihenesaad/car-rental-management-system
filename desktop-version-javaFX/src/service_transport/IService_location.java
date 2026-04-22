/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_transport;

import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.util.List;


/**
 *
 * @author HP
 */
public interface IService_location  {
     public void ajouter_transport(Location_vehicule lv);
     public void modifier_transport(Location_vehicule lv);
}

