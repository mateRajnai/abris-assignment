package mate.rajnai.planningpoker.service;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IssueService {

    private final IssueEstimationRepository issueEstimations;


    public List<IssueEstimation> getIssuesOfUser(String userId) {
        return this.issueEstimations.findIssueEstimationByUserId(Long.valueOf(userId));
    }

    public void estimateIssue(String userId, String issueId, String estimation) {
        IssueEstimation issueEstimation = this.issueEstimations.findIssueEstimationByUserIdAndIssueId(Long.valueOf(userId), Long.valueOf(issueId)).orElseThrow(NullPointerException::new);
        issueEstimation.setEstimation(Integer.parseInt(estimation));
        this.issueEstimations.save(issueEstimation);
    }
}
