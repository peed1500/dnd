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
                jFrame.setContentPane(new character_sheet().cs_panel1);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.pack();
                //jFrame(ch1);
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
        ch.name = "Serilez test";
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

