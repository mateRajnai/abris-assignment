package mate.rajnai.planningpoker.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.MERGE)
    private Set<IssueEstimation> estimations = new HashSet<>();

    @Setter
    private int averageEstimation;
}
