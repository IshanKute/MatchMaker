package matchmaker.input;

import matchmaker.models.*;

import java.util.Arrays;
import java.util.Collections;

public class UserBuilder {
    PropertyReader propertyReader;

    public UserBuilder(PropertyReader propertyReader) {
        this.propertyReader = propertyReader;
    }

    public User build() {
        User user = new User();
        user.setFullName(this.propertyReader.getProperty("Full name", String.class, Collections.emptyList()));
        user.setAge(this.propertyReader.getProperty("Age", Integer.class, Collections.emptyList()));
        user.setGender(this.propertyReader.getProperty("Gender", Gender.class, Arrays.asList(Gender.values())));
        user.setProfession(this.propertyReader.getProperty("Profession", Profession.class, Arrays.asList(Profession.values())));
        user.setDistrict(this.propertyReader.getProperty("District", District.class, Arrays.asList(District.values())));
        user.setHobbies(this.propertyReader.getListProperty("Hobbies", String.class, Collections.emptyList()));
        user.setPartnerPreferences(new PartnerPreferences(
                this.propertyReader.getProperty("Partner's preferred gender", Gender.class, Arrays.asList(Gender.values())),
                this.propertyReader.getListProperty("Partner's preferred professions", Profession.class, Arrays.asList(Profession.values())),
                new AgeRange(
                        this.propertyReader.getProperty("Partner's preferred minimum age", Integer.class, Collections.emptyList()),
                        this.propertyReader.getProperty("Partner's preferred maximum age", Integer.class, Collections.emptyList())
                )
        ));
        return user;
    }
}