import java.util.ArrayList;

public interface Rules {
    public void initializeTable(Deck deck);
    public ArrayList<Card> cardCanUsed(UnoPlayer unoPlayer) ;

    public void playCard(ArrayList<UnoPlayer> unoPlayers);

    public boolean isCanPlay(ArrayList<UnoPlayer> unoPlayers);

    public void nextPlayer(ArrayList<UnoPlayer> unoPlayers);

    public int getCurrentPlayer();

}
