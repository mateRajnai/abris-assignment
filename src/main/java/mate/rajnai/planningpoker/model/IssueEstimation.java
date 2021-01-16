package mate.rajnai.planningpoker.model;

import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@NoArgsConstructor
public class IssueEstimation {

    public IssueEstimation(User user, Issue issue) {
        this.user = user;
        this.issue = issue;
        this.id =  new IssueEstimationKey(user.getId(), issue.getId());
    }

    @EmbeddedId
    private IssueEstimationKey id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("issueId")
    private Issue issue;

    private int estimation;
}
