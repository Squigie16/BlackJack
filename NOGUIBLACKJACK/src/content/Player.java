/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package content;

/**
 *
 * @author Big Fish
 */
public class Player {

    private String name;
    private double money = 10000;
    private double bet;
    private int handValue;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public double getBet() {
        return this.bet;
    }

    public boolean affordBet(double bet, double money) {
        if (bet > money) {
            return false;
        }
        return true;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public int getHandValue() {
        return this.handValue;
    }

}
