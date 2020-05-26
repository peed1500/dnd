import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class character implements java.io.Serializable {

    //Core stats

    String name;
    String background; //TODO Fix own object later
    String personality_trait; //TODO Fix own object later
    String ideals; //TODO Fix own object later
    String bonds; //TODO Fix own object later
    String flaws; //TODO Fix own object later
    String size;
    int hp;
    int speed;
    int exp;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;

    List<playerClass> playerClassList = new ArrayList<playerClass>();

    //Skills

    int acrobatics;
    int animal_handling;
    int arcana;
    int athletics;
    int deception;
    int history;
    int insight;
    int intimidation;
    int investigation;
    int medicine;
    int nature;
    int perception;
    int performance;
    int persuasion;
    int religion;
    int sleight_of_hand;
    int stealth;
    int survival;

    //Other

    Item items;
    Prof proficiencies;
    List<Trait> traitsList = new ArrayList<Trait>();
    List<Item> itemList = new ArrayList<Item>();


    @Override
    public String toString() {
        String coreData = name + "\n";
        for(int i = 0; i < playerClassList.size(); i++){
            coreData = coreData + " " + playerClassList.get(i);
        }

        return coreData;

    }

}
