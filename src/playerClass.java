import java.util.ArrayList;
import java.util.List;

public class playerClass implements java.io.Serializable {

    String name;
    String description;
    //int level = 1;
    //int knownspells = 0;

    List<Integer[]> knownspells = new ArrayList<>();
    List<Integer[]> prepspells = new ArrayList<>();
    List<Integer[]> spellsperlevel = new ArrayList<>();
    List<Integer> profValue = new ArrayList<>();
    List<Boolean> classProf = new ArrayList<>();


    //int prepspells = 0;

    @Override
    public String toString() {
        return name;
    }
}
