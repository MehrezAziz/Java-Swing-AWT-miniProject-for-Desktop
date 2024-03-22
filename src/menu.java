import javax.swing.*;
import java.awt.*;

public class menu extends JMenuBar{

    JLabel competence;
    JMenu infoper,help,edit;
    JMenuItem cut,copy,paste,selectAll;


    public  menu(String text){

        this.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));
        infoper=new JMenu(text);
        help=new JMenu("Help");
        edit=new JMenu("Edit");

        cut=new JMenuItem("cut");
        copy=new JMenuItem("copy");
        paste=new JMenuItem("paste");
        selectAll=new JMenuItem("selectAll");
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        this.add(infoper);this.add(edit);this.add(help);



    }
}
