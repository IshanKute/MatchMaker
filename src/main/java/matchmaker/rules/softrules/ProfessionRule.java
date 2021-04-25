package matchmaker.rules.softrules;

import matchmaker.models.User;

public class ProfessionRule implements SoftRule {
    int points = 6;
    @Override
    public int applyRule(User loggedInUser, User savedUser) {
        int score = 0;
        if (loggedInUser.getPartnerPreferences().getProfessions().contains(savedUser.getProfession()))
            score += points;
        if (savedUser.getPartnerPreferences().getProfessions().contains(loggedInUser.getProfession()))
            score +=points;
        return score;
    }
}
