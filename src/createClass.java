import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createClass {
    private JTabbedPane tabbedPane1;
    public JPanel panel1;
    private JTextField textField1;
    private JButton createButton;
    private JButton canButton;
    private JCheckBox spellcasterCheckBox;
    private JList list1;
    private JCheckBox prepSpellsCheckBox;
    private JCheckBox spellsKnownCheckBox;
    private JList list2;
    private JList list3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JTextArea textArea1;
    private JTable table1;

    public createClass() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        populateTable();
    }


    public void populateTable(){
        String column[] = {"Level", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        String data[][] = {{"1", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}};

        JTable jt=new JTable(data, column);
        //jt.setBounds(30,40,200,300);
        //JScrollPane sp=new JScrollPane(jt);
        table1.add(jt);
        table1.setVisible(true);
    }
}
