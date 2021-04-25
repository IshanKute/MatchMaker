package matchmaker.models;

import java.util.List;

public class PartnerPreferences {
    private final Gender gender;
    private final List<Profession> professions;
    private final AgeRange ageRange;

    public PartnerPreferences(Gender gender, List<Profession> professions, AgeRange ageRange) {
        this.gender = gender;
        this.professions = professions;
        this.ageRange = ageRange;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    @Override
    public String toString() {
        return "PartnerPreferences{" +
                "gender=" + gender +
                ", professions=" + professions +
                ", ageRange=" + ageRange.toString() +
                '}';
    }
}
