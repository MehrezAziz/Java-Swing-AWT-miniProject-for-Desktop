import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class listener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DocumentListener Example");
        JTextField textField = new JTextField(20);

        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Text inserted: " + textField.getText());
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("Text removed: " + textField.getText());
            }

            public void changedUpdate(DocumentEvent e) {
                // Not used for plain text documents
            }
        });

        frame.add(textField, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
