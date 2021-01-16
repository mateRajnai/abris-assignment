package mate.rajnai.planningpoker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Getter
    @ManyToOne
    @MapsId("userId")
    private User user;

    @Getter
    @ManyToOne
    @MapsId("issueId")
    private Issue issue;

    @Setter
    @Getter
    private int estimation;
}
