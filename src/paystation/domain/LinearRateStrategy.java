/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;

/**
 *
 * @author jaywalker
 */
public class LinearRateStrategy implements RateStrategy {
    /**
     * Calculate parking time based on payment.
     *
     * @param payment total values of coins inserted
     * @return equivalent parking time
     */
    public int calculateTime(int payment) {
        return payment / 5 * 2;
    }
}
