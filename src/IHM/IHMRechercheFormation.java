package IHM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IHMRechercheFormation extends JFrame {

    private JLabel referenceLabel, titleLabel, dateLabel, lieuLabel, certificationLabel;
    private JTextField referenceField, titleField;
    private JTextField dateTextField, lieuTextField;
    private JButton searchButton, modifyButton, deleteButton, cancelButton;
    private JCheckBox certificationCheckbox;

    public IHMRechercheFormation() {
        super("Search Training");
        initializeComponents();
        createLayout();
        addActionListeners();
        setVisible(true);    }

    private void initializeComponents() {
        referenceLabel = new JLabel("Référence :");
        titleLabel = new JLabel("Titre :");
        dateLabel = new JLabel("Date :");
        lieuLabel = new JLabel("Lieu :");
        certificationLabel = new JLabel("Certification :");

        referenceField = new JTextField(15);
        titleField = new JTextField(20);

        // Sample data for comboboxes (replace with actual data source)
        dateTextField = new JTextField(15);
        lieuTextField = new JTextField(15);

        certificationCheckbox = new JCheckBox();

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
        addComponent(panel, referenceLabel, c, 0, 0, 1, 1);
        addComponent(panel, referenceField, c, 1, 0, 2, 1);
        addComponent(panel, titleLabel, c, 0, 1, 1, 1);
        addComponent(panel, titleField, c, 1, 1, 2, 1);
        addComponent(panel, dateLabel, c, 0, 2, 1, 1);
        addComponent(panel, dateTextField, c, 1, 2, 2, 1);
        addComponent(panel, lieuLabel, c, 0, 3, 1, 1);
        addComponent(panel, lieuTextField, c, 1, 3, 2, 1);
        addComponent(panel, certificationLabel, c, 0, 4, 1, 1);
        addComponent(panel, certificationCheckbox, c, 1, 4, 2, 1);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        BoxLayout yb=new BoxLayout(buttonPanel,BoxLayout.Y_AXIS);
        buttonPanel.setLayout(yb);
        buttonPanel.add(searchButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(cancelButton);
        c.fill = GridBagConstraints.NONE;
        c.gridy = 2;
        c.gridheight = 4;
        addComponent(panel, buttonPanel, c, 4, 0, 1, 4);

        getContentPane().add(panel);
        setSize(500,250);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }

    private void addComponent(JPanel panel, JComponent component, GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        panel.add(component, c);
    }

    private void addActionListeners() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement search functionality based on user input
                JOptionPane.showMessageDialog(null, "Searching...");
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement modification functionality, potentially opening another form
                JOptionPane.showMessageDialog(null, "Modification not implemented yet.");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement deletion functionality, prompting for confirmation before deleting
                JOptionPane.showMessageDialog(null, "Deletion not implemented yet.");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IHMRechercheFormation().setVisible(true));
    }
}
