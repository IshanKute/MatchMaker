package matchmaker.rules.softrules;

import matchmaker.TestData;
import matchmaker.models.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DistrictRuleTest {
    DistrictRule districtRule = new DistrictRule();
    List<User> testData = new TestData().getData();

    @Test
    void should_return_correct_points_if_both_users_districts_are_adjacent_to_each_other() {
        int points = districtRule.applyRule(testData.get(0), testData.get(2));
        assertEquals(12, points);
    }

    @Test
    void should_return_correct_points_if_both_users_districts_are_same() {
        int points = districtRule.applyRule(testData.get(0), testData.get(4));
        assertEquals(12, points);
    }

    @Test
    void should_return_0_if_neither_the_districts_are_same_nor_the_districts_are_adjacent() {
        int points = districtRule.applyRule(testData.get(0), testData.get(3));
        assertEquals(0, points);
    }
}