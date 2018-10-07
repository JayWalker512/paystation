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
                System.out.println("Deposit Coins");
                break;
            case 2:
                System.out.println("Display");
                break;
            case 3:
                System.out.println("Buy Ticket");
                break;
            case 4:
                System.out.println("Cancel");
                break;
            case 5:
                System.out.println("Change Rate Strategy");
                submenu();
                break;
            default:
                System.out.println("GoodBye");
                break;
        }
        
    }
    
public static void submenu(){
    System.out.println("You have selected");
    System.out.println("Please select one of the Three rates\n1. Linear rate\n 2. Progressive rate\n 3. Alternation Rate");
    int answer=0;
        
        BufferedReader br = 
                 new BufferedReader(new InputStreamReader(System.in)); 
    try {
            answer = Integer.parseInt(br.readLine());
            //vghfjfjtest
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Pleasw enter a number");
            //Logger.getLogger(PayStationMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    switch(answer)
    {      case 1:
                System.out.println("Linear rate");
                break;
            case 2:
                System.out.println("Progressive rate");
                break;
            case 3:
                System.out.println("Alternation Rate");
                break;
            default:
                System.out.println("GoodBye");
                break;
    }


}


}
