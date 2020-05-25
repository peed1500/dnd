import javax.swing.*;

public class startmenu {
    private JList list1;
    private JPanel panel1;
    private JButton createCharacterButton;
    private JButton loadDataButton;
    private JButton addItemButton;
    private JButton addFeatureButton;
    private JButton addTraitButton;



    public static void main(String[] args) {
        JFrame cs_gui = new JFrame("Character sheet - Name");
        cs_gui.setContentPane(new startmenu().panel1);
        cs_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cs_gui.pack();
        cs_gui.setVisible(true);
        cs_gui.setSize(420, 300);



    }
}
