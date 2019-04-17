/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Big Fish
 */
public class CardHand {

    private ArrayList<Card> cardHand = new ArrayList();

    public void setHand(ArrayList<Card> cardHand) {
        this.cardHand = cardHand;
    }

    //takes an arraylist of cards and adds one to it
    public void addCard(ArrayList<Card> cardHand, Card card) {
        cardHand.add(card);
        this.cardHand = cardHand;
    }

    public ArrayList<Card> getHand() {
        return cardHand;
    }

    public void displayHand(ArrayList<Card> hand) {
        Iterator<Card> itCard = hand.iterator();

        while (itCard.hasNext()) {
            Card ph = itCard.next();
            System.out.print(ph.getRank() +" of "+ ph.getSuit() + ", ");
        }
    }

    public void displayGamePartOne(ArrayList<Card> dealerHand, ArrayList<Card> playerHand, Player playerOne) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("The dealer has " + dealerHand.get(0).getRank() +" of "+ dealerHand.get(0).getSuit() + ", *******\n");

        System.out.print(playerOne.getName() + ", you have: ");
        displayHand(playerHand);
        System.out.print("(" + playerOne.getHandValue() + "). ");

        System.out.println("Current Bet $" + playerOne.getBet() + ", Total Money $" + playerOne.getMoney());
        System.out.println("-----------------------------------------------------------------------------");

    }

    public void displayGamePartTwo(ArrayList<Card> dealerHand, ArrayList<Card> playerHand, Player playerOne) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("The dealer has ");
        displayHand(dealerHand);
        System.out.print("("+Winner.getHandValue(dealerHand)+")\n");
        System.out.println(playerOne.getName() + ", you have: ");
        displayHand(playerHand);
        System.out.print("(" + playerOne.getHandValue() + "). ");

        System.out.println("Current Bet $" + playerOne.getBet() + ", Total Money $" + playerOne.getMoney());
        System.out.println("-----------------------------------------------------------------------------");

    }

}
