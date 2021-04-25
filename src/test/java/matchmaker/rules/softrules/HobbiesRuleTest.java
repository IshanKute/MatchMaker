package matchmaker.rules.softrules;

import matchmaker.TestData;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class HobbiesRuleTest {
    List<User> testData = new TestData().getData();
    HobbiesRule hobbiesRule = new HobbiesRule();
    User firstUser = testData.get(1);
    User secondUser = testData.get(2);

    @Test
    void should_return_correct_points_when_few_hobbies_are_matching() {
        firstUser.setHobbies(Arrays.asList("Singing", "Reading", "Cricket"));
        secondUser.setHobbies(Arrays.asList("Singing", "Reading", "Cooking"));
        int points = hobbiesRule.applyRule(firstUser, secondUser);
        assertEquals(8, points);
    }

    @Test
    void should_return_zero_points_when_no_hobbies_are_matching() {
        firstUser.setHobbies(Arrays.asList("Singing", "Reading", "Cricket"));
        secondUser.setHobbies(Arrays.asList("Dancing", "Cooking"));
        int points = hobbiesRule.applyRule(firstUser, secondUser);
        assertEquals(0, points);
    }
}