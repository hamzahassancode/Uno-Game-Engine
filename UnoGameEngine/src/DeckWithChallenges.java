import java.util.ArrayList;

public class DeckWithChallenges extends Deck {
    private static DeckWithChallenges instance;

    private DeckWithChallenges(UnoColors unoColors, UnoValues unoValues) {
        deck=createDeck(unoColors, unoValues);
        shuffle(deck);
    }

    public static DeckWithChallenges getInstance(UnoColors unoColors, UnoValues unoValues) {
        if (instance == null) {
            instance = new DeckWithChallenges(unoColors, unoValues);
        }
        return instance;
    }

    public ArrayList<Card> createDeck(UnoColors unoColors, UnoValues unoValues) {
        // Add new color
      ArrayList<Card>  deck=BasicUnoDeck.getInstance(unoColors, unoValues).getDeck();
        // Add new 3 value
        UnoColors.addColor(UnoColors.colors,"Purple");
        UnoValues.addValue(UnoValues.values,"You should do push-ups 10 times",0);
        UnoValues.addValue(UnoValues.values,"You should do 20 jumps",0);
        UnoValues.addValue(UnoValues.values,"You must not speak until the end of the game",0);
        //create 12 new card  using new color and new values and add it to the uno
        for (int i = 0; i < 4; i++) {
            deck.add(new Card(UnoColors.getUnoColor(5), unoValues.getUnoValue(16)));
            deck.add(new Card(UnoColors.getUnoColor(5), unoValues.getUnoValue(17)));
            deck.add(new Card(UnoColors.getUnoColor(5), unoValues.getUnoValue(18)));

        }
        return deck;
    }
}
