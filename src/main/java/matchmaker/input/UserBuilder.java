package matchmaker.input;

import matchmaker.models.*;

import java.util.Arrays;
import java.util.Collections;

public class UserBuilder {
    ConsoleOperator consoleOperator;

    public UserBuilder(ConsoleOperator consoleOperator) {
        this.consoleOperator = consoleOperator;
    }

    public User build(User user) {
        user.setFullName(this.consoleOperator.getProperty("Full name", String.class, Collections.emptyList()));
        user.setAge(this.consoleOperator.getProperty("Age", Integer.class, Collections.emptyList()));
        user.setGender(this.consoleOperator.getProperty("Gender", Gender.class, Arrays.asList(Gender.values())));
        user.setProfession(this.consoleOperator.getProperty("Profession", Profession.class, Arrays.asList(Profession.values())));
        user.setDistrict(this.consoleOperator.getProperty("District", District.class, Arrays.asList(District.values())));
        user.setHobbies(this.consoleOperator.getListProperty("Hobbies", String.class, Collections.emptyList()));
        user.setPartnerPreferences(new PartnerPreferences(
                this.consoleOperator.getProperty("Partner's preferred gender", Gender.class, Arrays.asList(Gender.values())),
                this.consoleOperator.getListProperty("Partner's preferred professions", Profession.class, Arrays.asList(Profession.values())),
                new AgeRange(
                        this.consoleOperator.getProperty("Partner's preferred minimum age", Integer.class, Collections.emptyList()),
                        this.consoleOperator.getProperty("Partner's preferred maximum age", Integer.class, Collections.emptyList())
                )
        ));
        return user;
    }
}