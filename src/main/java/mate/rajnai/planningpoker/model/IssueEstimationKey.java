package mate.rajnai.planningpoker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class IssueEstimationKey implements Serializable {

    private Long userId;
    private Long issueId;

}
