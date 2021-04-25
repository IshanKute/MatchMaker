package matchmaker.rules.hardrules;

import matchmaker.models.User;

public interface HardRule {
    boolean applyRule(User loggedInUser, User savedUser);
}
