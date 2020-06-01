import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class startmenu {
    private JList list1;
    private JPanel panel1;
    private JButton createCharacterButton;
    private JButton loadDataButton;
    private JButton createItemButton;
    private JButton createFeatureButton;
    private JButton createTraitButton;
    private JButton createClassButton;
    private JButton openCharacterButton;

    Gamer loadGamer = new Gamer();
    boolean fileloaded = false;
    String filename = "file.ser";

    public void loadFile(){
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            loadGamer = (Gamer) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + loadGamer.characterList.get(0).name);

            fileloaded = true;

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught de1");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        setList(); // This is so bad don't have time or knowledge to fix
        //TODO fix this bad solution
    }

    public void setList(){
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < loadGamer.characterList.size(); i++){
            model.addElement(loadGamer.characterList.get(i));
        }
        list1.setModel(model);
    }

    public startmenu(){
        panel1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                if(fileloaded == false){
                    loadFile();
                }
                else{
                    setList();
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {







            }
        });
        openCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character_sheet ch1 = new character_sheet();
                JFrame jFrame = new JFrame("Character sheet - Name");   //TODO add get name function
                jFrame.setContentPane(ch1.cs_panel1);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                ch1.setData(loadGamer.characterList.get(0));    //TODO get character from list
                jFrame.setVisible(true);
                jFrame.setSize(600, 600);

            }
        });
    }


    public static void main(String[] args) {
        JFrame cs_gui = new JFrame("Character sheet - Name");
        cs_gui.setContentPane(new startmenu().panel1);
        cs_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cs_gui.pack();
        cs_gui.setVisible(true);
        cs_gui.setSize(420, 300);

        Gamer loadGamer2 = new Gamer();
        character ch = new character();
        playerClass currentClass = new playerClass();
        currentClass.name = "Rogue";

        ch.name = "Adam Silver";
        ch.charisma = 10;
        ch.constitution = 10;
        ch.dexterity = 15;
        ch.intelligence = 15;
        ch.strength = 10;
        ch.wisdom = 14;
        ch.size = "Small";
        ch.hp = 66;
        ch.speed = 25;
        ch.ac = 14;
        ch.ini = "+2";

        ch.playerClassList.add(currentClass);
        //Skills
        ch.acrobatics = 6;
        ch.animal_handling = 2;
        ch.arcana = 2;
        ch.athletics = 0;
        ch.deception = 4;
        ch.history = 2;
        ch.insight = 6;
        ch.intimidation = 0;
        ch.investigation = 6;
        ch.medicine = 2;
        ch.nature = 2;
        ch.perception = 6;
        ch.performance = 0;
        ch.persuasion = 0;
        ch.religion = 2;
        ch.sleight_of_hand = 2;
        ch.stealth = 6;
        ch.survival = 2;

        ch.profArray[11] = true;
        ch.setPassive(ch.wisdom, ch.perception, ch.proficiencies, ch.profArray);

        String filename2 = "file.ser";
        loadGamer2.characterList.add(ch);
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



    }

}

