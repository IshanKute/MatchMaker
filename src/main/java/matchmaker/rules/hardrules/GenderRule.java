package matchmaker.rules.hardrules;

import matchmaker.models.User;

public class GenderRule implements HardRule{
    @Override
    public boolean applyRule(User loggedInUser, User savedUser) {
        return loggedInUser.getPartnerPreferences().getGender() == savedUser.getGender() &&
                savedUser.getPartnerPreferences().getGender() == loggedInUser.getGender();
    }
}
