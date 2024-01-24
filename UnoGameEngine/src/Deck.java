import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck {
    protected ArrayList<Card> deck;
public Deck(){
    deck=new ArrayList<Card>();
}


    public Card drawCard() {
        Card drawCard = deck.get(0);
        deck.remove(0);
        return drawCard;
    }

public void drawCard(UnoPlayer unoPlayer, int numOfCards) {
    for (int i = 0; i < numOfCards; i++) {
        Card card = deck.remove(0);
        if (card != null) {
            unoPlayer.playerDrawCard(card);
        }
    }
}
    public boolean isEmpty() {
        return deck.size() == 0;
    }


    public abstract ArrayList<Card> createDeck(UnoColors unoColors, UnoValues unoValues) ;

    public void shuffle(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }

    public void refillDeck(ArrayList<Card> stockPile) {
        shuffle(stockPile);
        deck = stockPile;

    }

}
