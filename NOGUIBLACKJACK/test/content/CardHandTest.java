/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Big Fish
 */
public class CardHandTest {

    public CardHandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setHand method, of class CardHand.
     */
//    @Test
//    public void testSetHand() {
//        System.out.println("setHand");
//        ArrayList<Card> cardHand = null;
//        CardHand instance = new CardHand();
//        instance.setHand(cardHand);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of addCard method, of class CardHand.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        CardHand playerCardHand = new CardHand();
        Card currentGame = new Card();
        ArrayList<Card> deck = currentGame.setDeck();
        currentGame.shuffleDeck(deck);
        ArrayList<Card> cardHand = new ArrayList();
        playerCardHand.addCard(playerCardHand.getHand(), deck.get(0));
        int expResult = 0;
        int result = cardHand.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class CardHand.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        ArrayList<Card> hand = new ArrayList();
        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("10");
        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("Ace");
        Player playerOne = new Player("Spencer");
        hand.add(card1);
        hand.add(card2);
        int expResult = 2;
        int result = hand.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }




}
