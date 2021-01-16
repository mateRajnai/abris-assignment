package mate.rajnai.planningpoker.model;

import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class IssueEstimation {

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
