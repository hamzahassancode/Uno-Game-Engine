class UnoPlayer implements Player{
    private final String name;
    private UnoHand unoHand;
    private int score;

    public UnoPlayer(String name) {
        this.name = name;
        this.unoHand = new UnoHand();
        score = 0;
    }

    public String getName() {
        return name;
    }

    public UnoHand getHand() {
        return unoHand;
    }

    // Calculating the points remaining cards in the player's hand
    public int getPoints(){
        int points=0;
        if (!unoHand.isEmpty()){
            for (Card card : unoHand.getCards()){
                points=points+ card.getValuePenalty();
            }
        }
        return points;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void playerDrawCard(Card card) {
        if (card !=null){
        unoHand.addCardToHand(card);
    } else {
        throw new IllegalArgumentException("Cannot draw a card.");
    }
    }

    public void playCard(Card card) {
        if (card !=null){
            unoHand.removeCardFromHand(card);
        } else {
            throw new IllegalArgumentException("Cannot play a card.");
        }
    }


}