
public class GameFactory {

    //To provide several options available for use deck
    public Deck buildDeck(int i, UnoColors unoColors, UnoValues unoValues) {
        switch (i) {
            case 1:
                return BasicUnoDeck.getInstance(unoColors, unoValues);

            case 2:
                return DeckWithChallenges.getInstance(unoColors, unoValues);
            default:
                return BasicUnoDeck.getInstance(unoColors, unoValues);
        }
    }

    public GameScorer buildGameScorer(int i) {
        switch (i) {
            case 1:
                return new UnoScore();
            default:
                return new UnoScore();
        }
    }
    public UnoValues createValues(int i) {
        switch (i) {
            case 1:
                return UnoValues.getInstance();
            default:
                return UnoValues.getInstance();
        }
    }
    public UnoColors createColors(int i) {
        switch (i) {
            case 1:
                return UnoColors.getInstance();
            case 2:
                return null;
            default:
                return UnoColors.getInstance();
        }
    }
    public Rules buildRule(int i) {
        switch (i) {
            case 1:
                return new BasicUnoRuleValidator();
            default:
                return new BasicUnoRuleValidator();
        }
    }

}
