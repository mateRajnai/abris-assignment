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
}
