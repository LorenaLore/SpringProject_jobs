package ro.lorenaApps.partTimeJob.utils;

import ro.lorenaApps.partTimeJob.model.Rating;
import ro.lorenaApps.partTimeJob.model.User;

import java.text.DecimalFormat;
import java.util.List;

public class RatingScoreCalculator {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public Double getRatingScore(User user) {
        return getRatingScore(user.getRatings());
    }

    public Double getRatingScore(List<Rating> ratingList) {
        if (ratingList == null || ratingList.isEmpty()) {
            return 0.0;
        }
        Double sum = 0.0;
        int totalRatings = 0;
        for (Rating rating : ratingList) {
            sum += rating.getScore();
            totalRatings++;
        }
        String result = DECIMAL_FORMAT.format(sum / totalRatings);
        return Double.valueOf(result);
    }

    public static void main(String[] args) {
        Double sum = 0.0;
        int totalRatings = 0;
        Integer[] a = {3, 5, 2};
        for (Integer i : a) {
            sum += i;
            totalRatings++;
        }
        System.out.println(DECIMAL_FORMAT.format(sum / totalRatings));
    }
}
