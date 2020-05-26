public class Feature implements java.io.Serializable {
    String name;
    String description;
    boolean magical;
    String dmg;
    String dmgType;

    @Override
    public String toString() {
        return name;
    }
}
