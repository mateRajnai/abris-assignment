package mate.rajnai.planningpoker.service;

import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.model.User;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import mate.rajnai.planningpoker.repository.IssueRepository;
import mate.rajnai.planningpoker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class IssueServiceIntegrationTest {

    @Autowired
    private IssueEstimationRepository issueEstimationRepository;

    @Autowired
    private UserRepository users;

    @Autowired
    private IssueRepository issues;

    private IssueService issueService;

    private Issue issue1;
    private Issue issue2;

    @BeforeEach
    public void initData() {
        issueService = new IssueService(issueEstimationRepository);
        User user1 = User.builder()
                .name("User 1")
                .build();
        issue1 = Issue.builder()
                .title("Issue 1")
                .description("description 1")
                .build();
        issue2 = Issue.builder()
                .title("Issue 2")
                .description("description 2")
                .build();
        IssueEstimation issueEstimation1 = new IssueEstimation(user1, issue1);
        IssueEstimation issueEstimation2 = new IssueEstimation(user1, issue2);
        this.users.save(user1);
        this.issues.save(issue1);
        this.issues.save(issue2);
        this.issueEstimationRepository.save(issueEstimation1);
        this.issueEstimationRepository.save(issueEstimation2);
    }

    @Test
    public void getIssuesOfUser() {
        System.out.println(this.issueService.getIssuesOfUser("1"));
        assertThat(this.issueService.getIssuesOfUser("1")).isEqualTo(new ArrayList<>(Arrays.asList(issue1, issue2)));
    }

}