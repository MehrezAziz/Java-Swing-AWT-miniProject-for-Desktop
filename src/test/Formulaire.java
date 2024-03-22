import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Formulaire extends JFrame implements ActionListener {

    JButton bValid;
    JButton bQuit;
    public Formulaire() throws IOException {
        super();

        this.setTitle("Form");
        this.setSize(500,750);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());

        bValid=new JButton("valid");
        bValid.setBackground(Color.green);
        //b.setBounds(100,100,70,50);
        //this.add(b);

        bQuit=new JButton("Quit");
        bQuit.setBackground(Color.red);
        //bQuit.setPreferredSize(new Dimension(30,50));
        //this.add(bQuit,BorderLayout.NORTH);

        bValid.addActionListener(this);
        bQuit.addActionListener(this);
        JPanel psouth= new JPanel();
        psouth.setLayout(new FlowLayout());
        psouth.add(bValid);
        psouth.add(bQuit);
        this.add(psouth,BorderLayout.SOUTH);
        JLabel lb=new JLabel("it\'s a label");
        lb.setOpaque(true);
        lb.setForeground(Color.BLACK);
        lb.setBackground(Color.lightGray);
        lb.setFont(new Font("arial", Font.BOLD | Font.ITALIC,32));
        lb.setHorizontalAlignment(JLabel.CENTER);
        this.add(lb,BorderLayout.NORTH);
/*
        File f=new File("cv.html");
        try {
            FileWriter fw=new FileWriter(f);
            fw.write("<H1>CV</H1>");
            fw.write("<H1>ff</H1>");
            fw.close();//sauvegard!!!
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        setSize(600,560);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bQuit)
        {
            System.out.println("Quit..");
            System.exit(0);
        }
        else{ //creation d'un fichier
            JOptionPane.showMessageDialog(null,"Saved!");
        }
    }


}
