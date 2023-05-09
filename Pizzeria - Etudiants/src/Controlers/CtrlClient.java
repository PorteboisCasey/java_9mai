package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlClient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlClient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllClients()
    {
        ArrayList<String> lesClients = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT nomCli FROM Client");
            rs = ps.executeQuery();
            while (rs.next()) {
                lesClients.add(rs.getInt("numCli"), rs.getString("nomCli"));
            }

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }


        return lesClients;
    }

    public int getIdClientByName(String nomCli)
    {
        int numCli = 0;

        // A vous de jouer

        return numCli;
    }
}
