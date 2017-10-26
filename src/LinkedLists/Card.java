package LinkedLists;

/**
 * Created by 131111 on 10/19/2017.
 */
public class Card {
    private char value;
    private char suit;

    public Card(String card){
        value = card.charAt(0);
        suit = card.charAt(1);
    }

    boolean match(Object o){
        if(o == null){
            return false;
        }
        Card card = (Card)o;
        return value == card.getValue() || suit == card.getSuit();
    }

    char getValue(){
        return value;
    }

    char getSuit(){
        return suit;
    }

    @Override
    public String toString() {
        return ""+value+suit;
    }
}
