package matchmaker.rules.softrules;

import matchmaker.TestData;
import matchmaker.models.Profession;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProfessionRuleTest {
    ProfessionRule professionRule = new ProfessionRule();
    List<User> testData = new TestData().getData();

    @Test
    void should_return_correct_points_when_profession_is_in_other_users_preferred_profession() {
        int points = professionRule.applyRule(testData.get(1), testData.get(2));
        assertEquals(12, points);
    }

    @Test
    void should_return_0_when_profession_is_not_in_other_users_preferred_profession() {
        int points = professionRule.applyRule(testData.get(0), testData.get(4));
        assertEquals(0, points);
    }
}