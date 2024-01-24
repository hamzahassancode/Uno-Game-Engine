import java.util.ArrayList;
import java.util.HashMap;

public class UnoValues extends Values {
    //protected static ArrayList<HashMap<String, Integer>> values ;
    private static UnoValues instance;

    private UnoValues() {
        this.values = values();
    }

    public static UnoValues getInstance() {
        if (instance == null) {
            instance=new UnoValues();
        }
        return instance;
    }
    @Override
    public ArrayList<HashMap<String, Integer>> values() {
        ArrayList<HashMap<String, Integer>> values = new ArrayList<>();
        addValue(values, "Zero", 0);
        addValue(values, "One", 1);
        addValue(values, "Two", 2);
        addValue(values, "Three", 3);
        addValue(values, "Four", 4);
        addValue(values, "Five", 5);
        addValue(values, "Six", 6);
        addValue(values, "Seven", 7);
        addValue(values, "Eight", 8);
        addValue(values, "Nine", 9);
        addValue(values, "DrawTwo", 20);//10
        addValue(values, "Skip", 20);//11
        addValue(values, "Reverse", 20);//12
        addValue(values, "Wild", 50);//13
        addValue(values, "WildFour", 50);//14
        addValue(values, "NoValue", 50);//15

        return values;
    }

}
