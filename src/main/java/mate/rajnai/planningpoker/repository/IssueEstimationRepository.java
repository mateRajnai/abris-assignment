package mate.rajnai.planningpoker.repository;

import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.model.IssueEstimationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueEstimationRepository extends JpaRepository<IssueEstimation, IssueEstimationKey> {

    List<IssueEstimation> findIssueEstimationByUserId(Long userId);


}
