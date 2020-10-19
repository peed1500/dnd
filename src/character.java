import javax.swing.*;
import java.io.IOException;
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
    int ac;
    int passive_preception;
    String ini = "0";
    List<Integer> level = new ArrayList<>();


    List<playerClass> playerClassList = new ArrayList<playerClass>();
    List<spell> spells = new ArrayList<spell>();
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
    int proficiencies;
    List<Trait> traitsList = new ArrayList<Trait>();
    List<Item> itemList = new ArrayList<Item>();
    List<Item> myItems = new ArrayList<Item>();
    boolean profArray[] = new boolean[18];


    @Override
    public String toString() {
        String coreData = name + "\n";
        for(int i = 0; i < playerClassList.size(); i++){
            coreData = coreData + " " + playerClassList.get(i);
        }

        return coreData;

    }

    character(){
        try
        {
            passive_preception = setPassive(wisdom, perception, proficiencies, profArray);
        }
        catch(Exception ex)
        {
            System.out.println("IOException is caught failed to set passive perp");
        }
    }

    public int setPassive(int inputWisdom,int inputPerception, int prof ,boolean inputProfArray[]){

        int result;

        if(inputProfArray[11] == true){
            result = inputWisdom + inputPerception + prof;
        }
        else{
            result = inputWisdom + inputPerception;

        }
        return result;
    }

    public String getClasses(){
        String result = "";
        for(int i = 0; i < playerClassList.size(); i++){
            result = result + playerClassList.get(i);
        }
        return result;
    }

}
