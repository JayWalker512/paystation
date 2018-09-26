package paystation.domain;
import java.util.*;

/**
 * Implementation of the pay station.
 *
 * Responsibilities:
 *
 * 1) Accept payment; 
 * 2) Calculate parking time based on payment; 
 * 3) Know earning, parking time bought; 
 * 4) Issue receipts; 
 * 5) Handle buy and cancel events.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
public class PayStationImpl implements PayStation {
    
    private int insertedSoFar;
    private int timeBought;
    private int total;
    private int nickelCounter = 0;
    private int dimeCounter = 0;
    private int qrtrCounter = 0;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    @Override
    public void addPayment(int coinValue)
            throws IllegalCoinException {
        switch (coinValue) {
            case 5: break;
            case 10: break;
            case 25: break;
            default:
                throw new IllegalCoinException("Invalid coin: " + coinValue);
        }
        
        if(coinValue == 5) {
            nickelCounter++;
            map.put(5, nickelCounter);
        }
        else if(coinValue == 10) {
            dimeCounter++;
            map.put(10, dimeCounter);
        }
        else if(coinValue == 25) {
            qrtrCounter++;
            map.put(25, qrtrCounter);
        }
        
        insertedSoFar += coinValue;        
        timeBought = insertedSoFar / 5 * 2;
    }

    @Override
    public int readDisplay() {
        return timeBought;
    }

    @Override
    public Receipt buy() {
        Receipt r = new ReceiptImpl(timeBought);
        total = insertedSoFar;
        reset();
        map.put(5, 0);
        map.put(10, 0);
        map.put(25, 0);
        return r;
    }

    @Override
    public HashMap<Integer, Integer> cancel() {
        HashMap<Integer, Integer> temp = map;
        reset();
        return temp;
    }
    
    private void reset() {
        nickelCounter = 0;
        dimeCounter = 0;
        qrtrCounter = 0;
        timeBought = insertedSoFar = 0;
    }
    
    public int empty() {
        int temp = total;
        total = 0;
        return temp;
    }
}
