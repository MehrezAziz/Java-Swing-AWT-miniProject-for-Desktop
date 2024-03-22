import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gestionProfil extends JInternalFrame {
    JTextField nom,prenom,pseudo;
    JButton valider;
    JPanel northpane;
    JLabel Lnom,Lprenom,Lpseudo;
    static JLabel help;
    static JList jl;
    static JTabbedPane jtp;
    JSplitPane jsp;
    static ArrayList <profil> data;
    static int compteur=0;

    static DefaultListModel model;

    gestionProfil(){

        this.setTitle("Gestion Profil");
        this.setSize(500,400);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setClosable(true);
        this.setSize(new Dimension(800,500));
        this.setResizable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true);

        northpane=new JPanel();
        nom=new JTextField("foulen ben foulen",15);
        prenom=new JTextField(15);
        pseudo=new JTextField(15);

        Lnom=new JLabel("Nom");
        northpane.add(Lnom);
        northpane.add(nom);

        Lprenom=new JLabel("Prenom");
        northpane.add(Lprenom);
        northpane.add(prenom);

        Lpseudo=new JLabel("Pseudo");
        northpane.add(Lpseudo);
        northpane.add(pseudo);

        valider=new JButton("valider");
        northpane.add(valider);
        help=new JLabel("+ Help");

        this.add(northpane, BorderLayout.NORTH);
        this.add(help,BorderLayout.SOUTH);

        model = new DefaultListModel<>();

        jl=new JList();
        jl.setPreferredSize(new Dimension(100,0));
        jl.setModel(model);

        jtp=new JTabbedPane();
        //jtp.addTab("title",new JPanel());

        jsp=new JSplitPane();
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);
        this.add(jsp);
        data= new ArrayList<profil>();

        mouseListener(nom,Lnom);
        mouseListener(prenom,Lprenom);
        mouseListener(pseudo,Lpseudo);

        Listener(nom);
        Listener(prenom);
        Listener(pseudo);



        //jtp.addTab("title",new JPanel());
        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    if (compteur< data.size())
                    jtp.addTab(jl.getSelectedValue().toString(), new Formul(data.get(compteur).nom,data.get(compteur++).prenom));
                    jtp.setSelectedIndex(jl.getSelectedIndex());

                }
                if (e.getButton()==MouseEvent.BUTTON3){
                    JPopupMenu pop= new JPopupMenu();
                    JMenuItem modifier=new JMenuItem("Modifier");
                    JMenuItem supprimer=new JMenuItem("Supprimer");
                    JMenuItem suppAll=new JMenuItem("Supprimer tous");
                    pop.add(modifier);
                    pop.add(supprimer);
                    pop.add(suppAll);
                    pop.show(jl,e.getX(),e.getY());

                    listenMenuItem(suppAll);
                    listenMenuItem(modifier);
                    listenMenuItem(supprimer);

                }
            }
        });




        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomA,prenomA,pseudoA;
                nomA=nom.getText();
                prenomA=prenom.getText();
                pseudoA=pseudo.getText();
                profil p;
                if (isNotVide(nomA) && isNotVide(prenomA) && isNotVide(pseudoA)) {
                    p= new profil(nomA,prenomA,pseudoA);
                    if(occurrence(pseudoA)==true){
                        model.addElement(p.pseudo);

                    }
                    data.add(p);
                } else{
                    JOptionPane.showMessageDialog(gestionProfil.this, "Il y a un ou plusieurs champs vides!", "Error", JOptionPane.ERROR_MESSAGE);

                }


            }
        });

    } //constructor
    class Formul extends JPanel{
        JLabel Bienv;

        Formul(String nom,String prenom){
            Bienv=new JLabel("BIENVENUE "+nom+" "+prenom);
            this.add(Bienv);
        }
    }
    public void listenMenuItem(JMenuItem j){
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(j.getText().equals("Supprimer tous")){
                        data.clear();
                        jtp.removeAll();
                        model.clear();
                    }
                    if(j.getText().equals("Supprimer")){


                        String str=  jl.getSelectedValue().toString();
                        for(int i=0; i<jtp.getTabCount();  i++){
                            if(jtp.getTitleAt(i).equals(str)){
                                jtp.remove(i);
                                break;
                            }
                        }
                        data.remove(jl.getSelectedIndex());
                        model.remove(jl.getSelectedIndex());

                    }
                    if(j.getText().equals("Modifier")){

                        //String p=jl.getSelectedValue().toString();


                        String
                        nouvNom=JOptionPane.showInputDialog(gestionProfil.this,"Nouveau Nom: ","foulen "),
                        nouvPrenom=JOptionPane.showInputDialog(gestionProfil.this,"Nouveau Prenom: ","ben foulen");

                        data.get(jl.getSelectedIndex()).setNom(nouvNom);
                        data.get(jl.getSelectedIndex()).setPrenom(nouvPrenom);
                        {
                        compteur=0;
                        jtp.removeAll();}
                        for (int i=0;i<jl.getModel().getSize();i++)
                        jtp.addTab(data.get(compteur).pseudo, new Formul(data.get(compteur).nom,data.get(compteur++).prenom));


                    }

                }
            });
    }

    /*itemsupp.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        String p=jl.getSelectedValue().toString();
                                                        for(int i=0;i<jtp.getTabCount();i++){
                                                            if(jtp.getTitleAt(i).equals(p)){
                                                                jtp.remove(i);
                                                                break;
                                                            }
                                                        }
                                                        data.remove(jl.getSelectedIndex());
                                                        model.remove(jl.getSelectedIndex());



                                                    }
                                                });
                                                itemmod.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {

                                                        String p=jl.getSelectedValue().toString();
                                                        for(int i=0;i<jtp.getTabCount();i++){
                                                            if(jtp.getTitleAt(i).equals(p)){
                                                                jtp.remove(i);
                                                                break;
                                                            }
                                                        }
                                                        String newName=JOptionPane.showInputDialog(GestionProfil.this,"modfier le nom","Edition");
                                                        String newPrenom=JOptionPane.showInputDialog(GestionProfil.this,"modfier le prenom","Edition");

                                                        data.get(jl.getSelectedIndex()).setNom(newName);
                                                        data.get(jl.getSelectedIndex()).setPrenom(newPrenom);
                                                    }
                                                });*/
    public static boolean occurrence(String  s){
        if (!data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).pseudo);
                if (data.get(i).pseudo.equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }
    public  static boolean isNotVide(String s){
        if(s.equals("")){
            return !true;
        }
        return true;
    }



    public static void mouseListener(JTextField j,JLabel jl){
        Font currentFont = jl.getFont();
        Font boldFont = currentFont.deriveFont(14f);
        Font defaultFont = UIManager.getFont("Label.font");

        j.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                j.setBackground(Color.lightGray);
                jl.setFont(boldFont);
                //jl.setForeground(Color.blue);
                if (jl.getText().equals("Nom")){
                    help.setText("+ Help: tapez votre nom");
                }else if(jl.getText().equals("Prenom")){
                    help.setText("+ Help: tapez votre prenom");
                }else if(jl.getText().equals("Pseudo")){
                    help.setText("+ Help: tapez un nouveau pseudo");
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                j.setBackground(Color.WHITE);
                jl.setFont(defaultFont);
                //jl.setForeground(Color.black);
                help.setText("+ Help");
            }
        });
    }
       public static boolean isValidString(String nomP) {
        String NameRegex = "^[a-zA-Z][a-zA-Z\\s]*$";
        Pattern pattern = Pattern.compile(NameRegex);
        Matcher matcher = pattern.matcher(nomP);
        return matcher.matches();
    }

    public  static void Listener(JTextField j){
        Border borderT = BorderFactory.createLineBorder(Color.red, 2); // Change thickness as needed
        Border borderTBlack = BorderFactory.createLineBorder(Color.black, 2); // Change thickness as needed

        j.getDocument().addDocumentListener(new DocumentListener() {
            @Override

            public void insertUpdate(DocumentEvent e) {
                if(isValidString(j.getText().trim())){
                    j.setBorder(borderTBlack);
                    }
            }

            public void removeUpdate(DocumentEvent e) {
                if(isValidString(j.getText().trim())){
                    j.setBorder(borderTBlack);

                }
            }

            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text documents
            }
        });
        j.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(j.getText().equals("foulen ben foulen"))
                    j.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!isValidString(j.getText().trim())) {
                    j.setBorder(borderT);
                }
                if(isValidString(j.getText().trim())) {
                    j.setBorder(borderTBlack);
                    //if(isAllValid()) insidefooter3.setVisible(false);
                }

            }
        });
    }
}
