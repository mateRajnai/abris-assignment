package mate.rajnai.planningpoker.model;

import java.util.Set;

public class Issue {

    private Long id;
    private String title;
    private String description;
    private Set<IssueEstimation> estimations;
    private int averageEstimation;
}
