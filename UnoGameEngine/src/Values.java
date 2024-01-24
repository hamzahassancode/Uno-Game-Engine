import java.util.ArrayList;
import java.util.HashMap;

public abstract class Values {
        protected static ArrayList<HashMap<String, Integer>> values ;

        public abstract ArrayList<HashMap<String, Integer>> values() ;
        public static HashMap<String, Integer> getUnoValue(int nu) {
            return values.get(nu);
        }
        public static void addValue(ArrayList<HashMap<String, Integer>> values, String value, int score) {
            HashMap<String, Integer> newItem = new HashMap<>();
            newItem.put(value, score);
            values.add(newItem);
        }
        public static void removeValue(ArrayList<HashMap<String, Integer>> values, String value) {
            for (int i = 0; i < values.size(); i++) {
                HashMap<String, Integer> hashMap = values.get(i);
                // Check if the value exists in the HashMap
                if (hashMap.containsValue(value)) {
                    values.remove(i); // Remove the HashMap from the ArrayList
                    break;
                }
            }
        }
    }


