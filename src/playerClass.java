import java.util.ArrayList;
import java.util.List;

public class playerClass implements java.io.Serializable {

    String name;
    String description;
    int level = 1;
    int knownspells = 0;
    int prepspells = 0;
    List<Integer> classProf = new ArrayList<Integer>();

    @Override
    public String toString() {
        return name;
    }
}
