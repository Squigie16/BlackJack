/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noguiblackjack;

import content.Card;
import content.CardHand;
import content.Player;
import content.Winner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Big Fish
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        boolean game = true;
        int numHands = 0;

        //creating the player object and starting the game
        System.out.println("Hello and Welcome to BlackJack! We're going to start you off with $10,000!");
        System.out.println("Please type your name:");
        Player playerOne = new Player(input.next());

        while (game) {

            int dealtCards = 0;
            //creating an ArrayList of cards and adding them to a deck.

            //then the deck is shuffled to make sure each game is different.
            Card currentGame = new Card();
            ArrayList<Card> deck = currentGame.setDeck();
            currentGame.shuffleDeck(deck);

            //setting up the bet for the hand + validation
            System.out.println(playerOne.getName() + ", how much do you want to bet? $1-$"
                    + playerOne.getMoney() + " or type '0' if you are done playing.");

            //making sure the user enters a number as a bet
            try {
                playerOne.setBet(input.nextDouble());
                if (playerOne.getBet() == 0) {
                    game = false;
                    break;
                }
            } catch (InputMismatchException e) {

            }
            //making sure the user can afford the bet they entered
            while (!playerOne.affordBet(playerOne.getBet(), playerOne.getMoney())) {
                System.out.println(playerOne.getName() + ", you have $"
                        + playerOne.getMoney() + ", please type a bet that you can afford.");

                playerOne.setBet(input.nextDouble());
            }

            //dealing the initial cards. 
            //One to the player, dealer, then player, then dealer.
            CardHand playerCardHand = new CardHand();
            CardHand dealerCardHand = new CardHand();

            playerCardHand.addCard(playerCardHand.getHand(), deck.get(dealtCards));
            dealtCards++;
            dealerCardHand.addCard(dealerCardHand.getHand(), deck.get(dealtCards));
            dealtCards++;
            playerCardHand.addCard(playerCardHand.getHand(), deck.get(dealtCards));
            dealtCards++;
            dealerCardHand.addCard(dealerCardHand.getHand(), deck.get(dealtCards));
            dealtCards++;

            //displays assigns a value to the players hand.
            //it also displays the game 
            playerOne.setHandValue(Winner.getHandValue(playerCardHand.getHand()));
            playerCardHand.displayGamePartOne(dealerCardHand.getHand(), playerCardHand.getHand(), playerOne);

            //checks if the player was dealt a blackjack
            if (Winner.checkBlackJack(playerCardHand.getHand(), playerOne)) {
                Winner.checkBlackJack(playerCardHand.getHand(), playerOne);

            }
            while (!Winner.playerBust(playerCardHand.getHand()) && playerOne.getHandValue() != 21) {

                System.out.println("Would you like another card?");
                System.out.println("Type 'hit' to get another card or 'stay' to stay");
                if (input.next().equalsIgnoreCase("hit")) {

                    playerCardHand.addCard(playerCardHand.getHand(), deck.get(dealtCards));
                    playerOne.setHandValue(Winner.getHandValue(playerCardHand.getHand()));
                    dealtCards++;
                    //displays the current hand with one card face down for the dealer
                    playerCardHand.displayGamePartOne(dealerCardHand.getHand(), playerCardHand.getHand(), playerOne);

                } else {
                    break;
                }
                //checks to see if the player has busted
                if (Winner.playerBust(playerCardHand.getHand())) {
                    Winner.playerBust(playerOne);
                    break;
                }

            }

            //displays the dealers hand
            dealerCardHand.displayGamePartTwo(dealerCardHand.getHand(), playerCardHand.getHand(), playerOne);

            //draws more cards for the dealer if his hand is worth less than 16
            boolean deal = true;
            if((playerOne.getHandValue() > 21))
                deal = false;
            while (Winner.getHandValue(dealerCardHand.getHand()) < 17 &&deal) {
                dealerCardHand.addCard(dealerCardHand.getHand(), deck.get(dealtCards));
                dealtCards++;
                dealerCardHand.displayGamePartTwo(dealerCardHand.getHand(), playerCardHand.getHand(), playerOne);

            }

            //if neither the dealer or player busted this determines who has a higher hand value
            if (playerOne.getHandValue() > 21) {
                Winner.playerLose(playerOne);
            } else if (Winner.getHandValue(dealerCardHand.getHand()) > 21){
                Winner.playerWin(playerOne);
            } else if (Winner.getHandValue(dealerCardHand.getHand()) > playerOne.getHandValue() && !Winner.dealerBust(dealerCardHand.getHand())) {
                Winner.playerLose(playerOne);
            } else if (Winner.getHandValue(dealerCardHand.getHand()) < playerOne.getHandValue() && !Winner.playerBust(playerCardHand.getHand())) {
                Winner.playerWin(playerOne);
            } else if (Winner.getHandValue(dealerCardHand.getHand()) == playerOne.getHandValue()) {
                System.out.println("Tie - Nothing lost, nothing gained.\n");
            } else {

            }
            numHands++;

        }//game

        System.out.println("Thank you for playing " + playerOne.getName());
        if (playerOne.getMoney() > 10000) {
            System.out.println("You made $" + (playerOne.getMoney() - 10000) + " over " + numHands + " hands.");
        } else {
            System.out.println("You lost $" + (10000 - playerOne.getMoney()) + " over " + numHands + " hands.");
        }

    }//main

}//class
