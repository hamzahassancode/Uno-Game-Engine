
import java.util.HashMap;

public class Card {
    private final String color;
    private final HashMap<String, Integer> value;


    public Card(String color, HashMap<String, Integer> value) {
        this.color = color;
        this.value = value;

    }


    public String getColor() {
        return this.color;
    }

    public HashMap<String,Integer> getValue() {
        return this.value;
    }

    //The value of the penalty is returned for the card
    public Integer getValuePenalty() {
        if (!this.value.isEmpty()) {
            return this.value.values().iterator().next();
        }
        return 0; // if there are no penalties
    }

    public String toString() {
        return color + "_" + value.toString();
    }


}

