package mate.rajnai.planningpoker.repository;

import mate.rajnai.planningpoker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
