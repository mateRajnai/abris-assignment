package mate.rajnai.planningpoker.service;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import mate.rajnai.planningpoker.repository.IssueRepository;
import mate.rajnai.planningpoker.util.IssueStatistic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class IssueService {

    private final IssueEstimationRepository issueEstimations;
    private final IssueRepository issueRepository;


    public List<IssueEstimation> getIssueEstimationsOfUser(String userId) {
        return this.issueEstimations.findIssueEstimationByUserId(Long.valueOf(userId));
    }

    public void estimateIssue(String userId, String issueId, String estimation) {
        IssueEstimation issueEstimation = this.issueEstimations.findIssueEstimationByUserIdAndIssueId(Long.valueOf(userId), Long.valueOf(issueId)).orElseThrow(NullPointerException::new);
        issueEstimation.setEstimation(Integer.parseInt(estimation));
        Issue issue = issueEstimation.getIssue();
        Set<IssueEstimation> issueEstimations = issue.getEstimations();
        issue.setAverageEstimation(IssueStatistic.getAverageOfFibonacciEstimations(issueEstimations));
        this.issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return this.issueRepository.findAll();
    }
}
