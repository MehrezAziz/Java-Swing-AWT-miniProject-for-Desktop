import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.SQLException;

public class All extends  JFrame implements  ActionListener {
    JMenuBar menuBar;
    JMenu menuTps;
    JMenuItem menuItemTp1;
    JMenuItem menuItemTp2,menuItemTp3;
    JDesktopPane desktop;
    public All(){


        //JFrame f= new JFrame("TP2 java swing");
        //setLayout(null);
        setSize(850,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("tp java swing");

        this.menuBar= new JMenuBar();
        this.menuTps= new JMenu("Tous les TPs  ");

        this.menuItemTp1= new JMenuItem("TP1              ");
        this.menuItemTp2= new JMenuItem("TP2              ");
        this.menuItemTp3= new JMenuItem("TP3              ");


        menuTps.add(menuItemTp1);
        menuTps.add(menuItemTp2);
        menuTps.add(menuItemTp3);
        menuBar.add(menuTps);

        this.setJMenuBar(menuBar);

        desktop= new JDesktopPane();
        this.add(desktop);

        menuItemTp1.addActionListener(this);
        menuItemTp2.addActionListener(this);
        menuItemTp3.addActionListener(this);




        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuItemTp2){
            gestionProfil tpN2 =new gestionProfil();
            desktop.add(tpN2);
        } else  if (e.getSource()==menuItemTp1){

                tp1 t=new tp1();
                desktop.add(t);

        } else  if (e.getSource()==menuItemTp3) {
            try {
                gestionEtudiant tp3= new gestionEtudiant();
                desktop.add(tp3);
            } catch (SQLException ex) {
                System.out.println("erreur ouverture tp3");
            }

        }
    }
}
