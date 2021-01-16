package mate.rajnai.planningpoker;

import lombok.RequiredArgsConstructor;
import mate.rajnai.planningpoker.repository.IssueRepository;
import mate.rajnai.planningpoker.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository users;
    private final IssueRepository issues;

    @PostConstruct
    private void initData() {

    }
}
