import java.util.ArrayList;

class UnoHand {
    private ArrayList<Card> cards;
    private boolean unoFlag;


    public UnoHand() {
        this.cards = new ArrayList<>();
        unoFlag = false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCardToHand(Card card) {
        cards.add(card);
    }
    public boolean isEmpty(){
        return cards.size()==0;
    }

    public void removeCardFromHand(Card card) {
        cards.remove(card);
    }

    public void setUnoFlag() {
        this.unoFlag = true;
    }

    public boolean isUnoFlag() {
        return unoFlag;
    }

    public boolean isPenalty() {
        boolean penalty=false;
        if (cards.size()==1&unoFlag==false){

            System.out.println("the player forget say UNO");
            penalty=true;
        }else
            System.out.println("the player say UNO");

        return penalty;
    }

}