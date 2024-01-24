import java.util.ArrayList;

public class UnoColors extends Colors {
    private static UnoColors instance;

    private UnoColors() {
        this.colors = createColors();
    }

    public static UnoColors getInstance() {
        if (instance == null) {
            instance=new UnoColors();
        }
        return instance;
    }

    public ArrayList<String> createColors() {
        ArrayList<String> colors = new ArrayList<>();
        addColor(colors, "Red");//0
        addColor(colors, "Blue");//1
        addColor(colors, "Green");//2
        addColor(colors, "Yellow");//3
        addColor(colors, "Wild");//4
        return colors;

    }
    public static void addColor(ArrayList<String> colors, String color) {
        colors.add(color);
    }
    public static String getUnoColor(int nu) {
        return colors.get(nu);
    }
    public static void removeColor(ArrayList<String> colors, String color) {
        colors.remove(color);

    }

    public int size() {
        return colors.size();
    }
}
