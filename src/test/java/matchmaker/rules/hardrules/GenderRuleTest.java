package matchmaker.rules.hardrules;

import matchmaker.TestData;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GenderRuleTest {
    GenderRule genderRule = new GenderRule();
    List<User> testData = new TestData().getData();

    @Test
    void should_return_true_if_both_users_gender_matches_with_each_others_preferred_gender() {
        boolean result = genderRule.applyRule(testData.get(0), testData.get(2));
        assertTrue(result);
    }

    @Test
    void should_return_false_if_any_users_gender_does_not_matches_with_others_preferred_gender() {
        boolean result = genderRule.applyRule(testData.get(0), testData.get(1));
        assertFalse(result);
    }
}