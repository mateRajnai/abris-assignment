package mate.rajnai.planningpoker.service;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IssueService {

    private final IssueEstimationRepository issueEstimations;


    public List<Issue> getIssuesOfUser(String userId) {
        List<IssueEstimation> issueEstimations = this.issueEstimations.findIssueEstimationByUserId(Long.valueOf(userId));
        return issueEstimations
                .stream()
                .map(IssueEstimation::getIssue)
                .collect(Collectors.toList());
    }

    public void estimateIssue(String userId, String issueId, String estimation) {
        IssueEstimation issueEstimation = this.issueEstimations.findIssueEstimationByUserIdAndIssueId(Long.valueOf(userId), Long.valueOf(issueId)).orElseThrow(NullPointerException::new);
        issueEstimation.setEstimation(Integer.parseInt(estimation));
        this.issueEstimations.save(issueEstimation);
    }
}
