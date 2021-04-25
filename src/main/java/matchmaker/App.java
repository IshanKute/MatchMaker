package matchmaker;

import matchmaker.input.ConsoleInput;
import matchmaker.input.ConsoleOperator;
import matchmaker.input.UserBuilder;
import matchmaker.models.Score;
import matchmaker.models.User;
import matchmaker.rules.hardrules.*;
import matchmaker.rules.softrules.*;
import matchmaker.util.Util;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        final List<HardRule> hardRules = Arrays.asList(new AgeRangeRule(), new GenderRule());
        final List<SoftRule> softRules = Arrays.asList(new ProfessionRule(), new HobbiesRule(), new DistrictRule());

        List<User> data = Database.getData();

        Util util = new Util();
        ConsoleInput consoleInput = new ConsoleInput(util);
        ConsoleOperator consoleOperator = new ConsoleOperator(consoleInput, util);
        UserBuilder userBuilder = new UserBuilder(consoleOperator);
        User user = userBuilder.build(new User());

        List<User> hardRulesFilteredUsers = data.stream().filter(
                savedUser -> hardRules.stream()
                        .map(rule -> rule.applyRule(user, savedUser))
                        .collect(Collectors.toList()).stream()
                        .reduce(true, (acc, ruleResult) -> acc && ruleResult)
        ).collect(Collectors.toList());

        List<Score> result = hardRulesFilteredUsers.stream()
                .map(savedUser -> new Score(savedUser, softRules.stream().map(softRule -> softRule.applyRule(user, savedUser)).mapToInt(Integer::intValue).sum()))
                .filter(score -> score.getScore() > 15)
                .sorted(Comparator.comparingInt(Score::getScore).reversed()).collect(Collectors.toList());

        util.printResult(result);
    }
}
