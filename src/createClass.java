import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class createClass {
    private JTabbedPane tabbedPane1;
    public JPanel panel1;
    private JTextField textField_name;
    private JButton createButton;
    private JButton cancelButton;
    private JCheckBox spellcasterCheckBox;
    private JList list1;
    private JCheckBox prepSpellsCheckBox;
    private JCheckBox spellsKnownCheckBox;
    private JList list2;
    private JList list3;
    private JTextArea textArea_description;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable tableProf;
    private JSpinner spinner1;
    private JButton testButton;

    Gamer loadGamer = new Gamer();
    playerClass newPlayerClass = new playerClass();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    //Prof
    DefaultTableModel model2 = new DefaultTableModel();
    JTable tableProfData = new JTable(model2);

    public createClass() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setValues();
            }
        });

        populateTable();
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> test = new ArrayList<>();
                test = getCollum(1, false, tableProf);
                String temp = "";
                for(int i = 0; i < test.size(); i++){
                    temp = temp + test.get(i).toString() + "\n";
                }
                textArea_description.setText(temp);
            }
        });
    }

    public ArrayList<Integer> getCollum(int row, boolean getfirst, JTable tableTemp){
        int getfirstTrue = 1;
        if(getfirst)
            getfirstTrue =  - 1;
        ArrayList<Integer> values = new ArrayList<>();

        for(int i = getfirstTrue; i < 20; i++){
            if(tableTemp.getValueAt(i, row) != null){
                String temp = tableProfData.getValueAt(i, row).toString();
                values.add(Integer.parseInt(temp));
            }
            else{
                values.add(0);
            }
        }
        return values;
    }

    public ArrayList<Integer> getRow(int collum, boolean getfirst, JTable tableTemp){
        int getfirstTrue = 1;
        if(getfirst)
            getfirstTrue =  - 1;
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = getfirstTrue; i < 20; i++){
            if(tableTemp.getValueAt(collum, i) != null){
                String temp = tableTemp.getValueAt(collum, i).toString();
                values.add(Integer.parseInt(temp));
            }
            else{
                values.add(0);
            }
        }
        return values;
    }

    public  Integer[] convertIntegers(List<Integer> integersValues)
    {
        Integer[] ret = new Integer[integersValues.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integersValues.get(i).intValue();
        }
        return ret;
    }

    public void createClass(){

        Gamer loadGamer2 = new Gamer();
        loadGamer2 = loadGamer;
        loadGamer2.playerClassList.add(newPlayerClass);
        String filename2 = "file.ser";

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename2);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(loadGamer2);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught se");
        }
        Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        activeWindow.dispose();
    }

    public void setValues(){
        newPlayerClass.name = textField_name.getText();
        newPlayerClass.description = textArea_description.getText();
        newPlayerClass.profValue = getCollum(1, false, tableProf);
        if(spellcasterCheckBox.isEnabled()){
            newPlayerClass.spellcaster = true;
            for (int i = 0; i < 20; i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp = getRow(i, false, table1);
                newPlayerClass.spellsperlevel.add(convertIntegers(temp));
            }
        }

        if(spellsKnownCheckBox.isEnabled()){
            newPlayerClass.prepspellsBool = true;
            for (int i = 0; i < 20; i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp = getRow(i, false, table2);
                newPlayerClass.knownspells.add(convertIntegers(temp));
            }
        }
        if(prepSpellsCheckBox.isEnabled()){
            newPlayerClass.spellsknownBool = true;
            for (int i = 0; i < 20; i++){
                ArrayList<Integer> temp = new ArrayList<>();
                temp = getRow(i, false, table3);
                newPlayerClass.prepspells.add(convertIntegers(temp));
            }
        }

        createClass();
    }

    public void populateTable(){
        //Spells


        // Create a couple of columns for spells
        model.addColumn("Level");
        for(int i = 0; i <= 20; i++){
            model.addColumn(Integer.toString(i));
        }

        // Append a row for spells
        for(int a = 0; a <= 20; a++){
            model.addRow(new Object[]{Integer.toString(a)});
        }

        model2.addColumn("Level");
        model2.addColumn("Prof");
        for(int a = 0; a <= 20; a++){
            model2.addRow(new Object[]{Integer.toString(a)});
        }


        table1.setModel(model);
        table2.setModel(model);
        table3.setModel(model);
        tableProf.setModel(model2);
    }
}
