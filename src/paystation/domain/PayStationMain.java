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
     
    public static void main(String[] args) {
        int answer=0;
        
        BufferedReader br = 
                 new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Welcome to the PayStation");
        System.out.println("Please select a number:");
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
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                break;
            case 5:
                System.out.println("");
                break;
            default:
                System.out.println("GoodBye");
                break;
        }
        
    }
    
}
