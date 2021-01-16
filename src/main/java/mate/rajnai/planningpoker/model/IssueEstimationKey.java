package mate.rajnai.planningpoker.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class IssueEstimationKey implements Serializable {

    private Long userId;
    private Long issueId;

}
