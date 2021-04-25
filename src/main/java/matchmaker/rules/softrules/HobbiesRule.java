package matchmaker.rules.softrules;

import matchmaker.models.User;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HobbiesRule implements SoftRule{
    int points = 4;
    @Override
    public int applyRule(User loggedInUser, User savedUser) {
        int matchedHobbiesCount = Stream.concat(loggedInUser.getHobbies().stream(), savedUser.getHobbies().stream())
                .collect(Collectors.toList()).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 2).collect(Collectors.toList())
                .size();
        return matchedHobbiesCount * points;
    }
}

//{"Singing", "Gaming", "Reading", "Singing", "Reading"}
