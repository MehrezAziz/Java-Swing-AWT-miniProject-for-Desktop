import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.awt.Color.black;

public class gestionEtudiant extends JInternalFrame {

    JPanel pnorth,pcenter;
    JLabel lbnom,lbprenom,lbcin,lbmoyenne;

    JTextField tfnom,tfprenom,tfcin,tfmoyenne;
    JButton valider;
    JTable jtEtudiant;
    myTableModel model;


    public gestionEtudiant() throws SQLException {
        this.setTitle("Gestion Etudiant");
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        this.setSize(new Dimension(760,700));
        this.setMaximizable(true);
        this.setIconifiable(true);

        //
        pnorth = new JPanel(new FlowLayout());
        pcenter=new JPanel(new BorderLayout());
        pnorth.setBackground(Color.lightGray);
        lbnom = new JLabel("Nom");
        tfnom = new JTextField(12);
        lbprenom = new JLabel("Prenom");
        tfprenom = new JTextField(12);
        lbcin = new JLabel("Cin");
        tfcin = new JTextField(12);
        lbmoyenne=new JLabel("Moyenne");
        tfmoyenne= new JTextField(12);
        valider = new JButton("VALIDER");
        valider.setBackground(Color.gray);


        pnorth.add(lbnom);
        pnorth.add(tfnom);
        pnorth.add(lbprenom);
        pnorth.add(tfprenom);
        pnorth.add(lbcin);
        pnorth.add(tfcin);
        pnorth.add(lbmoyenne);
        pnorth.add(tfmoyenne);
        pnorth.add(valider);


        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomS,prenomS;
                int cinS;
                double moyenneS;
                nomS= tfnom.getText();
                prenomS=tfprenom.getText();
                cinS= Integer.parseInt( tfcin.getText());
                moyenneS= Double.parseDouble( tfmoyenne.getText());
                model.insertEtudiant(nomS,prenomS,cinS,moyenneS);
            }
        });



        String url="jdbc:mysql://127.0.0.1/db_tpjava";
        String username="root";
        String password="";



        EtudiantDao dao=new EtudiantDao(url,username,password);
        ResultSet rs;
        rs = dao.selection("Select * from Etudiant  ");
        model = new myTableModel(rs);

        jtEtudiant=new JTable(model);
        // jtEtudiant.setModel(model);
        jtEtudiant.setSelectionBackground(Color.lightGray);
        pcenter.setBorder(new EmptyBorder(10,0,0,0));
        pcenter.add(new JScrollPane(jtEtudiant));//affichage

        this.add(pnorth, BorderLayout.NORTH);
        this.add(pcenter, BorderLayout.CENTER);
        this.setVisible(true);

        jtEtudiant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (e.getButton()==MouseEvent.BUTTON3){
                    JPopupMenu pop= new JPopupMenu();
                   // JMenuItem modifier=new JMenuItem("Modifier");
                    JMenuItem supprimer=new JMenuItem("Supprimer");
                    JMenuItem suppAll=new JMenuItem("Supprimer tous");
                  //  pop.add(modifier);
                    pop.add(supprimer);
                    pop.add(suppAll);
                    pop.show(pcenter,e.getX(),e.getY()+pnorth.getHeight()-5);

                    listenMenuItem(suppAll);
                   // listenMenuItem(modifier);
                    listenMenuItem(supprimer);

                }

            }
        });


    }
    public void listenMenuItem(JMenuItem j){
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=-1,col=-1;
                col=  jtEtudiant.getSelectedColumn();
                row = jtEtudiant.getSelectedRow();
                if(j.getText().equals("Supprimer tous")){

                    int choix = JOptionPane.showConfirmDialog(null, "vous êtes sûr de supprimer TOUS les étudiants?" , "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choix == JOptionPane.YES_OPTION) {
                        model.removeAllRows();
                    }
                }
                if(j.getText().equals("Supprimer")){
                    if (row !=-1){
                        Object valCin ;
                        String fullName="";
                        valCin= jtEtudiant.getValueAt(row, 0);
                        fullName+=((String)valCin+" ");
                        valCin= jtEtudiant.getValueAt(row, 1);
                        fullName+=(String)valCin;
                        int choix = JOptionPane.showConfirmDialog(null, "vous êtes sûr de supprimer \""+fullName+"\" ?" , "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (choix == JOptionPane.YES_OPTION) {
                            valCin = jtEtudiant.getValueAt(row, 2);
                            model.removeRow(row,(int) valCin);
                        }

                    }


                }

            }
        });
    }



}

/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;


public class gestionEtudiant extends JFrame {

    JPanel north,south,center;
    JTextField nom,prenom,cin,moyenne;
    JButton valider;
    String Tnom,Tprenom,Tcin,Tmoyenne;
    JTable tabEtudiant;
    myTableModel model;
    EtudiantDao dao;

    public gestionEtudiant(){
        this.setTitle("Gestion Profil");
        this.setSize(900,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       // this.setLayout(new BorderLayout());

        north=new JPanel();
       // south=new JPanel();
        center=new JPanel(new FlowLayout());

       // north.setSize(900,50);
        north.setBackground(Color.lightGray);

        nom=new JTextField("nom",15);
        prenom=new JTextField("prenom",15);
        cin=new JTextField("cin",15);
        moyenne=new JTextField("moyenne",15);
        valider=new JButton("Valider");
        valider.setBackground(Color.GRAY);

        north.add(new JLabel("nom: "));
        north.add(nom);
        north.add(new JLabel("prenom: "));
        north.add(prenom);
        north.add(new JLabel("cin: "));
        north.add(cin);
        north.add(new JLabel("moyenne: "));
        north.add(moyenne);
        north.add(valider);




        tabEtudiant= new JTable();
        dao=new EtudiantDao("jdbc:mysql://127.0.0.1/db_tpjava","root","");
        ResultSet rs= dao.selection("SELECT * FROM etudiant");
        model= new myTableModel(rs);
        tabEtudiant.setModel(model);
        ScrollPane s= new ScrollPane();
        s.add(tabEtudiant);

        center.add(s);

        this.add(north,BorderLayout.NORTH);
      //  this.add(south,BorderLayout.SOUTH);
        this.add(center,BorderLayout.CENTER);
        this.setVisible(true);


        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean test= true;
                if (nom.getText()!="nom"){
                    Tnom=nom.getText();
                } else test=false;
                if (prenom.getText()!="nom"){
                    Tprenom=prenom.getText();
                }else test=false;
                if (cin.getText()!="cin"){
                    Tcin=cin.getText();
                }else test=false;
                if (moyenne.getText()!="moyenne"){
                    Tmoyenne=moyenne.getText();
                }else test=false;
                if (test){

                }

            }
        });
    }




}*/
