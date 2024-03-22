import javax.swing.*;
import java.awt.*;

public class icon {
    public static void main(String[] args) {
        // Obtenir des icônes prédéfinies à partir du UIManager
        Icon cutIcon = UIManager.getIcon("Tree.closedIcon"); // Icône de couper
        Icon copyIcon = UIManager.getIcon("Tree.openIcon");   // Icône de copier
        Icon pasteIcon = UIManager.getIcon("Tree.leafIcon");  // Icône de coller
        Icon printIcon = UIManager.getIcon("FileView.fileIcon"); // Icône d'imprimer

        // Créer des boutons avec les icônes prédéfinies
        JButton cutButton = new JButton("Couper", cutIcon);
        JButton copyButton = new JButton("Copier", copyIcon);
        JButton pasteButton = new JButton("Coller", pasteIcon);
        JButton printButton = new JButton("Imprimer", printIcon);

        // Créer un panneau pour organiser les boutons
        JPanel panel = new JPanel();
        panel.add(cutButton);
        panel.add(copyButton);
        panel.add(pasteButton);
        panel.add(printButton);

        // Créer une fenêtre pour afficher les boutons
        JFrame frame = new JFrame("Icônes prédéfinies");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }}