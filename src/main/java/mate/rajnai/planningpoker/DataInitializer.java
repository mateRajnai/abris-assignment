package mate.rajnai.planningpoker;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.model.Issue;
import mate.rajnai.planningpoker.model.IssueEstimation;
import mate.rajnai.planningpoker.model.User;
import mate.rajnai.planningpoker.repository.IssueEstimationRepository;
import mate.rajnai.planningpoker.repository.IssueRepository;
import mate.rajnai.planningpoker.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository users;
    private final IssueRepository issues;
    private final IssueEstimationRepository issueEstimations;

    @PostConstruct
    private void initData() {
        User user1 = User.builder()
                .name("Mate")
                .build();
        User user2 = User.builder()
                .name("Daniel")
                .build();
        User user3 = User.builder()
                .name("Tamas")
                .build();
        this.users.save(user1);
        this.users.save(user2);
        this.users.save(user3);

        Issue issue1 = Issue.builder()
                .title("Issue 1")
                .description("description 1")
                .build();
        Issue issue2 = Issue.builder()
                .title("Issue 2")
                .description("description 2")
                .build();
        Issue issue3 = Issue.builder()
                .title("Issue 3")
                .description("description 3")
                .build();
        Issue issue4 = Issue.builder()
                .title("Issue 4")
                .description("description 4")
                .build();
        this.issues.save(issue1);
        this.issues.save(issue2);
        this.issues.save(issue3);
        this.issues.save(issue4);

        IssueEstimation issueEstimation1 = new IssueEstimation(user1, issue1);
        IssueEstimation issueEstimation2 = new IssueEstimation(user1, issue2);
        IssueEstimation issueEstimation3 = new IssueEstimation(user1, issue3);
        IssueEstimation issueEstimation4 = new IssueEstimation(user1, issue4);
        IssueEstimation issueEstimation5 = new IssueEstimation(user2, issue1);
        IssueEstimation issueEstimation6 = new IssueEstimation(user2, issue2);
        IssueEstimation issueEstimation7 = new IssueEstimation(user2, issue3);
        IssueEstimation issueEstimation8 = new IssueEstimation(user2, issue4);
        IssueEstimation issueEstimation9 = new IssueEstimation(user3, issue1);
        IssueEstimation issueEstimation10 = new IssueEstimation(user3, issue2);
        IssueEstimation issueEstimation11 = new IssueEstimation(user3, issue3);
        IssueEstimation issueEstimation12 = new IssueEstimation(user3, issue4);


        this.issueEstimations.save(issueEstimation1);
        this.issueEstimations.save(issueEstimation2);
        this.issueEstimations.save(issueEstimation3);
        this.issueEstimations.save(issueEstimation4);
        this.issueEstimations.save(issueEstimation5);
        this.issueEstimations.save(issueEstimation6);
        this.issueEstimations.save(issueEstimation7);
        this.issueEstimations.save(issueEstimation8);
        this.issueEstimations.save(issueEstimation9);
        this.issueEstimations.save(issueEstimation10);
        this.issueEstimations.save(issueEstimation11);
        this.issueEstimations.save(issueEstimation12);
    }
}
