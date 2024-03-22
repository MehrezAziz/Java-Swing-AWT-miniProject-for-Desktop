import  javax.swing.*;
import java.awt.*;

public class MaFenetre extends JFrame {

    public MaFenetre()
    {
        super();

        this.setTitle("FirstOne");
        this.setSize(500,750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JButton b=new JButton("click");
        b.setBounds(10,10,70,50);
        this.add(b);
        JButton bQuit=new JButton("Quit");
        bQuit.setPreferredSize(new Dimension(300,50));
        this.add(bQuit,BorderLayout.WEST);
        JLabel lb=new JLabel("it\'s a label");
        lb.setOpaque(true);
        lb.setForeground(Color.BLACK);
        lb.setBackground(Color.lightGray);
        lb.setFont(new Font("arial", Font.BOLD | Font.ITALIC,32));
        lb.setHorizontalAlignment(JLabel.CENTER);
        this.add(lb);
        this.setVisible(true);
    }

}