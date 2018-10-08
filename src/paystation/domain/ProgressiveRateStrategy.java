/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author reric
 */
public class ProgressiveRateStrategy implements RateStrategy {
    
    private int timeBoughtMinutes = 0; //60 is an hour
    
    @Override
    public int calculateTime(int payment) {
        
        if (timeBoughtMinutes <= 60 || payment <= 150) {
            timeBoughtMinutes = (payment*2)/5;
        }
        else if ((timeBoughtMinutes > 60 && timeBoughtMinutes <= 120) || (350 > payment && payment >= 150)) {
            timeBoughtMinutes = (payment-150)*(3/10)+60;
        }
        else if (timeBoughtMinutes > 120 || payment >=350) {
            timeBoughtMinutes = (payment-350)/5 + 120;
        }
        return timeBoughtMinutes;
    }
    
}
