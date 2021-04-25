package matchmaker.rules.hardrules;

import matchmaker.TestData;
import matchmaker.models.User;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AgeRangeRuleTest {

    AgeRangeRule ageRangeRule = new AgeRangeRule();
    List<User> testData = new TestData().getData();

    @Test
    void should_return_true_if_both_users_age_are_in_each_others_preferred_age_range() {
        boolean result = ageRangeRule.applyRule(testData.get(0), testData.get(2));
        assertTrue(result);
    }

    @Test
    void should_return_false_if_one_of_the_users_age_is_not_in_others_preferred_age_range() {
        User firstUser = testData.get(0);
        User secondUser = testData.get(1);
        secondUser.setAge(36);
        boolean result = ageRangeRule.applyRule(firstUser, secondUser);
        assertFalse(result);
    }
}