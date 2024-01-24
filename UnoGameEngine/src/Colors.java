import java.util.ArrayList;

public abstract class  Colors {
    protected static ArrayList<String> colors ;

    public abstract ArrayList<String> createColors() ;
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
