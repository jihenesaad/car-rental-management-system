/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Connexion_transport {
     //DB Credentials
    final String URL = "jdbc:mysql://localhost:3306/gestiontransport";
    final String USR = "root";
    final String PWD = "";
    
    //var
    Connection cnx;
    static Connexion_transport instance;

    private Connexion_transport() {
        try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
            Logger.getLogger(Connexion_transport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static Connexion_transport getInstance() {
        if(instance == null)
            instance = new Connexion_transport();
        return instance;
    }
    

    public Connection getCnx() {
        return cnx;
    }
}
