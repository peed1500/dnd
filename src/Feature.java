public class Feature implements java.io.Serializable {
    String name;
    String description;
    boolean magical;
    String dmg;
    String dmgType;

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

    boolean setSkillValue[] = new boolean[18];
    boolean classSkill = false;

    @Override
    public String toString() {
        return name;
    }
}
