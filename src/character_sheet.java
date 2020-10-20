import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


public class character_sheet {


    public JPanel cs_panel1;
    private JTabbedPane tabbedMenu;
    public JLabel lbl_str;
    private JLabel lbl_dex;
    private JLabel lbl_con;
    private JLabel lbl_int;
    private JLabel lbl_wis;
    private JLabel lbl_char;
    private JButton button1;
    private JLabel lbl_hp;
    private JTextField txt_hp;
    private JButton okButton;
    private JList list_traits;
    private JLabel lbl_skill_str_ath;
    private JLabel lbl_skill_dex_acr;
    private JLabel lbl_skill_dex_soh;
    private JLabel lbl_skill_dex_ste;
    private JLabel lbl_skill_int_arc;
    private JLabel lbl_skill_int_his;
    private JLabel lbl_skill_int_inv;
    private JLabel lbl_skill_int_nat;
    private JLabel lbl_skill_int_rel;
    private JLabel lbl_skill_wis_ah;
    private JLabel lbl_skill_wis_ins;
    private JLabel lbl_skill_wis_med;
    private JLabel lbl_skill_wis_per;
    private JLabel lbl_skill_wis_sur;
    private JLabel lbl_skill_cha_dec;
    private JLabel lbl_skill_cha_int;
    private JLabel lbl_skill_cha_per;
    private JLabel lbl_skill_cha_pers;
    private JLabel lbl_initiative;
    private JLabel lbl_speed;
    private JLabel lbl_passive_perception;
    private JLabel lbl_name;
    private JList list_item;
    private JLabel lbl_item_cp;
    private JLabel lbl_item_sp;
    private JLabel lbl_item_ep;
    private JLabel lbl_item_gp;
    private JLabel lbl_item_pp;
    private JList list_armor;
    private JList list_weapon;
    private JLabel lbl_item_value;
    private JLabel lbl_item_weight;
    private JLabel lbl_item_magical;
    private JLabel lbl_item_dmg;
    private JLabel lbl_item_dmgType;
    private JButton button_remove_item;
    private JButton button_add_item;
    private JButton button_armor_add;
    private JButton button_armor_remove;
    private JButton button_weapon_add;
    private JButton button_weapon_remove;
    private JLabel lbl_ac;
    private JLabel lbl_class;
    private JList list_spellsKown;
    private JList list_spellsPrep;
    private JButton addButton_known;
    private JButton removeButton_known;
    private JButton useButton_spell;
    private JLabel lbl_nameSpell;
    private JLabel lbl_dmgSpell;
    private JLabel lbl_typeSpell;
    private JLabel lbl_levelSpell;
    private JButton importButton;

    public Gamer loadgamer = new Gamer();
    public character ch = new character();
    DefaultListModel spellsprep = new DefaultListModel();
    DefaultListModel spellkown = new DefaultListModel();
    public void setData(character loadedCh){
        ch = loadedCh;
    }

    public void setChValue(){
        ch.charisma = 5;
        ch.constitution = 5;
        ch.dexterity = 5;
        ch.intelligence = 5;
        ch.strength = 5;
        ch.wisdom = 5;
        ch.size = "Small";
        ch.hp = 50;
        ch.name = "Petter Edlund";
        ch.athletics = 13;
        Trait traits = new Trait();
        traits.name = "Luck";
        traits.description = "Lets you reroll.";
        ch.traitsList.add(traits);
    }



    public void setLbl(JLabel lbl, String text) {
        lbl.setText(text);
    }

    public void setTraits(){
        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < ch.traitsList.size(); i++){
            model.addElement(ch.traitsList.get(i));
        }
        list_traits.setModel(model);
    }

    public void setSpells(){
        spell newSpell = new spell();
        newSpell.name = "Fireball";
        newSpell.level = 3;
        newSpell.type = "Fire";
        newSpell.range = 150;
        newSpell.blast = true;
        newSpell.blastRange = 20;
        newSpell.dmg = "8d6";
        ch.spells.add(newSpell);

        spell newSpell2 = new spell();
        newSpell2.name = "Chill Touch";
        newSpell2.level = 0;
        newSpell2.type = "Ice";
        newSpell2.range = 120;
        newSpell2.blast = false;
        newSpell2.blastRange = 0;
        newSpell2.dmg = "1d8";
        ch.spells.add(newSpell2);


        for(int i = 0; i < ch.spells.size(); i++){
            spellkown.addElement(ch.spells.get(i));
        }
        list_spellsKown.setModel(spellkown);
    }

    public character_sheet() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        cs_panel1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent ancestorEvent) {
                //setChValue();
                setLbl(lbl_str, Integer.toString(ch.strength));
                setLbl(lbl_char, Integer.toString(ch.charisma));
                setLbl(lbl_dex, Integer.toString(ch.dexterity));
                setLbl(lbl_int, Integer.toString(ch.intelligence));
                setLbl(lbl_wis, Integer.toString(ch.wisdom));
                setLbl(lbl_con, Integer.toString(ch.constitution));
                setLbl(lbl_hp, Integer.toString(ch.hp));
                setLbl(lbl_name, ch.name);
                setLbl(lbl_class, ch.getClasses());

                //Skills
                setLbl(lbl_skill_str_ath, Integer.toString(ch.athletics));
                setLbl(lbl_skill_cha_dec, Integer.toString(ch.deception));
                setLbl(lbl_skill_cha_int, Integer.toString(ch.intimidation));
                setLbl(lbl_skill_cha_per, Integer.toString(ch.performance));
                setLbl(lbl_skill_cha_pers, Integer.toString(ch.persuasion));
                setLbl(lbl_skill_dex_acr, Integer.toString(ch.acrobatics));
                setLbl(lbl_skill_dex_soh, Integer.toString(ch.sleight_of_hand));
                setLbl(lbl_skill_dex_ste, Integer.toString(ch.stealth));
                setLbl(lbl_skill_int_arc, Integer.toString(ch.arcana));
                setLbl(lbl_skill_int_his, Integer.toString(ch.history));
                setLbl(lbl_skill_int_inv, Integer.toString(ch.investigation));
                setLbl(lbl_skill_int_nat, Integer.toString(ch.nature));
                setLbl(lbl_skill_int_rel, Integer.toString(ch.religion));
                setLbl(lbl_skill_wis_ah, Integer.toString(ch.animal_handling));
                setLbl(lbl_skill_wis_ins, Integer.toString(ch.insight));
                setLbl(lbl_skill_wis_med, Integer.toString(ch.medicine));
                setLbl(lbl_skill_wis_per, Integer.toString(ch.perception));
                setLbl(lbl_skill_wis_sur, Integer.toString(ch.survival));

                //Other
                setLbl(lbl_ac, Integer.toString(ch.ac));
                setLbl(lbl_initiative, ch.ini);
                setLbl(lbl_speed, Integer.toString(ch.speed));
                setLbl(lbl_passive_perception, "14");


                setTraits();
                setSpells();
            }

            @Override
            public void ancestorRemoved(AncestorEvent ancestorEvent) {

            }

            @Override
            public void ancestorMoved(AncestorEvent ancestorEvent) {

            }
        });


        list_traits.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Trait traitData = ch.traitsList.get(list_traits.getSelectedIndex());
                String popupData = traitData.name + "\n" + traitData.description;
                if(e.getClickCount() == 2){
                    JOptionPane.showMessageDialog(null, popupData);
                }
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { //Set, Add, Sub HP
                String text = txt_hp.getText();
                if(text.charAt(0) == '+'){
                    String temp = "";
                    for(int i = 1; i < text.length(); i++){
                        temp = temp + text.charAt(i);
                    }
                    ch.hp = ch.hp + Integer.parseInt(temp);
                    lbl_hp.setText(Integer.toString(ch.hp));
                    txt_hp.removeAll();
                }
                else if(text.charAt(0) == '-'){
                    String temp = "";
                    for(int a = 1; a < text.length(); a++){
                        temp = temp + text.charAt(a);
                    }
                    ch.hp = ch.hp - Integer.parseInt(temp);
                    lbl_hp.setText(Integer.toString(ch.hp));
                    txt_hp.removeAll();
                }
                else{
                    ch.hp = Integer.parseInt(text);
                    lbl_hp.setText(Integer.toString(ch.hp));
                    txt_hp.removeAll();
                }
            }
        });
        button_add_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                additem additemForm = new additem();
                Item itemtest = new Item();
                itemtest.name = "Test item";
                ch.itemList.add(itemtest);
                ch.myItems.add(itemtest);
                JFrame jFrame = new JFrame("Additem");
                additemForm.loadCharacter(ch);
                jFrame.setContentPane(additemForm.panel_additem);
                //jFrame.setDefaultCloseOperation(JFrame.);
                jFrame.pack();
                jFrame.setVisible(true);
                jFrame.setSize(600, 380);
                List<Item> itemList = new ArrayList<Item>();

                if(jFrame.isVisible() == false){
                    itemList = additemForm.returnItems();
                }
            }
        });
        button_armor_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                test01 testsak = new test01();
                testsak.pack();
                testsak.setVisible(true);
                testsak.setSize(600, 600);
                String testText = "";


                testText = testsak.getText();
                DefaultListModel model = new DefaultListModel();
                model.addElement(testText);
                list_armor.setModel(model);
            }
        });
        addButton_known.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i = 0; i < ch.spells.size(); i++){
                    if(list_spellsKown.getSelectedIndex() == i){
                        String temp = ch.spells.get(i).getShort();
                        spellsprep.addElement(temp);
                    }
                }
                list_spellsPrep.setModel(spellsprep);
            }
        });
        removeButton_known.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ch.spells.remove(list_spellsKown.getSelectedIndex());
                DefaultListModel spellkown = null;
                for(int i = 0; i < ch.spells.size(); i++){
                    spellkown.addElement(ch.spells);
                }
                list_spellsKown.setModel(spellkown);
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                spell newSpell = new spell();
                newSpell.name = "Test spell import";
                newSpell.dmg = "1d4";
                newSpell.level = 20;
                newSpell.range = 30;
                newSpell.blast = false;
                newSpell.blastRange = 0;
                newSpell.description = "This is a test.";
                spellkown.addElement(newSpell);
                list_spellsKown.setModel(spellkown);
            }
        });
        list_spellsPrep.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                spell loadspell = new spell();
                loadspell = (spell) spellsprep.getElementAt(list_spellsPrep.getSelectedIndex());
                lbl_dmgSpell.setText(loadspell.dmg);
            }
        });
    }



    /*public static void main(String[] args) {
        JFrame cs_gui = new JFrame("Character sheet - Name");
        cs_gui.setContentPane(new character_sheet().cs_panel1);
        cs_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cs_gui.pack();
        cs_gui.setVisible(true);
        cs_gui.setSize(500, 600);



    }*/


}


