package mate.rajnai.planningpoker.service;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;

import mate.rajnai.planningpoker.model.User;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class IssueServiceUnitTest {

    @Mock
    private IssueEstimationRepository issueEstimationRepository;

    @InjectMocks
    private IssueService issueService;

    private IssueEstimation issueEstimation1;
    private IssueEstimation issueEstimation2;

    @BeforeEach
    public void initData() {
        User user1 = User.builder()
                .name("User 1")
                .build();
        Issue issue1 = Issue.builder()
                .title("Issue 1")
                .description("description 1")
                .build();
        Issue issue2 = Issue.builder()
                .title("Issue 2")
                .description("description 2")
                .build();
        issueEstimation1 = new IssueEstimation(user1, issue1);
        issueEstimation2 = new IssueEstimation(user1, issue2);
    }

    @Test
    public void getIssuesOfUser() {
        Mockito.when(this.issueEstimationRepository.findIssueEstimationByUserId(1L))
                .thenReturn(new ArrayList<>(Arrays.asList(issueEstimation1, issueEstimation2)));
        assertThat(this.issueService.getIssueEstimationsOfUser("1")).isEqualTo(new ArrayList<>(Arrays.asList(issueEstimation1, issueEstimation2)));
    }

}