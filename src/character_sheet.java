import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class character_sheet{


    private JPanel cs_panel1;
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
    private JList list1;
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
    private JList list2;

    character ch = new character();

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
        Trait traits = new Trait();
        traits.name = "Luck";
        traits.description = "This is a test";
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
        list1.setModel(model);
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
                setChValue();
                setLbl(lbl_str, Integer.toString(ch.strength));
                setLbl(lbl_char, Integer.toString(ch.charisma));
                setLbl(lbl_dex, Integer.toString(ch.dexterity));
                setLbl(lbl_int, Integer.toString(ch.intelligence));
                setLbl(lbl_wis, Integer.toString(ch.wisdom));
                setLbl(lbl_con, Integer.toString(ch.constitution));
                setLbl(lbl_hp, Integer.toString(ch.hp));
                setLbl(lbl_name, ch.name);
                setTraits();
            }

            @Override
            public void ancestorRemoved(AncestorEvent ancestorEvent) {

            }

            @Override
            public void ancestorMoved(AncestorEvent ancestorEvent) {

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
    }



    public static void main(String[] args) {
        JFrame cs_gui = new JFrame("Character sheet - Name");
        cs_gui.setContentPane(new character_sheet().cs_panel1);
        cs_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cs_gui.pack();
        cs_gui.setVisible(true);
        cs_gui.setSize(500, 600);



    }


}


