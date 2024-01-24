import java.util.ArrayList;
/**
 * The BasicDeck class consists of 108 uno cards. There are four suits, Red, Green,
 * Yellow and Blue, each consisting of one 0 card, two 1 cards, 2s, 3s, 4s,
 * 5s, 6s, 7s, 8s and 9s; two Draw Two cards; two Skip cards; and two Reverse
 * cards. In addition there are four Wild cards and four Wild Draw Four cards.
 */
public class BasicUnoDeck extends Deck {
    private static BasicUnoDeck instance ;

    private BasicUnoDeck(UnoColors unoColors, UnoValues unoValues) {
        this.deck = createDeck(unoColors, unoValues);
        shuffle(deck);
    }

    public static BasicUnoDeck getInstance(UnoColors unoColors, UnoValues unoValues) {
        if (instance==null){
            instance =new BasicUnoDeck(unoColors, unoValues);
        }
        return instance;
    }


    @Override
    public ArrayList<Card> createDeck(UnoColors unoColors, UnoValues unoValues) {
        ArrayList<Card> deck = new ArrayList<Card>();

        for (int i = 0; i < unoColors.size() - 1; i++) {
            String color = unoColors.getUnoColor(i);
            // Add 1 zero
            deck.add(new Card(color, unoValues.getUnoValue(0)));
            // Add 2 cards for 1-9
            for (int j = 1; j < 10; j++) {
                deck.add(new Card(color, unoValues.getUnoValue(j)));
                deck.add(new Card(color, unoValues.getUnoValue(j)));
            }
            // Add Draw Two, Skip, and Reverse
            for (int j = 10; j < 13; j++) {
                deck.add(new Card(color, unoValues.getUnoValue(j)));
                deck.add(new Card(color, unoValues.getUnoValue(j)));
            }

        }
        // Add Wild and WildFour Cards
        for (int i = 0; i < 4; i++) {
            deck.add(new Card(unoColors.getUnoColor(4), unoValues.getUnoValue(13)));
            deck.add(new Card(unoColors.getUnoColor(4), unoValues.getUnoValue(14)));
        }
       // System.out.println("cards in deck = " + deck.size());
        return deck;
    }
        public ArrayList<Card> getDeck(){
        return deck;
}




}



