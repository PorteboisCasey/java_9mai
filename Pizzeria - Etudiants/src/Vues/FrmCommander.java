package Vues;

import Controlers.*;
import Entities.Pizza;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;

    private CtrlLivreur ctrlLivreur;


    private  CtrlClient ctrlClient;



    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);





        ConnexionBDD maCnx = new ConnexionBDD();



        ModelJTable mdl;



        CtrlPizza pizza =  new CtrlPizza();
        mdl = new ModelJTable();
        mdl.loadDatasPizzas(pizza.getAllPizzas());
        tblPizzas.setModel(mdl);

        


        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });




    }
}
