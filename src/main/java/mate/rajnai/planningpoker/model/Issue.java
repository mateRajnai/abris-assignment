package mate.rajnai.planningpoker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
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
