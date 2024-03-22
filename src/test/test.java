import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabbed Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", new JLabel("Content of Tab 1"));
        tabbedPane.addTab("Tab 2", new JLabel("Content of Tab 2"));
        tabbedPane.addTab("Tab 3", new JLabel("Content of Tab 3"));

        // Set the third tab to be activated
        tabbedPane.setSelectedIndex(1);

        frame.add(tabbedPane);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}