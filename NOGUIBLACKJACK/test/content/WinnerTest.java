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
public class WinnerTest {

    public WinnerTest() {
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


    @Test
    public void testPlayerLose() {
        System.out.println("playerLose");
        ArrayList<Card> hand = new ArrayList();
        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("10");
        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("King");
        Card card3 = new Card();
        card3.setSuit("Spades");
        card3.setRank("Queen");
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        boolean result = Winner.playerBust(hand);
        boolean expResult = true;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkBlackJack method, of class Winner.
     */

    @Test
    public void testCheckBlackJack() {
        System.out.println("checkBlackJack");
        ArrayList<Card> hand = new ArrayList();
        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("10");
        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("Ace");
        Player playerOne = new Player("Spencer");
        playerOne.setBet(1000);
        hand.add(card1);
        hand.add(card2);
        double expResult = 1000;
        Winner.checkBlackJack(hand, playerOne);
        double result = playerOne.getBet();
        assertEquals(expResult, result, 10);
    }

    /**
     * Test of dealerBust method, of class Winner.
     */
    @Test
    public void testDealerBust() {
        System.out.println("dealerBust");
        ArrayList<Card> hand = new ArrayList();
        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("10");
        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("King");
        Card card3 = new Card();
        card3.setSuit("Spades");
        card3.setRank("Queen");
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        boolean result = Winner.playerBust(hand);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of getHandValue method, of class Winner.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        ArrayList<Card> hand = new ArrayList();
        Card card1 = new Card();
        card1.setSuit("Spades");
        card1.setRank("10");
        Card card2 = new Card();
        card2.setSuit("Spades");
        card2.setRank("Ace");
        hand.add(card1);
        hand.add(card2);
        int result = Winner.getHandValue(hand);
        int expResult = 21;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
