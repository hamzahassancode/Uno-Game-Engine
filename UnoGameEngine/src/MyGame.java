public class MyGame extends Game {
    public MyGame() throws IllegalAccessException {
        super();
    }

    @Override
    public GameScorer setScore() {
        return factory.buildGameScorer(1);
    }

    @Override
    public Deck buildDeck(UnoColors unoColors, UnoValues unoValues) {
        return factory.buildDeck(1, unoColors, unoValues);
    }

    @Override
    public UnoColors createColors() {
        return factory.createColors(1);
    }

    @Override
    public UnoValues createValues() {
        return factory.createValues(1);
    }

    @Override
    public Rules buildRule() {
        return factory.buildRule(1);
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to the UNO game.");
        PlayersInGame(4);
        numberOfCardsInHandAtStart(7);
        rule.initializeTable(deck);
        while (true) {
            UnoPlayer unoPlayer = unoPlayers.get(rule.getCurrentPlayer());

            if (rule.isCanPlay(unoPlayers)) {

                System.out.println("\nIt's " + unoPlayer.getName() + " turn to play, and the cards he has are: ---------------------------- ");
                for (Card card : unoPlayer.getHand().getCards()) {
                    System.out.print(card.toString() + "  ");
                }

                System.out.println("\n\nthe cards valid to play :");
                for (Card card : rule.cardCanUsed(unoPlayer)) {
                    System.out.print(card.toString() + "  ");
                }

                System.out.println("\nPLEASE choose one from them: ");
                rule.playCard(unoPlayers);

                if (unoPlayer.getHand().isEmpty()) {
                    // This means that one of the players wins and the round ends Players' points are calculated and put into the winner's score
                    score.playerscore(unoPlayers, unoPlayer);
                    if (score.isGameOver(unoPlayer)) {
                        System.out.println("When the game is over\n" +
                                "Congratulations winner is "+ unoPlayer.getName());
                        System.exit(0);

                    }
                }
            }
            rule.nextPlayer(unoPlayers);
        }
    }
}




