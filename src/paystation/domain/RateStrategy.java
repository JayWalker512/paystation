package paystation.domain;

/**
 * Rate strategy for a Parking Pay Station to calculate parking time based on payment.
 *
 * Responsibilities:
 *
 * 1) Calculate parking time based on payment.
 */
public interface RateStrategy {

    /**
     * Calculate parking time based on payment.
     *
     * @param payment total values of coins inserted
     * @return equivalent parking time
     */
    int calculateTime(int payment);
}
