package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    JMenuBar menuBar;

    JMenu menuFormation,menuEtudiant,menuEnseignant;
    JMenuItem ajoutF,rechercheF,affichageF,ajoutE,rechercheE,affichageE,ajoutEN,rechercheEN,affichageEN;
    JPanel pnorth,pcenter;
    public  Home(){
        this.setTitle("Gestion Etudiant");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500,550));
        pnorth = new JPanel(new FlowLayout());
        pcenter=new JPanel(new BorderLayout());

        menuBar=new JMenuBar();
        menuFormation=new JMenu("Formation  ");
        menuEtudiant=new JMenu("Etudiant   ");
        menuEnseignant=new JMenu("Enseignant ");

        ajoutF=new JMenuItem("Ajouter    ");
        rechercheF=new JMenuItem("Rechercher ");
        affichageF=new JMenuItem("Afficher   ");
        listenMenuItemFormation(rechercheF);
        listenMenuItemFormation(ajoutF);

        ajoutE=new JMenuItem("Ajouter    ");
        rechercheE=new JMenuItem("Rechercher ");
        affichageE=new JMenuItem("Afficher   ");
        listenMenuItemEtudiant(rechercheE);
        listenMenuItemEtudiant(ajoutE);

        ajoutEN=new JMenuItem("Ajouter    ");
        rechercheEN=new JMenuItem("Rechercher ");
        affichageEN=new JMenuItem("Afficher   ");

        menuFormation.add(ajoutF);menuFormation.add(rechercheF);menuFormation.add(affichageF);
        menuEtudiant.add(ajoutE);menuEtudiant.add(rechercheE);menuEtudiant.add(affichageE);
        menuEnseignant.add(ajoutEN);menuEnseignant.add(rechercheEN);menuEnseignant.add(affichageEN);

        menuBar.add(menuFormation);
        //menuBar.add(createSpacer(80));
        menuBar.add(menuEtudiant);
       // menuBar.add(createSpacer(80));

        menuBar.add(menuEnseignant);

       // pnorth.add(menuBar);
        this.setJMenuBar(menuBar);

       /// this.add(pnorth, BorderLayout.NORTH);
       /// this.add(pcenter, BorderLayout.CENTER);
        this.setVisible(true);
    }
    private static Component createSpacer(int width) {
        return Box.createRigidArea(new Dimension(width, 0));
    }

    public void listenMenuItemFormation(JMenuItem j){
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (j.getText().equals("Ajouter    ")) {
                    IHMAjoutFormation AJOUTf= new IHMAjoutFormation();
                }
                if (j.getText().equals("Rechercher ")) {
                    IHMRechercheFormation rechF=new IHMRechercheFormation();


                }
                if (j.getText().equals("Afficher   ")) {

                }
            }
        });
    }
    public void listenMenuItemEtudiant(JMenuItem j){
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (j.getText().equals("Ajouter    ")) {
                    IHMAjoutEtudiant AJOUT= new IHMAjoutEtudiant();
                }
                if (j.getText().equals("Rechercher ")) {
                    IHMRechercheEtudiant rechF=new IHMRechercheEtudiant();
                }
                if (j.getText().equals("Afficher   ")) {

                }
            }
        });
    }
    public void listenMenuItemEnseignant(JMenuItem j){
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (j.getText().equals("Ajouter    ")) {
                }
                if (j.getText().equals("Rechercher ")) {
                }
                if (j.getText().equals("Afficher   ")) {
                }
            }
        });
    }
}
