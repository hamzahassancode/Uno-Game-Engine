import java.util.ArrayList;

public interface GameScorer {
    public void playerscore(ArrayList<UnoPlayer> unoPlayers, UnoPlayer winningUnoPlayer);
    boolean isGameOver(UnoPlayer unoPlayer);
}
