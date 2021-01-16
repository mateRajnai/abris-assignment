package mate.rajnai.planningpoker.model;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private Set<Issue> issues = new HashSet<>();
    private Set<IssueEstimation> estimations = new HashSet<>();
}
