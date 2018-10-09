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
    @Override
    public int calculateTime(int payment) {
        
        if (payment < 150) {
            return (payment*2)/5;
        }
        
        if (350 > payment && payment >= 150) {
            return (int)(((float)(payment-150)*(0.3))+60);
        }
        
        //if the first two conditions fail, we're definitely over 350 payment
        return (payment-350)/5 + 120;
    }
}
