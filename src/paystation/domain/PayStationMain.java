/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kingJ
 */
public class PayStationMain {

    static PayStationImpl ps;
    static Receipt receipt;
    public static void main(String[] args) throws IllegalCoinException {
        ps = new PayStationImpl();
        int answer = 0;
        int coins = 0;
        int readDisplay;
        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to the PayStation");
        System.out.println("Please select a number:");
        while (answer != 4 && answer !=3) {
            System.out.println("1. Deposit Coins\n2. Display\n3. Buy Ticket\n4. Cancel\n5. Change Rate Strategy");
            try {
                answer = Integer.parseInt(br.readLine());
            
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Pleasw enter a number");
                
                //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
            }//end try catch
            switch (answer) {
                case 1:

                    System.out.println("Deposit Coins");
                    System.out.println("Please enter a 5, 10 or 25");
                     
                        try {
                            coins = Integer.parseInt(br.readLine());
                        } catch (IOException | NumberFormatException ex) {
                            //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("please enter a number");
                        }// end try catch
                    

                    boolean goodpayment = incrementsOfFive(coins);
                    if (goodpayment == true) {
                        ps.addPayment(coins);
                           
                       
                    } else {
                        System.out.println("Please enter a 5, 10 or 25");
                    }//end if else

                    break;
                case 2:
                     
                     readDisplay=ps.readDisplay();
                     System.out.println("Time so far \n"+ readDisplay+" minutes");
                    break;
                case 3:
                    System.out.println("Buy Ticket");
                    receipt=ps.buy();
                    System.out.println("Receipt " + receipt.value()+" minutes");
                    break;
                case 4:
                    System.out.println("Cancel");
                    Map<Integer,Integer> returnmoney = ps.cancel();
                        System.out.println("Changes"+"\t\t"+"Amount");
                    for ( int key :returnmoney.keySet())
                       {
                           System.out.println(key+"¢" +"\t\t"+returnmoney.get(key));
                       }
                       System.out.println("Goodbye");
                    break;
                case 5:
                    System.out.println("Change Rate Strategy");
                    submenu();
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }// end switch
        }//end while

    }//main

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
                System.out.println("Please enter a number");

                //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
            }//end try catch
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
            }//end switch
        }//end while

    }//end submenu

    public static boolean incrementsOfFive(int coin) {
        if(coin ==5){
            return true;
        }
        if(coin ==10){
            return true;
        }
        //coin % 5 == 0;
        return coin ==25 ;
    }// end incrementsOfFive
}// end PayStationMenuClass
