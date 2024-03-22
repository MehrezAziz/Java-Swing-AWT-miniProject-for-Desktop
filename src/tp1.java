import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Vector;
import java.time.Year;
import java.io.FileWriter;
import java.util.regex.*;
import java.awt.event.*;


public class tp1 extends JInternalFrame implements ActionListener {

        String imagePath;
        JPanel footer,insidefooter,insidefooter2;
        JPanel body,insidebody1,info,photo,nomprenom,mail,tel,ddn,sexe,formation;
        JPanel insidebody2,inf,comment,java,python,machineL;
        JLabel Linfo,Lcomment,Ljava,Lpython,LmachineL,insidefooter3,errName, errMail,errPhone;
        JLabel Lnomprenom,Lmail,Ltel,Lddn,Lsexe,Lformation;
        JTextField Tnomprenom,Tmail,Ttel;
        JComboBox ComboBoxFormation,Cjava,Cpython,CmachineL;
        JComboBox<Integer> jj,mm,aaaa;
        JTextArea Tcomment;
        JRadioButton homme,femme;
        ButtonGroup bg;
        JMenuBar mb;
        JLabel imageLabel;
        JButton uploadButton;
        menu mb2;
        JLabel competence;
        JMenu infoper,help,edit;
        JMenuItem cut,copy,paste,selectAll;
        JCheckBox check;
        JButton envoyer,annuler;
        FileWriter fw;  String s; File fi;
    public tp1() {
        this.setTitle("TP1");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        footer=new JPanel();
        body= new JPanel();

        //image upload
        imageLabel = new JLabel();
        uploadButton = new JButton("Télécharger Image");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                // Filter for image files
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        return f.getName().toLowerCase().endsWith(".jpg") ||
                                f.getName().toLowerCase().endsWith(".jpeg") ||
                                f.getName().toLowerCase().endsWith(".png") ||
                                f.isDirectory();
                    }
                    public String getDescription() {
                        return "Image files (*.jpg, *.jpeg, *.png)";
                    }
                });
                // Show the file chooser dialog
                int result = fileChooser.showOpenDialog(tp1.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Read the selected image file and set it to the JLabel
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        Image image = imageIcon.getImage();
                        Image scaledImage = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                        imagePath = selectedFile.getAbsolutePath();
                        imageLabel.setIcon(new ImageIcon(scaledImage));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(tp1.this, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(uploadButton);
        //end code upload photo

        //inside footer
        check=new JCheckBox("Enregistrer une version pdf de la candidature avant d\'envoyer.");
        check.setBorder(BorderFactory.createEmptyBorder());
        envoyer=new JButton("Envoyer");
        annuler=new JButton("Annuler");

        footer.setLayout(new BorderLayout());
        insidefooter=new JPanel();
        insidefooter2=new JPanel();
        insidefooter3=new JLabel("il y a quelque(s) case(s) invalide(s) ");
        insidefooter3.setForeground(Color.red);
        insidefooter3.setVisible(false);
        insidefooter2.add(check);
        insidefooter2.add(insidefooter3);
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

        Tnomprenom=new JTextField("Aziz MEHREZ",15);
        errName=new JLabel("invalide");
        errName.setForeground(Color.red);
        errName.setVisible(false);
        Tmail=new JTextField("example@xxxx.yyy",15);
        errMail=new JLabel("invalide");
        errMail.setForeground(Color.red);
        errMail.setVisible(false);
        Ttel=new JTextField("12345678",15);
        errPhone=new JLabel("invalide");
        errPhone.setForeground(Color.red);
        errPhone.setVisible(false);



        UIManager.put("ComboBox.background", Color.LIGHT_GRAY);
        Vector<Integer> jours = IntStream.rangeClosed(1, 32).boxed().collect(Collectors.toCollection(Vector::new));
        jj=new JComboBox(jours);
        Vector<Integer> mois = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toCollection(Vector::new));
        mm=new JComboBox(mois);
        int currentYear = Year.now().getValue();
        Vector<Integer> annees = IntStream.rangeClosed(1900,currentYear ).boxed().collect(Collectors.toCollection(Vector::new));
        Collections.reverse(annees);
        aaaa=new JComboBox(annees);

        homme=new JRadioButton("Homme",true);
        femme=new JRadioButton("Femme");
        bg= new ButtonGroup();
        bg.add(homme); bg.add(femme);

        Vector<String> Formation=new Vector<String>() ;
        Formation.add("Ingénieur"); Formation.add("Licence");Formation.add("cycle préparatoire");Formation.add("Mastère");
        ComboBoxFormation=new JComboBox(Formation);

        nomprenom.add(Lnomprenom);
        nomprenom.add(Tnomprenom);
        mail.add(Lmail);
        mail.add(Tmail);
        mail.add(errMail);
        tel.add(Ltel);
        tel.add(Ttel);
        tel.add(errPhone);
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

        JPanel photoPanel= new JPanel(new BorderLayout());
        photoPanel.add(panel,BorderLayout.NORTH);
        photoPanel.add(imageLabel,BorderLayout.CENTER);

        insidebody1.add(info,BorderLayout.WEST);
        insidebody1.add(photoPanel,BorderLayout.EAST);///photo
        insidebody1.add(mb2,BorderLayout.NORTH);
        //end insidebody1

        //insidebody2
        insidebody2= new JPanel(new BorderLayout());
        insidebody2.setBorder(border);
        mb2= new menu("Compétences techniques ");
        inf=new JPanel(new GridLayout(3,1));

        java=new JPanel();      Ljava=        new JLabel("Java :   ");                      java.setLayout   (new FlowLayout(FlowLayout.RIGHT));
        python=new JPanel();    Lpython=      new JLabel("Pyhton :   ");                  python.setLayout   (new FlowLayout(FlowLayout.RIGHT));
        machineL=new JPanel();  LmachineL=    new JLabel("Machine  Learning :  ");       machineL.setLayout  (new FlowLayout(FlowLayout.RIGHT));
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

        envoyer.addActionListener(this);
        annuler.addActionListener(this);
        check.addActionListener(this);

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
        body.add(insidebody1);
        body.add(insidebody2);

        //end insidebody2
        //end body

        this.add(body,BorderLayout.CENTER);
        this.add(footer,BorderLayout.SOUTH);
        this.setMinimumSize(new Dimension(600, 560));
        this.setSize(600,560);
        this.setVisible(true);
        fi=new File("cv.html");

        Border borderT = BorderFactory.createLineBorder(Color.red, 2); // Change thickness as needed
        Border borderTBlack = BorderFactory.createLineBorder(Color.black, 2); // Change thickness as needed




        Tmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(Tmail.getText().trim().equals("example@xxxx.yyy"))
                    Tmail.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!isValidEmail(Tmail.getText().trim())) {
                    Tmail.setBorder(borderT);
                    errMail.setVisible(true) ;
                }
                if(isValidEmail(Tmail.getText().trim())) {
                    errMail.setVisible(false);
                    Tmail.setBorder(borderTBlack);
                    if(isAllValid()) insidefooter3.setVisible(false);}
            }
        });
        Ttel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(Ttel.getText().trim().equals("12345678"))
                    Ttel.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!isValidPhone(Ttel.getText().trim())) {
                    Ttel.setBorder(borderT);
                    errPhone.setVisible(true);
                }

                if(isValidPhone(Ttel.getText().trim())) {
                    errPhone.setVisible(false);
                    Ttel.setBorder(borderTBlack);
                    if(isAllValid()) insidefooter3.setVisible(false);}
            }
        });
        Tnomprenom.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(Tnomprenom.getText().trim().equals("Aziz MEHREZ"))
                    Tnomprenom.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!isValidName(Tnomprenom.getText().trim())) {errName.setVisible(true);
                    Tnomprenom.setBorder(borderT);
                }
                if(isValidName(Tnomprenom.getText().trim())) {errName.setVisible(false);
                    Tnomprenom.setBorder(borderTBlack);
                    if(isAllValid()) insidefooter3.setVisible(false);
                }

            }
        });
        Tmail.getDocument().addDocumentListener(new DocumentListener() {
            @Override

            public void insertUpdate(DocumentEvent e) {
                if(isValidEmail(Tmail.getText().trim())){
                   Tmail.setBorder(borderTBlack);
                   errMail.setVisible(false);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                if(isValidEmail(Tmail.getText().trim())){
                    Tmail.setBorder(borderTBlack);
                    errMail.setVisible(false);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text documents
            }
        });
        Ttel.getDocument().addDocumentListener(new DocumentListener() {
            @Override

            public void insertUpdate(DocumentEvent e) {
                if(isValidPhone(Ttel.getText().trim())){
                    Ttel.setBorder(borderTBlack);
                    errPhone.setVisible(false);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                if(isValidPhone(Ttel.getText().trim())){
                    Ttel.setBorder(borderTBlack);
                    errPhone.setVisible(false);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text documents
            }
        });
        Tnomprenom.getDocument().addDocumentListener(new DocumentListener() {
            @Override

            public void insertUpdate(DocumentEvent e) {
                if(isValidName(Tnomprenom.getText().trim())){
                    Tnomprenom.setBorder(borderTBlack);
                    errName.setVisible(false);}
                   /* errName.setForeground(Color.blue);
                    errName.setText("Valide");
                }else{
                    Tnomprenom.setBorder(borderT);
                    errName.setVisible(true);
                    errName.setForeground(Color.red);
                    errName.setText("Invalide");
                }*/
            }

            public void removeUpdate(DocumentEvent e) {
                if(isValidName(Ttel.getText().trim())){
                    Tnomprenom.setBorder(borderTBlack);
                    errName.setVisible(false);
                }
            }

            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text documents
            }
        });
    }

    public static void main(String s[]) throws IOException {
        new tp1();

    }

    boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,8}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    boolean isValidName(String nomP) {
        String NameRegex = "^[a-zA-Z][a-zA-Z\\s]*$";
        Pattern pattern = Pattern.compile(NameRegex);
        Matcher matcher = pattern.matcher(nomP);
        return matcher.matches();
    }
    boolean isValidPhone(String phoneNumber){
        String phoneRegex="^\\d{8}$";
        Pattern pat=Pattern.compile(phoneRegex);
        Matcher mat=pat.matcher(phoneNumber);
        return mat.matches();

    }

    boolean isAllValid(){

        if(isValidEmail(Tmail.getText().trim()) && isValidPhone(Ttel.getText().trim()) && isValidName(Tnomprenom.getText().trim())) return true;
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean ch= check.isSelected();
        String sexeHF;
        if (femme.isSelected()) sexeHF="Femme" ;
            else {
                if (homme.isSelected()) sexeHF = "Homme";
                else sexeHF="None";
            }
            if(e.getSource()==annuler){
                System.out.println("vous avez choisi \"Annuler\"");
                //System.exit(0);
                dispose();
            }
            if(e.getSource()==envoyer ){
                if (isAllValid()) {


                    System.out.println(s);
                    if (ch) {
                        try {
                            fw = new FileWriter(fi);
                            s = "";
                            s += "<h2>Name: " + Tnomprenom.getText() + "</h2>"
                                    + "<img src=\"" + imagePath + "\"" + "alt=\"Aziz\'s Image\" width=\"300\" height=\"300\">"
                                    + "<h2>Mail: " + Tmail.getText() + "</h2>" + "<h2>Tel: " + Ttel.getText() + "</h2>"
                                    + "<h2>DDN: " + jj.getSelectedItem() + "/" + mm.getSelectedItem() + "/" + aaaa.getSelectedItem() + "</h2>"
                                    + "<h2>Sexe:" + sexeHF + "</h2>"
                                    + "<h2>Formation: " + ComboBoxFormation.getSelectedItem() + "</h2>"
                                    + "<h2>Java: " + Cjava.getSelectedItem() + "</h2>"
                                    + "<h2> Python: " + Cpython.getSelectedItem() + "</h2>"
                                    + "<h2>Machine Learning: " + CmachineL.getSelectedItem() + "</h2>"
                                    + "<h2>Commentaires: </h2>" + "<p>" + Tcomment.getText() + "</p>";
                            fw.write(s);
                            fw.close();//sauvegard!!!
                            Desktop.getDesktop().open(fi);

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(null, "Saved!");
                    }
                    dispose();
                }else{
                    insidefooter3.setVisible(true);
                }

            }


    }
}
