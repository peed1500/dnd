import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;


public class createCharacter {
    private JTextField textField_Name;
    private JTextField textField_Str;
    private JTextField textField_Dex;
    private JTextField textField_Con;
    private JTextField textField_Int;
    private JTextField textField_Wis;
    private JTextField textField_Cha;
    private JButton setAbilltyScoreButton;
    public JPanel panel1;
    private JButton createButton;
    private JTextField textField_Acrobatics;
    private JCheckBox proficientCheckBox_Acrobatics;
    private JButton importClassButton;
    private JTextField textField_AnimalHandling;
    private JTextField textField_Arcana;
    private JTextField textField_Athletics;
    private JTextField textField_Deception;
    private JTextField textField_History;
    private JTextField textField_Insight;
    private JTextField textField_Intimidation;
    private JTextField textField_Investigation;
    private JTextField textField_Medicine;
    private JTextField textField_Nature;
    private JTextField textField_Perception;
    private JTextField textField_Performance;
    private JTextField textField_Persuasion;
    private JTextField textField_Religion;
    private JTextField textField_SleightOfHand;
    private JTextField textField_Stealth;
    private JTextField textField_Survival;
    private JCheckBox proficientCheckBox_AnimalHandling;
    private JCheckBox proficientCheckBox_Arcana;
    private JCheckBox proficientCheckBox_Athletics;
    private JCheckBox proficientCheckBox_Deception;
    private JCheckBox proficientCheckBox_History;
    private JCheckBox proficientCheckBox_Insight;
    private JCheckBox proficientCheckBox_Intimidation;
    private JCheckBox proficientCheckBox_Investigation;
    private JCheckBox proficientCheckBox_Medicine;
    private JCheckBox proficientCheckBox_Nature;
    private JCheckBox proficientCheckBox_Perception;
    private JCheckBox proficientCheckBox_Performance;
    private JCheckBox proficientCheckBox_Persuasion;
    private JCheckBox proficientCheckBox_Religion;
    private JCheckBox proficientCheckBox_SleightOfHand;
    private JCheckBox proficientCheckBox_Stealth;
    private JCheckBox proficientCheckBox_Survival;
    private JCheckBox proficientCheckBox_Str;
    private JCheckBox proficientCheckBox_Dex;
    private JCheckBox proficientCheckBox_Con;
    private JCheckBox proficientCheckBox_Int;
    private JCheckBox proficientCheckBox_Wis;
    private JCheckBox proficientCheckBox_Cha;
    private JLabel lbl_test;
    private JButton button_Lock;
    private JComboBox comboBox1;


    public playerClass testClass = new playerClass();
    int level = 1;
    public character newCharacter = new character();
    Gamer loadGamer = new Gamer();
    public boolean textfieldEditable = true;
    public boolean onOff = true;

    public void setProfValue(JTextField textbox, boolean addSub){
        int temp = Integer.parseInt(textbox.getText());
        if(addSub)
            temp = temp + level - 1;
        else
            temp = temp - level - 1;
        textbox.setText(Integer.toString(temp));
    }

    public void setComboBoxClass(){
        String[] listData = new String[loadGamer.playerClassList.size()];
        for(int i = 0; i < loadGamer.playerClassList.size(); i++){
            listData[i] = loadGamer.playerClassList.get(i).name;
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(listData);
        comboBox1.setModel(model);
    }

    public void testdata(){
        //Temp test data

        testClass.name = "testClass";
        //testClass.classProf.add(2);



    }

    public int getPlusValue(int value, Boolean proftrue, int prof){
        if(value == 10){
            if(proftrue){
                return prof;
            }
            return 0;
        }
        else{
            value = value - 10;
            value = value / 2;
            if(proftrue)
                value = value + prof;
            return value;
        }

    }

    public void setValue(int str, int dex, int con, int varint, int wis, int cha
                        , Boolean Bstr, Boolean Bdex, Boolean Bcon, Boolean Bint, Boolean Bwis, Boolean Bcha){
        //Set skill values
        str = getPlusValue(str, Bstr, level);
        dex = getPlusValue(dex, Bdex, level);
        con = getPlusValue(con, Bdex, level);
        varint = getPlusValue(varint, Bint, level);
        wis = getPlusValue(wis, Bwis, level);
        cha = getPlusValue(cha, Bcha, level);

        String Sstr = Integer.toString(str);
        String Sdex = Integer.toString(dex);
        String Scon = Integer.toString(con);
        String Sint = Integer.toString(varint);
        String Swis = Integer.toString(wis);
        String Scha = Integer.toString(cha);


        //Str
        if(Bstr){
            textField_Athletics.setText(Sstr);

        }

        //Dex
        if(Bdex){
            textField_Acrobatics.setText(Sdex);
            textField_SleightOfHand.setText(Sdex);
            textField_Stealth.setText(Sdex);

        }

        //Int
        if(Bint){
            textField_Arcana.setText(Sint);
            textField_History.setText(Sint);
            textField_Investigation.setText(Sint);
            textField_Nature.setText(Sint);
            textField_Religion.setText(Sint);

        }

        //Wis
        if(Bwis){
            textField_AnimalHandling.setText(Swis);
            textField_Insight.setText(Swis);
            textField_Medicine.setText(Swis);
            textField_Perception.setText(Swis);
            textField_Survival.setText(Swis);

        }

        //Cha
        if(Bwis){
            textField_Deception.setText(Scha);
            textField_Investigation.setText(Scha);
            textField_Performance.setText(Scha);
            textField_Persuasion.setText(Scha);

        }


    }

    public createCharacter() {
        setAbilltyScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setAbilityScoreRandom();
            }
        });
        setComboBoxClass();
        testdata();
        onOff = true;


        proficientCheckBox_Str.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Str, proficientCheckBox_Str.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        proficientCheckBox_Dex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Dex, proficientCheckBox_Dex.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        proficientCheckBox_Con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Con, proficientCheckBox_Con.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        proficientCheckBox_Int.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Int, proficientCheckBox_Int.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        proficientCheckBox_Wis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Wis, proficientCheckBox_Wis.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        proficientCheckBox_Cha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setProfValue(textField_Cha, proficientCheckBox_Cha.isSelected());
                int str = Integer.parseInt(textField_Str.getText());
                int dex = Integer.parseInt(textField_Dex.getText());
                int con = Integer.parseInt(textField_Con.getText());
                int varint = Integer.parseInt(textField_Int.getText());
                int wis = Integer.parseInt(textField_Wis.getText());
                int cha = Integer.parseInt(textField_Cha.getText());
                setValue(str, dex, con, varint, wis, cha, proficientCheckBox_Str.isSelected(), proficientCheckBox_Dex.isSelected(),
                        proficientCheckBox_Con.isSelected(), proficientCheckBox_Int.isSelected(), proficientCheckBox_Wis.isSelected(),
                        proficientCheckBox_Cha.isSelected());
            }
        });
        button_Lock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(textfieldEditable){
                    textField_Str.setEditable(false);
                    textField_Dex.setEditable(false);
                    textField_Con.setEditable(false);
                    textField_Int.setEditable(false);
                    textField_Wis.setEditable(false);
                    textField_Cha.setEditable(false);
                    proficientCheckBox_Str.setEnabled(true);
                    proficientCheckBox_Dex.setEnabled(true);
                    proficientCheckBox_Con.setEnabled(true);
                    proficientCheckBox_Int.setEnabled(true);
                    proficientCheckBox_Wis.setEnabled(true);
                    proficientCheckBox_Cha.setEnabled(true);
                    textfieldEditable = false;
                    setAbilltyScoreButton.setEnabled(false);
                    button_Lock.setText("Unlock abillty score");


                }
                else{
                    textField_Str.setEditable(true);
                    textField_Dex.setEditable(true);
                    textField_Con.setEditable(true);
                    textField_Int.setEditable(true);
                    textField_Wis.setEditable(true);
                    textField_Cha.setEditable(true);
                    proficientCheckBox_Str.setEnabled(false);
                    proficientCheckBox_Dex.setEnabled(false);
                    proficientCheckBox_Con.setEnabled(false);
                    proficientCheckBox_Int.setEnabled(false);
                    proficientCheckBox_Wis.setEnabled(false);
                    proficientCheckBox_Cha.setEnabled(false);
                    textfieldEditable = true;
                    setAbilltyScoreButton.setEnabled(true);
                    button_Lock.setText("Lock abillty score");


                }

                int str = getPlusValue(Integer.parseInt(textField_Str.getText()), false, level);
                int dex = getPlusValue(Integer.parseInt(textField_Dex.getText()), false, level);
                int con = getPlusValue(Integer.parseInt(textField_Con.getText()), false, level);
                int varint = getPlusValue(Integer.parseInt(textField_Int.getText()), false, level);
                int wis = getPlusValue(Integer.parseInt(textField_Wis.getText()), false, level);
                int cha = getPlusValue(Integer.parseInt(textField_Cha.getText()), false, level);



                String Sstr = Integer.toString(str);
                String Sdex = Integer.toString(dex);
                String Scon = Integer.toString(con);
                String Sint = Integer.toString(varint);
                String Swis = Integer.toString(wis);
                String Scha = Integer.toString(cha);



                textField_Athletics.setText(Sstr);


                //Dex

                textField_Acrobatics.setText(Sdex);
                textField_SleightOfHand.setText(Sdex);
                textField_Stealth.setText(Sdex);



                //Int

                textField_Arcana.setText(Sint);
                textField_History.setText(Sint);
                textField_Investigation.setText(Sint);
                textField_Nature.setText(Sint);
                textField_Religion.setText(Sint);



                //Wis

                textField_AnimalHandling.setText(Swis);
                textField_Insight.setText(Swis);
                textField_Medicine.setText(Swis);
                textField_Perception.setText(Swis);
                textField_Survival.setText(Swis);



                //Cha

                textField_Deception.setText(Scha);
                textField_Intimidation.setText(Scha);
                textField_Performance.setText(Scha);
                textField_Persuasion.setText(Scha);

            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createCharacter();

            }
        });
    }

    public void createCharacter(){
        newCharacter.strength = Integer.parseInt(textField_Str.getText());
        newCharacter.dexterity = Integer.parseInt(textField_Dex.getText());
        newCharacter.constitution = Integer.parseInt(textField_Con.getText());
        newCharacter.intelligence = Integer.parseInt(textField_Int.getText());
        newCharacter.wisdom = Integer.parseInt(textField_Wis.getText());
        newCharacter.charisma = Integer.parseInt(textField_Cha.getText());

        newCharacter.acrobatics = Integer.parseInt(textField_Acrobatics.getText());
        newCharacter.animal_handling = Integer.parseInt(textField_AnimalHandling.getText());
        newCharacter.arcana = Integer.parseInt(textField_Arcana.getText());
        newCharacter.athletics = Integer.parseInt(textField_Athletics.getText());
        newCharacter.deception = Integer.parseInt(textField_Deception.getText());
        newCharacter.history = Integer.parseInt(textField_History.getText());
        newCharacter.insight = Integer.parseInt(textField_Insight.getText());
        newCharacter.intimidation = Integer.parseInt(textField_Intimidation.getText());
        newCharacter.medicine = Integer.parseInt(textField_Medicine.getText());
        newCharacter.nature = Integer.parseInt(textField_Nature.getText());
        newCharacter.perception = Integer.parseInt(textField_Perception.getText());
        newCharacter.persuasion = Integer.parseInt(textField_Persuasion.getText());
        newCharacter.religion = Integer.parseInt(textField_Religion.getText());
        newCharacter.sleight_of_hand = Integer.parseInt(textField_SleightOfHand.getText());
        newCharacter.stealth = Integer.parseInt(textField_Stealth.getText());
        newCharacter.survival = Integer.parseInt(textField_Survival.getText());

        newCharacter.name = textField_Name.getText();

        loadGamer.characterList.add(newCharacter);

        Gamer loadGamer2 = new Gamer();
        loadGamer2 = loadGamer;
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
        onOff = false;
        Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
        activeWindow.dispose();

    }

    public character returnCharacter(){

        return newCharacter;
    }

    public void setAbilityScoreRandom(){
        textField_Str.setText(Integer.toString(getRandomNumberInRange(1, 20)));
        textField_Dex.setText(Integer.toString(getRandomNumberInRange(1, 20)));
        textField_Con.setText(Integer.toString(getRandomNumberInRange(1, 20)));
        textField_Int.setText(Integer.toString(getRandomNumberInRange(1, 20)));
        textField_Wis.setText(Integer.toString(getRandomNumberInRange(1, 20)));
        textField_Cha.setText(Integer.toString(getRandomNumberInRange(1, 20)));
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
