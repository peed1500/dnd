public class spell {
    String name;
    String dmg;
    String type;
    String description;
    int level;
    int range;
    Boolean blast = false;
    int blastRange;

    @Override
    public String toString(){
        if(blast){
            return "Spell: " + name + ", Damage: " + dmg + ", Damage type: " + type + ", Range: " + Integer.toString(range) +"ft, Level: " + Integer.toString(level) + ", Radius: " + blastRange;
        }
        else{
            return "Spell: " + name + ", Damage: " + dmg + ", Damage type: " + type + ", Range: " + Integer.toString(range) +"ft";
        }

    }

    public String getShort(){
        return "Level: " + level + ", Spell:" + name + ", Damage: " + dmg;
    }

    public String getName(){
        return name;
    }
}
