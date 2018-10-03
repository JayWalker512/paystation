package paystation.domain;

/**
 * Implementation of the Alternating Rate Strategy.
 *
 * Responsibilities:
 *
 * 1) Calculate parking time based on payment. On weekdays, uses Linear Rate Strategy. On weekends,
 *    uses Progressive Rate Strategy.
 */
public class AlternatingRateStrategy implements RateStrategy {

    @Override
    public int calculateTime(int payment) {
        return 0;
    }
}
