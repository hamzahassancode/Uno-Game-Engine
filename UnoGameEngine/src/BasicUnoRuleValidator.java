import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BasicUnoRuleValidator implements Rules {
    protected ArrayList<Card> stockPile;
    protected boolean gameDirection;
    protected String validColor;
    protected HashMap<String, Integer> validValue;
    protected int currentPlayer;
    private Deck deck;

    Scanner input = new Scanner(System.in);


    public BasicUnoRuleValidator() {
        stockPile = new ArrayList<>();

        currentPlayer = 0;
        gameDirection = false;
    }


    //#1
    @Override
    public  void initializeTable(Deck deck) {
        this.deck=deck;
        Card card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        //Repeat if the card is wild or Draw two
        if (validColor.equals(UnoColors.getUnoColor(4) ) || validValue.equals(UnoValues.getUnoValue(10)) ) {
            stockPile.add(card);
            initializeTable(deck);
        } else {
            stockPile.add(card);
            System.out.println("the game is start and the card in the table is :\n" + card);
        }
    }
    @Override
    public void playCard(ArrayList<UnoPlayer> unoPlayers) {
        String cardChosen;
        Card playCard;
        ArrayList<Card> cardCanUsed;
        boolean validInput = false;
        UnoPlayer cuPlayer=unoPlayers.get(currentPlayer);
        //stay in loop until the player play valid card
        while (!validInput) {
            cardChosen = input.nextLine();
            playCard = convertStringToCard(cardChosen);
            cardCanUsed = cardCanUsed(cuPlayer);
            //check if the card he played is from the card can be used
            for (Card card : cardCanUsed) {
                if (card.toString().equals(cardChosen)) {
                    validValue = card.getValue();
                    validColor = card.getColor();
                    //if the card is wild must the plyer choose color
                    isWildCard(card);
                    //remove the card from player hand
                    cuPlayer.playCard(card);
                    stockPile.add(playCard);
                    System.out.println("The card on the table is: \n" + card);
                    validInput = true;
                    // Break out of the loop if input is valid
                    break;
                }
                //If the last card reaches without finding the card, this means that the player chose a card that cannot be played
                if (card == cardCanUsed.get(cardCanUsed.size() - 1)) {
                    System.out.println(cuPlayer.getName() + " CAN NOT play this card.Try again, Choose one you can play!");
                }
            }
        }
    }
    public void setGameDirection(boolean gameDirection) {
        this.gameDirection = gameDirection;
    }


    @Override
    public void nextPlayer(ArrayList<UnoPlayer> unoPlayers) {

        if (!gameDirection) {
            currentPlayer = (currentPlayer + 1) % unoPlayers.size();
        } else {
            currentPlayer = (currentPlayer - 1) % unoPlayers.size();
            if (currentPlayer == -1) {
                currentPlayer = unoPlayers.size() - 1;
            }
        }
        setCurrentPlayer(currentPlayer);
    }

    public void ifDeckIsEmptyRefill(ArrayList<Card> stockPile) {
        if (deck.isEmpty()) {
            deck.refillDeck(stockPile);
        }
    }
    @Override
    public boolean isCanPlay( ArrayList<UnoPlayer> unoPlayers) {
        UnoPlayer cuPlayer=unoPlayers.get(currentPlayer);

        if (validValue == UnoValues.getUnoValue(11))//skip
        {
            System.out.println(cuPlayer.getName()+ " was skipped");
            //covert the skip value card to nothing to make the next player play
            validValue = UnoValues.getUnoValue(15);
            return false;

        } else if (validValue == UnoValues.getUnoValue(12)) { //reverse
            System.out.println("The game direction changed");
            // XOR bitwise operator
            gameDirection ^= true;
            setGameDirection(gameDirection);
            nextPlayer(unoPlayers);
            //covert the reverse value card to nothing to make the next player play
            validValue = UnoValues.getUnoValue(15);
            return false;

        } else if (validValue == UnoValues.getUnoValue(10)) {//drawTwo
            System.out.println(cuPlayer.getName() + "  draw two cards and skipped ");
            ifDeckIsEmptyRefill(stockPile);
            deck.drawCard(cuPlayer, 2);
            //covert the draw two value card to nothing to make the next player play
            validValue = UnoValues.getUnoValue(15);

            return false;

        } else if (validValue == UnoValues.getUnoValue(14)) {//wildFour
            System.out.println(cuPlayer.getName() + "  draw four cards and skipped ");
          ifDeckIsEmptyRefill(stockPile);
            deck.drawCard(cuPlayer, 4);
            validValue = UnoValues.getUnoValue(15);
            return false;

        } else {// the pile card

            ArrayList<Card> cardsCanUse = cardCanUsed(cuPlayer);
            if (cardsCanUse.size() == 0) {
               ifDeckIsEmptyRefill(stockPile);
                deck.drawCard(cuPlayer, 1);
                System.out.println("\n" + cuPlayer.getName() + "  draw one cards because he couldn't play");
                cardsCanUse = cardCanUsed(cuPlayer);
                if (cardsCanUse.size() != 0) {
                    System.out.println("\n" + cuPlayer.getName() + "  and he can play");
                    return true;
                } else {
                    System.out.println( ", and he still couldn't play");
                    return false;
                }
            } else {
                return true;
            }
        }

    }

    public ArrayList<Card> cardCanUsed(UnoPlayer unoPlayer) {

        ArrayList<Card> playerHand = unoPlayer.getHand().getCards();
        ArrayList<Card> cardsCanUse = new ArrayList<>();
        for (Card card : playerHand) {
            if (card.getColor().equals(validColor)  || card.getValue() == validValue || card.getColor().equals(UnoColors.getUnoColor(4)) ) {
                cardsCanUse.add(card);
            }
        }
        return cardsCanUse;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public Card convertStringToCard(String input) {
        // Splitting the string at the underscore character
        String[] parts = input.split("_");

        // Extracting the first string
        String color = parts[0];

        // Extracting the second string and removing the curly braces
        String key = parts[1].replaceAll("\\{(.*)=.*}", "$1");

        // Extracting the integer value
        int scorevalue = Integer.parseInt(parts[1].replaceAll(".*=(\\d+)}", "$1"));

        HashMap<String, Integer> value = new HashMap<String, Integer>();
        value.put(key, scorevalue);

        return new Card(color, value);
    }

    public void isWildCard(Card card) {

        if (card.getColor().equals(UnoColors.getUnoColor(4)) ) {
            System.out.println("must choose color : " + UnoColors.getUnoColor(0) + "  " + UnoColors.getUnoColor(1) + "  " + UnoColors.getUnoColor(2) + "  " + UnoColors.getUnoColor(3));
            String color=input.nextLine();
            validColor = color;
        }
    }
    public void isSayUno(UnoPlayer unoPlayer) {
        unoPlayer.getHand().isPenalty();
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    @Override
    public String toString() {
        return "BasicUnoRuleValidator{" +
                ", validColor='" + validColor + '\'' +
                ", input=" + input +
                ", currentPlayer=" + currentPlayer +
                ", gameDirection=" + gameDirection +
                '}';
    }
}
