package matchmaker.models;

import java.util.List;

public class User {
    private String fullName;
    private int age;
    private Gender gender;
    private Profession profession;
    private District district;
    private List<String> hobbies;
    private PartnerPreferences partnerPreferences;

    public User(){}

    public User(String fullName, int age, Gender gender, Profession profession, District district, List<String> hobbies, PartnerPreferences partnerPreferences) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.profession = profession;
        this.district = district;
        this.hobbies = hobbies;
        this.partnerPreferences = partnerPreferences;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public PartnerPreferences getPartnerPreferences() {
        return partnerPreferences;
    }

    public void setPartnerPreferences(PartnerPreferences partnerPreferences) {
        this.partnerPreferences = partnerPreferences;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", profession=" + profession +
                ", district=" + district +
                ", hobbies=" + hobbies +
                '}';
    }
}
