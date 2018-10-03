package paystation.domain;

import java.util.Calendar;

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
        if (isWeekend()) {
            ProgressiveRateStrategy progressiveRateStrategy = new ProgressiveRateStrategy();
            return progressiveRateStrategy.calculateTime(payment);
        }
        LinearRateStrategy linearRateStrategy = new LinearRateStrategy();
        return linearRateStrategy.calculateTime(payment);
    }

    /**
     * Determine if the current day is during the weekends.
     *
     * @return whether today is during the weekends
     */
    private boolean isWeekend() {
        Calendar today = Calendar.getInstance();
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                return true;
            default:
                return false;
        }
    }
}
