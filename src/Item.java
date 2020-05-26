import java.util.ArrayList;
import java.util.List;

public class Item implements java.io.Serializable {

    String name;
    String description;
    String dmg;
    String dmgType;
    double weight = 0;
    double value = 0;
    boolean magical = false;
    List<Feature> featureList = new ArrayList<Feature>();

    Item(){ //Sets magical if it has a magical feature
        if(featureList.size() != -1){
            for(int i = 0; i < featureList.size(); i++){
                if(featureList.get(i).magical == true){
                    magical = true;
                }
            }

        }
    }
}
