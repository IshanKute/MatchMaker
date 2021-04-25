package matchmaker.rules.softrules;


import matchmaker.models.User;

public class DistrictRule implements SoftRule{
    int points = 12;
    @Override
    public int applyRule(User loggedInUser, User savedUser) {
        if (loggedInUser.getDistrict().getNearbyDistricts().contains(savedUser.getDistrict()))
            return points;
        else return 0;
    }
}
