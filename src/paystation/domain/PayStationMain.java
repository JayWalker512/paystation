/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kingJ
 */
public class PayStationMain {

    static PayStationImpl ps;

    public static void main(String[] args) throws IllegalCoinException {
        ps = new PayStationImpl();
        int answer = 0;
        int coins = 0;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the PayStation");
        System.out.println("Please select a number:");
        while (answer != 1 && answer != 2 && answer != 3 && answer != 4 && answer != 5) {
            System.out.println("1. Deposit Coins\n2. Display\n3. Buy Ticket\n4. Cancel\n5. Change Rate Strategy");
            try {
                answer = Integer.parseInt(br.readLine());
                //vghfjfjtest
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Pleasw enter a number");
                //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (answer) {
                case 1:

                    System.out.println("Deposit Coins");
                    System.out.println("Please enter a increments of Five");
                     {
                        try {
                            coins = Integer.parseInt(br.readLine());
                        } catch (IOException | NumberFormatException ex) {
                            //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("please enter a number");
                        }
                    }

                    boolean goodpayment = incrementsOfFive(coins);
                    if (goodpayment == true) {
                        ps.addPayment(coins);
                       
                    } else {
                        System.out.println("Please enter a increments of Five");
                    }

                    break;
                case 2:
                    System.out.println("Display");
                    ps.readDisplay();
                    break;
                case 3:
                    System.out.println("Buy Ticket");
                    ps.buy();
                    break;
                case 4:
                    System.out.println("Cancel");
                    ps.cancel();
                    break;
                case 5:
                    System.out.println("Change Rate Strategy");
                    submenu();
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }

    }

    public static void submenu() {
        System.out.println("You have selected");
        System.out.println("Please select one of the Three rates\n1. Linear rate\n2. Progressive rate\n3. Alternation Rate");
        int answer = 0;
        while (answer != 1 && answer != 2 && answer != 3) {

            BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));

            try {
                answer = Integer.parseInt(br.readLine());
                //vghfjfjtest
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Pleasw enter a number");

                //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (answer) {
                case 1:
                    System.out.println("Linear rate");
                    ps.setRateStrategy(PayStationImpl.RateStrategies.Linear);

                    break;
                case 2:
                    System.out.println("Progressive rate");
                    ps.setRateStrategy(PayStationImpl.RateStrategies.Progressive);
                    break;
                case 3:
                    System.out.println("Alternation Rate");
                    ps.setRateStrategy(PayStationImpl.RateStrategies.Alternating);
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }

    }

    public static boolean incrementsOfFive(int coin) {
        return coin % 5 == 0;
    }// end incrementsOfFive
}
