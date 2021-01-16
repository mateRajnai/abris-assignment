package mate.rajnai.planningpoker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "issue")
    private Set<IssueEstimation> estimations;

    private int averageEstimation;
}
