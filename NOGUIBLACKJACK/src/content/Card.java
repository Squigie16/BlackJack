package content;

import java.util.ArrayList;
import java.util.Collections;

public class Card {

    private String[] suitChoices = {"Spades", "Clubs", "Diamonds", "Hearts"};
    private String[] rankChoices = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String suit;
    private String rank;

//    public Card (String suit,String rank){
//        
//    }
//    
    public ArrayList<Card> setDeck() {
        ArrayList<Card> deck = new ArrayList();

        int count = 0;
        for (int i = 0; i < suitChoices.length; i++) {
            for (int k = 0; k < rankChoices.length; k++) {
                Card card = new Card();
                card.setSuit(suitChoices[i]);
                card.setRank(rankChoices[k]);
                deck.add(card);
                //count++;
                //System.out.println(card.getSuit()+card.getRank()+" "+count);
            }
        }

        return deck;

    }

    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck) {

        Collections.shuffle(deck);
        return deck;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return this.rank;
    }
}
