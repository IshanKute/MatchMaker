package matchmaker.rules.hardrules;

import matchmaker.models.User;

public class AgeRangeRule implements HardRule {

    @Override
    public boolean applyRule(User loggedInUser, User savedUser) {
        return loggedInUser.getPartnerPreferences().getAgeRange().checkRange(savedUser.getAge()) &&
                savedUser.getPartnerPreferences().getAgeRange().checkRange(loggedInUser.getAge());
    }
}
