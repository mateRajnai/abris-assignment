package mate.rajnai.planningpoker.repository;

import mate.rajnai.planningpoker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository users;

    private User user;

    @BeforeEach
    public void init() {
        user = User.builder()
                .name("Test user")
                .build();
        this.users.save(user);
    }

    @Test
    public void findUserById() {
        User foundUser = this.users.findById(1L).orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("Test user");
    }

    @Test
    public void notFindUserById() {
        User foundUser = this.users.findById(2L).orElse(null);
        assertThat(foundUser).isNull();
    }


}