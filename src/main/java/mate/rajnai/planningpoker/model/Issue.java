package mate.rajnai.planningpoker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private Set<IssueEstimation> estimations;

    private int averageEstimation;
}
