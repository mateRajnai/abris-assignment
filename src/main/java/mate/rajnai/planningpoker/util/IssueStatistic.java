package mate.rajnai.planningpoker.util;

import mate.rajnai.planningpoker.model.IssueEstimation;

import java.util.Set;

public class IssueStatistic {

    private static final int[] POSSIBLE_ESTIMATIONS = new int[]{1, 2, 3, 5, 8, 13};

    public static int getAverageOfFibonacciEstimations(Set<IssueEstimation> issueEstimations) {
        int sumOfEstimations = issueEstimations
                .stream()
                .map(IssueEstimation::getEstimation)
                .mapToInt(Integer::intValue)
                .sum();
        int numberOfEstimations = Math.toIntExact(issueEstimations.stream().filter(issueEstimation -> issueEstimation.getEstimation() != 0).count());
        int normalAverage = sumOfEstimations / numberOfEstimations;
        for (int i = 0; i < POSSIBLE_ESTIMATIONS.length - 1; i++) {
            if (POSSIBLE_ESTIMATIONS[i] == normalAverage) return POSSIBLE_ESTIMATIONS[i];
            if (POSSIBLE_ESTIMATIONS[i+1] == normalAverage) return POSSIBLE_ESTIMATIONS[i+1];
            if (POSSIBLE_ESTIMATIONS[i] < normalAverage && normalAverage < POSSIBLE_ESTIMATIONS[i+1])
                return POSSIBLE_ESTIMATIONS[i] - normalAverage >= POSSIBLE_ESTIMATIONS[i + 1] - normalAverage
                        ? POSSIBLE_ESTIMATIONS[i + 1]
                        : POSSIBLE_ESTIMATIONS[i];
        }
        return 0;
    }
}
