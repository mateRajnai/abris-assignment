package mate.rajnai.planningpoker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class IssueEstimationKey {

    private Long userId;
    private Long issueId;

}
