package mate.rajnai.planningpoker.service;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import mate.rajnai.planningpoker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class IssueService {

    private final IssueEstimationRepository issueEstimations;
    private final IssueRepository issueRepository;


    public List<IssueEstimation> getIssuesOfUser(String userId) {
        return this.issueEstimations.findIssueEstimationByUserId(Long.valueOf(userId));
    }

    public void estimateIssue(String userId, String issueId, String estimation) {
        IssueEstimation issueEstimation = this.issueEstimations.findIssueEstimationByUserIdAndIssueId(Long.valueOf(userId), Long.valueOf(issueId)).orElseThrow(NullPointerException::new);
        int newEstimation = Integer.parseInt(estimation);
        issueEstimation.setEstimation(newEstimation);
        this.issueEstimations.save(issueEstimation);

        Issue issue = issueEstimation.getIssue();
        Set<IssueEstimation> issueEstimations = issue.getEstimations();
        issue.setAverageEstimation(this.getAverageOfFibonacciEstimations(issueEstimations));
        this.issueRepository.save(issue);
    }

    private int getAverageOfFibonacciEstimations(Set<IssueEstimation> issueEstimations) {
        int[] possibleEstimations = new int[]{1, 2, 3, 5, 8, 13};
        int sumOfEstimations = issueEstimations
                .stream()
                .map(IssueEstimation::getEstimation)
                .mapToInt(Integer::intValue)
                .sum();
        int numberOfEstimations = Math.toIntExact(issueEstimations.stream().filter(issueEstimation -> issueEstimation.getEstimation() != 0).count());
        int normalAverage = sumOfEstimations / numberOfEstimations;
        for (int i = 0; i < possibleEstimations.length - 1; i++) {
            if (possibleEstimations[i] == normalAverage) return possibleEstimations[i];
            if (possibleEstimations[i+1] == normalAverage) return possibleEstimations[i+1];
            if (possibleEstimations[i] < normalAverage && normalAverage < possibleEstimations[i+1])
                return possibleEstimations[i] - normalAverage >= possibleEstimations[i + 1] - normalAverage
                        ? possibleEstimations[i + 1]
                        : possibleEstimations[i];
        }
        return 0;
    }

    public List<Issue> getAllIssues() {
        return this.issueRepository.findAll();
    }
}
