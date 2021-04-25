package matchmaker;

import matchmaker.models.Score;
import matchmaker.models.User;
import matchmaker.rules.hardrules.*;
import matchmaker.rules.softrules.*;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        final List<HardRule> hardRules = Arrays.asList(new AgeRangeRule(), new GenderRule());
        final List<SoftRule> softRules = Arrays.asList(new ProfessionRule(), new HobbiesRule(), new DistrictRule());

        List<User> data = Database.getData();

        User user = data.get(0);

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

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("Matched users are:");
        result.forEach(
                r -> {
                    System.out.println(r.getUser().getFullName() + ": " + r.getScore());
                    System.out.println(r.getUser().toString());
                    System.out.println("\n");
                }
        );
    }
}
