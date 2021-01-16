package mate.rajnai.planningpoker.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class IssueEstimation {

    @EmbeddedId
    private IssueEstimationKey issueEstimationKey;

    private User user;
    private Issue issue;
    private int estimation;
}
