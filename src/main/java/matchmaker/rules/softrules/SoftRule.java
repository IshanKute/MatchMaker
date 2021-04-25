package matchmaker.rules.softrules;


import matchmaker.models.User;

public interface SoftRule {
    int applyRule(User loggedInUser, User savedUser);
}
