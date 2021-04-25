package matchmaker;

import matchmaker.db.Repository;
import matchmaker.input.InputReader;
import matchmaker.input.PropertyReader;
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
import matchmaker.util.Console;
import matchmaker.util.Util;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        final List<HardRule> hardRules = Arrays.asList(new AgeRangeRule(), new GenderRule());
        final List<SoftRule> softRules = Arrays.asList(new ProfessionRule(), new HobbiesRule(), new DistrictRule());

        List<User> data = new Repository().getAllUsers();
        Console console = new Console();
        Util util = new Util(console);
        InputReader inputReader = new InputReader(console, util);
        PropertyReader propertyReader = new PropertyReader(inputReader, util, console);
        UserBuilder userBuilder = new UserBuilder(propertyReader);
        User user = userBuilder.build();

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
