package matchmaker.db;

import matchmaker.TestData;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RepositoryTest {

    Repository repository = new Repository();
    @Test
    void should_read_all_users_from_file() {
        List<User> users = assertDoesNotThrow(() -> repository.getAllUsers());
        String[] userFullNames = users.stream().map(User::getFullName).toArray(String[]::new);
        String[] expectedUserFullNamesArray = new String[] {"Akshay Kumar", "Rajkumar Rao", "Deepika Kumar", "Priyanka Shastri", "Rani Sharma"};
        assertArrayEquals(expectedUserFullNamesArray, userFullNames);
    }
}