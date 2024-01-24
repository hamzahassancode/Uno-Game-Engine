import java.util.ArrayList;

public class UnoScore implements GameScorer {
    private final int maxCase = 500;
    private boolean gameOver = false;

    @Override
    public void playerscore(ArrayList<UnoPlayer> unoPlayers, UnoPlayer winningUnoPlayer) {
        //To calculate the amount of winner points to be added

        int scoreForWinner = 0;

        for (UnoPlayer unoPlayer : unoPlayers) {
            scoreForWinner+= unoPlayer.getPoints();
             System.out.println("number of points for PLAYER " + unoPlayer.getName() + "is : " + unoPlayer.getPoints() );

        }
        winningUnoPlayer.setScore(scoreForWinner);
        System.out.println("the score for Player " + winningUnoPlayer.getName() + " : " + winningUnoPlayer.getScore());
    }

    public boolean isGameOver(UnoPlayer unoPlayer) {
        if (unoPlayer.getScore()>=maxCase)
        {gameOver=true;}
        return gameOver;
    }

}
