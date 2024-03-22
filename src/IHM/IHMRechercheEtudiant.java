package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHMRechercheEtudiant extends JFrame {

    private JLabel studentIdLabel, firstNameLabel, lastNameLabel, programLabel, levelLabel, groupLabel,listdemande;
    private JTextField studentIdField, firstNameField, lastNameField;
    private JComboBox<String> programComboBox, levelComboBox, groupComboBox;
    private JButton ajoutdemande, cancelButton,supprimedemande,searchButton,modifyButton,deleteButton;

    JTable jt_demande;
    public IHMRechercheEtudiant() {
        super("Recherche d'un étudiant"); // "Adding a student"
        initializeComponents();
        createLayout();
        addActionListeners();
        setVisible(true);
    }

    private void initializeComponents() {
        studentIdLabel = new JLabel("Numéro de carte ETD :"); // "Student ID card number"
        firstNameLabel = new JLabel("Nom :"); // "First Name"
        lastNameLabel = new JLabel("Prénom :"); // "Last Name"
        programLabel = new JLabel("Filière :"); // "Program"
        levelLabel = new JLabel("Niveau :"); // "Level"
        groupLabel = new JLabel("Groupe :"); // "Group"
        listdemande=new JLabel("Liste demandes");

        String []titre=new String[]{"A","B","C"};
        String [][] data=new String[][]{{"val1","val2","val3"}};
        jt_demande=new JTable(data,titre);

        studentIdField = new JTextField(15);
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);

        // Sample data for comboboxes (replace with actual data source)
        String[] programs = {"FIA1","FIA2","FIA3","FIA4"};
        programComboBox = new JComboBox<>(programs);
        String[] levels = {"Licence 1", "Licence 2", "Licence 3"};
        levelComboBox = new JComboBox<>(levels);
        String[] groups = {"A", "B", "C"};
        groupComboBox = new JComboBox<>(groups);

        ajoutdemande = new JButton("Ajouter demande"); // "Add"
        supprimedemande = new JButton("Supprimer demande"); // "Cancel"

        searchButton = new JButton("Search");
        modifyButton = new JButton("Modify");
        deleteButton = new JButton("Delete");
        cancelButton = new JButton("Cancel");
    }

    private void createLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Add labels and corresponding components
        c.fill = GridBagConstraints.HORIZONTAL;
        addComponent(panel, studentIdLabel, c, 0, 0, 1, 1);
        addComponent(panel, studentIdField, c, 1, 0, 2, 1);
        addComponent(panel, firstNameLabel, c, 0, 1, 1, 1);
        addComponent(panel, firstNameField, c, 1, 1, 2, 1);
        addComponent(panel, lastNameLabel, c, 0, 2, 1, 1);
        addComponent(panel, lastNameField, c, 1, 2, 2, 1);
        addComponent(panel, programLabel, c, 0, 3, 1, 1);
        addComponent(panel, programComboBox, c, 1, 3, 2, 1);
        addComponent(panel, levelLabel, c, 0, 4, 1, 1);
        addComponent(panel, levelComboBox, c, 1, 4, 2, 1);
        addComponent(panel, groupLabel, c, 0, 5, 1, 1);
        addComponent(panel, groupComboBox, c, 1, 5, 2, 1);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(ajoutdemande);
        buttonPanel.add(supprimedemande);
        c.fill = GridBagConstraints.NONE;
        c.gridy = 4;
        c.gridwidth = 3;
        addComponent(panel, buttonPanel, c, 0, 6, 3, 1);

        JPanel buttonPanel2 = new JPanel();
        BoxLayout yb=new BoxLayout(buttonPanel2,BoxLayout.Y_AXIS);
        buttonPanel2.setLayout(yb);
        buttonPanel2.add(searchButton);
        buttonPanel2.add(modifyButton);
        buttonPanel2.add(deleteButton);
        buttonPanel2.add(cancelButton);
        c.fill = GridBagConstraints.NONE;
        c.gridy = 2;
        c.gridheight = 0;
        addComponent(panel, buttonPanel2, c, 4, 0, 1, 4);

        JPanel p3=new JPanel();
        p3.add(listdemande);
        p3.add(new JScrollPane(jt_demande));
        addComponent(panel,p3,c,0,7,1,3);


        getContentPane().add(panel);
        setSize(1000,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addComponent(JPanel panel, JComponent component, GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        panel.add(component, c);
    }

    private void addActionListeners() {
        ajoutdemande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add validation and logic to save student information
                JOptionPane.showMessageDialog(null, "Saving student information...");
                // Close the form after successful saving (optional)
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        new IHMRechercheEtudiant().setVisible(true);
    }
}