import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
    protected GameFactory factory;
    protected Deck deck;
    protected Rules rule;
    protected GameScorer score;
    protected UnoColors unoColors;
    protected UnoValues unoValues;
    Scanner input=new Scanner(System.in);
    protected ArrayList<UnoPlayer> unoPlayers;


    public Game() throws IllegalAccessException {
        factory = new GameFactory();
        unoPlayers=new ArrayList<>();
    }

    //    template method
    public final void play() throws IllegalAccessException {
        unoColors = createColors();
        unoValues =createValues();
        deck=buildDeck(unoColors, unoValues);
        score = setScore();
        rule=buildRule();
        startGame();

    }
    //to create players
    public ArrayList<UnoPlayer> PlayersInGame(int numOfPlayers) {
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.println("enter player " + i + " name: ");
            this.unoPlayers.add(new UnoPlayer(input.nextLine()));

        }
        return unoPlayers;

    }
    // to choose number of card at the start game
    public void numberOfCardsInHandAtStart(int numOfCards) {
        for (UnoPlayer unoPlayer : unoPlayers) {
            deck.drawCard(unoPlayer, numOfCards);
        }
    }
//    public abstract void numberOfCardsInHandAtStart();
//    public abstract ArrayList<UnoPlayer> initializePlayers() throws IllegalAccessException;
     public abstract GameScorer setScore();
    public abstract Deck  buildDeck(UnoColors unoColors, UnoValues unoValues) ;
    public abstract UnoColors createColors();
    public abstract UnoValues createValues();
    public abstract Rules buildRule();
    public abstract void startGame() ;


}