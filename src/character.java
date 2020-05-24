import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class character {

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


}
