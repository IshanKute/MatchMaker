package matchmaker;

import matchmaker.input.UserBuilder;
import matchmaker.models.Score;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchMakerTest {

    UserBuilder mockUserBuilder = mock(UserBuilder.class);
    List<User> testData = new TestData().getData();

    MatchMaker matchMaker = new MatchMaker(mockUserBuilder, testData);

    @Test
    void should_get_user() {
        when(mockUserBuilder.build()).thenReturn(testData.get(0));
        assertEquals(matchMaker.getUser().toString(), testData.get(0).toString());
    }

    @Test
    void should_get_data_filtered_by_Hard_Rules() {
        List<User> hardRulesFilteredUsers = matchMaker.getHardRulesFilteredUsers(testData.get(0));
        String[] actualArray = hardRulesFilteredUsers.stream().map(User::getFullName).toArray(String[]::new);
        String[] expectedArray = new String[] {"Deepika Kumar", "Priyanka Shastri", "Rani Sharma"};
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    void should_get_matching_users() {
        List<Score> result = matchMaker.getMatchingUsers(testData.subList(2, 4), testData.get(0));
        String[] actualNameArray = result.stream().map(score -> score.getUser().getFullName()).toArray(String[]::new);
        String[] expectedNameArray = new String[] {"Deepika Kumar"};
        Integer[] actualScoreArray = result.stream().map(Score::getScore).toArray(Integer[]::new);
        Integer[] expectedScoreArray = new Integer[] {22};
        assertArrayEquals(expectedNameArray, actualNameArray);
        assertArrayEquals(expectedScoreArray, actualScoreArray);
    }
}