package Controlers;

import Entities.Pizza;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPizza
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPizza() {
        cnx = ConnexionBDD.getCnx();
        if (cnx == null) {
            throw new IllegalStateException("La connexion à la base de données est null.");
        }
    }


    public ArrayList<Pizza> getAllPizzas() {
        ArrayList<Pizza> lesPizzas = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT * FROM pizzas " +
                    "INNER JOIN Lignescommandes ON pizzas.numPiz = lignescommandes.refPizza");
            rs = ps.executeQuery();
            while (rs.next()) {
               Pizza pizza = new Pizza(rs.getString("numPiz"), rs.getString("nomPiz"), rs.getInt("nbPers"), rs.getInt("Prix"), rs.getInt("qte"));
                lesPizzas.add(pizza);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPizza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPizzas;
    }

}
