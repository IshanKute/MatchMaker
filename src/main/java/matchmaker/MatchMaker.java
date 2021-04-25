package matchmaker;

import matchmaker.input.UserBuilder;
import matchmaker.models.Score;
import matchmaker.models.User;
import matchmaker.rules.hardrules.AgeRangeRule;
import matchmaker.rules.hardrules.GenderRule;
import matchmaker.rules.hardrules.HardRule;
import matchmaker.rules.softrules.DistrictRule;
import matchmaker.rules.softrules.HobbiesRule;
import matchmaker.rules.softrules.ProfessionRule;
import matchmaker.rules.softrules.SoftRule;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchMaker {
    private final UserBuilder userBuilder;
    private final List<User> data;
    private final List<HardRule> hardRules = Arrays.asList(new AgeRangeRule(), new GenderRule());
    private final List<SoftRule> softRules = Arrays.asList(new ProfessionRule(), new HobbiesRule(), new DistrictRule());

    public MatchMaker(UserBuilder userBuilder, List<User> data) {
        this.userBuilder = userBuilder;
        this.data = data;
    }

    public User getUser() {
        return userBuilder.build();
    }

    public List<User> getHardRulesFilteredUsers(User loggedInUser) {
        return data.stream().filter(
                savedUser -> hardRules.stream()
                        .map(rule -> rule.applyRule(loggedInUser, savedUser))
                        .collect(Collectors.toList()).stream()
                        .reduce(true, (acc, ruleResult) -> acc && ruleResult)
        ).collect(Collectors.toList());
    }

    public List<Score> getMatchingUsers(List<User> hardRulesFilteredUsers, User loggedInUser) {
        return hardRulesFilteredUsers.stream()
                .map(savedUser -> new Score(savedUser, softRules.stream().map(softRule -> softRule.applyRule(loggedInUser, savedUser)).mapToInt(Integer::intValue).sum()))
                .filter(score -> score.getScore() > 15)
                .sorted(Comparator.comparingInt(Score::getScore).reversed()).collect(Collectors.toList());
    }
}
