package matchmaker.models;

import java.util.List;

public class PartnerPreferences {
    private Gender gender;
    private List<Profession> professions;
    private AgeRange ageRange;

    public PartnerPreferences(Gender gender, List<Profession> professions, AgeRange ageRange) {
        this.gender = gender;
        this.professions = professions;
        this.ageRange = ageRange;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }
}
