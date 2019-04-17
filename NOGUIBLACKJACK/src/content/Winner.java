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
public class Winner {
    
    public static boolean playerBust(ArrayList<Card> hand) {
        if (getHandValue(hand) > 21) {
            return true;
        }
        return false;
    }
    
    public static void playerBust(Player playerOne) {
        
        playerOne.setMoney(playerOne.getMoney() - playerOne.getBet());
        System.out.println("\nYou have Busted!\n");
        System.out.println("You lost $" + playerOne.getBet());
        System.out.println("Your updated money is $" + playerOne.getMoney());
        System.out.println("-----------------------------------------------------------------------------");
    }
    
    public static void playerWin(Player playerOne) {
        
        playerOne.setMoney(playerOne.getMoney() + playerOne.getBet());
        System.out.println("\nYou have Won!\n");
        System.out.println("You Won $" + playerOne.getBet());
        System.out.println("Your updated money is $" + playerOne.getMoney());
        System.out.println("-----------------------------------------------------------------------------");
    }
    
    public static void playerLose(Player playerOne) {
        playerOne.setMoney(playerOne.getMoney() - playerOne.getBet());
        System.out.println("\nYou have Lost!\n");
        System.out.println("You lost $" + playerOne.getBet());
        System.out.println("Your updated money is $" + playerOne.getMoney());
        System.out.println("-----------------------------------------------------------------------------");
    }

    public static boolean checkBlackJack(ArrayList<Card> hand, Player playerOne) {
        
        if (hand.size() == 2 && playerOne.getHandValue() == 21) {
            System.out.println("\nBLACKJACK!!!\n");
            playerOne.setBet(playerOne.getBet() * 1.5);
            System.out.println("You Won $" + playerOne.getBet());
            System.out.println("Your updated money is $" + playerOne.getMoney());
            System.out.println("-----------------------------------------------------------------------------");
            return true;
        }
        return false;
    }
    
    public static boolean dealerBust(ArrayList<Card> hand) {
        if (getHandValue(hand) > 21) {
            return true;
        } else {
            return false;
        }
    }
    
    public static int getHandValue(ArrayList<Card> hand) {
        int total = 0;
        
        Iterator<Card> itCard = hand.iterator();
        
        while (itCard.hasNext()) {
            Card ph = itCard.next();
            if (ph.getRank() == "Ace") {
                if (total > 21) {
                    total += 1;
                } else {
                    total += 11;
                }
            } else if (ph.getRank() == "2") {
                total += 2;
            } else if (ph.getRank() == "3") {
                total += 3;
            } else if (ph.getRank() == "4") {
                total += 4;
            } else if (ph.getRank() == "5") {
                total += 5;
            } else if (ph.getRank() == "6") {
                total += 6;
            } else if (ph.getRank() == "7") {
                total += 7;
            } else if (ph.getRank() == "8") {
                total += 8;
            } else if (ph.getRank() == "9") {
                total += 9;
            } else if (ph.getRank() == "10") {
                total += 10;
            } else {
                total += 10;
            }
        }
        return total;
    }
    
}
