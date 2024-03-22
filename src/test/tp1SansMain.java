import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Vector;
import java.time.Year;



public class tp1SansMain extends JInternalFrame implements ActionListener {
    JFrame f;
    JPanel header;
    JPanel footer,insidefooter,insidefooter2;
    JPanel body,insidebody1,info,photo,nomprenom,mail,tel,ddn,sexe,formation;
    JPanel insidebody2,inf,comment,java,python,machineL;
    JLabel Linfo,Lcomment,Ljava,Lpython,LmachineL;
    JLabel Lnomprenom,Lmail,Ltel,Lddn,Lsexe,Lformation;
    JTextField Tnomprenom,Tmail,Ttel;
    JComboBox jj,mm,aaaa,ComboBoxFormation,Cjava,Cpython,CmachineL;
    JTextArea Tcomment;
    JRadioButton homme,femme;
    JMenuBar mb;
    menu mb2;
    JLabel competence;
    JMenu infoper,help,edit;
    JMenuItem cut,copy,paste,selectAll;
    JCheckBox check;
    JButton envoyer,annuler;

    public tp1SansMain() throws IOException {
        f=new JFrame("TP1");
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());
        header= new JPanel();//new FlowLayout(FlowLayout.LEFT)
        footer=new JPanel();
        body= new JPanel();


        //inside footer
        check=new JCheckBox("Enregistrer une version pdf de la candidature avant d\'envoyer.");
        check.setBorder(BorderFactory.createEmptyBorder());
        envoyer=new JButton("Envoyer");
        annuler=new JButton("Annuler");

        footer.setLayout(new BorderLayout());
        insidefooter=new JPanel();
        insidefooter2=new JPanel();
        insidefooter2.add(check);
        insidefooter.add(envoyer);
        insidefooter.add(annuler);
        insidefooter.setBorder(new EmptyBorder(5, 0, 15, 0));
        footer.add(insidefooter2,BorderLayout.NORTH);
        footer.add(insidefooter,BorderLayout.SOUTH);
        //end footer

        //inside body
        //insidebody1
        mb2= new menu("Informations Personnelles");

        insidebody1= new JPanel(new BorderLayout());
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); // Black border with thickness 2
        insidebody1.setBorder(border);
        info=new JPanel(new GridLayout(6,1));
        photo=new JPanel();

        nomprenom=new JPanel();  Lnomprenom=new JLabel("Nom & Prenom:");          nomprenom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mail=new JPanel();       Lmail=     new JLabel("E-Mail:");                mail.setLayout     (new FlowLayout(FlowLayout.RIGHT));
        tel=new JPanel();        Ltel=      new JLabel("Tél:");                   tel.setLayout      (new FlowLayout(FlowLayout.RIGHT));
        ddn=new JPanel();        Lddn=      new JLabel("Date de naissance:  ");   ddn.setLayout      (new FlowLayout(FlowLayout.RIGHT));
        sexe=new JPanel();       Lsexe=     new JLabel("Sexe:    ");              sexe.setLayout     (new FlowLayout(FlowLayout.RIGHT));
        formation=new JPanel();  Lformation=new JLabel("Formation:      ");       formation.setLayout(new FlowLayout(FlowLayout.RIGHT));

        Tnomprenom=new JTextField(15);
        Tmail=new JTextField(15);
        Ttel=new JTextField(15);

        UIManager.put("ComboBox.background", Color.LIGHT_GRAY);
        Vector<Integer> jours = IntStream.rangeClosed(1, 32).boxed().collect(Collectors.toCollection(Vector::new));
        jj=new JComboBox(jours);
        Vector<Integer> mois = IntStream.rangeClosed(1, 32).boxed().collect(Collectors.toCollection(Vector::new));
        mm=new JComboBox(mois);
        int currentYear = Year.now().getValue();
        Vector<Integer> annees = IntStream.rangeClosed(1900,currentYear ).boxed().collect(Collectors.toCollection(Vector::new));
        aaaa=new JComboBox(annees);

        homme=new JRadioButton("Homme");
        femme=new JRadioButton("Femme");
        ButtonGroup bg= new ButtonGroup();
        bg.add(homme); bg.add(femme);

        Vector<String> Formation=new Vector<String>() ;
        Formation.add("Ingénieur"); Formation.add("Licence");Formation.add("cycle préparatoire");Formation.add("Mastère");
        ComboBoxFormation=new JComboBox(Formation);

        nomprenom.add(Lnomprenom);
        nomprenom.add(Tnomprenom);
        mail.add(Lmail);
        mail.add(Tmail);
        tel.add(Ltel);
        tel.add(Ttel);
        ddn.add(Lddn);
        ddn.add(jj); ddn.add(mm);ddn.add(aaaa);
        sexe.add(Lsexe);
        sexe.add(femme);sexe.add(homme);
        formation.add(Lformation);
        formation.add(ComboBoxFormation);

        info.add(nomprenom);
        info.add(mail);
        info.add(tel);
        info.add(ddn);
        info.add(sexe);
        info.add(formation);

        File imageFile = new File("C:\\Users\\taher\\OneDrive\\Bureau\\study at home\\cv\\mehrez.jpg        ");
        Image image = ImageIO.read(imageFile);
        Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconI = new ImageIcon(scaledImage);
        JLabel im=new JLabel(iconI);
        photo.add(im);

        insidebody1.add(info,BorderLayout.WEST);
        insidebody1.add(photo,BorderLayout.EAST);
        insidebody1.add(mb2,BorderLayout.NORTH);
        body.add(insidebody1);
        //end insidebody1

        //insidebody2
        insidebody2= new JPanel(new BorderLayout());
        insidebody2.setBorder(border);
        mb2= new menu("Compétences techniques ");
        inf=new JPanel(new GridLayout(3,1));


        java=new JPanel();      Ljava=        new JLabel("Java :   ");                      java.setLayout(new FlowLayout(FlowLayout.RIGHT));
        python=new JPanel();    Lpython=      new JLabel("Pyhton :   ");                  python.setLayout     (new FlowLayout(FlowLayout.RIGHT));
        machineL=new JPanel();  LmachineL=    new JLabel("Machine  Learning :  ");       machineL.setLayout      (new FlowLayout(FlowLayout.RIGHT));
        comment=new JPanel(new BorderLayout());   Lcomment=     new JLabel("Commentaires: ");
        Lcomment.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0)); // Top, Left, Bottom, Right



        Vector<String> niveau = new Vector<String>();
        niveau.add("Débutant"); niveau.add("Moyenne"); niveau.add("Confirmé"); niveau.add("Expert");
        Cjava=new JComboBox(niveau); //Cjava.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Cpython=new JComboBox(niveau);
        CmachineL=new JComboBox(niveau);
        Tcomment=new JTextArea(8,16);
        JScrollPane scrollComment = new JScrollPane(Tcomment);
        scrollComment.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



        java.add(Ljava);
        java.add(Cjava);
        python.add(Lpython);
        python.add(Cpython);
        machineL.add(LmachineL);
        machineL.add(CmachineL);
        comment.add(Lcomment,BorderLayout.NORTH);
        comment.add(scrollComment,BorderLayout.SOUTH);


        inf.add(java);
        inf.add(python);
        inf.add(machineL);

        photo.add(comment);

        insidebody2.add(mb2,BorderLayout.NORTH);
        insidebody2.add(inf,BorderLayout.WEST);
        insidebody2.add(comment,BorderLayout.EAST);
        body.add(insidebody1,BorderLayout.NORTH);
        body.add(insidebody2,BorderLayout.SOUTH);

        //end insidebody2
        //end body



        f.add(body,BorderLayout.CENTER);
        // f.add(header,BorderLayout.NORTH);
        f.add(footer,BorderLayout.SOUTH);
        //f.pack();
        f.setMinimumSize(new Dimension(600, 700));
        f.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cut){}

        if(e.getSource()==paste){}

        if(e.getSource()==copy){}

        if(e.getSource()==selectAll){}

    }
}
