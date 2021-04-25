package matchmaker;

import matchmaker.models.*;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public List<User> getData() {
        return Arrays.asList(
                new User(
                        "Akshay Kumar",
                        29,
                        Gender.Male,
                        Profession.Farmer,
                        District.Yavatmal,
                        Arrays.asList("Singing", "Cricket"),
                        new PartnerPreferences(
                                Gender.Female,
                                Arrays.asList(Profession.Engineer, Profession.Teacher, Profession.CA),
                                new AgeRange(20, 35)
                        )
                ),
                new User(
                        "Rajkumar Rao",
                        31,
                        Gender.Male,
                        Profession.Teacher,
                        District.Nagpur,
                        Arrays.asList("Trekking", "Cricket"),
                        new PartnerPreferences(
                                Gender.Female,
                                Arrays.asList(Profession.Engineer, Profession.Teacher, Profession.CA),
                                new AgeRange(20, 35)
                        )
                ),
                new User(
                        "Deepika Kumar",
                        27,
                        Gender.Female,
                        Profession.CA,
                        District.Amravati,
                        Arrays.asList("Singing", "Cooking"),
                        new PartnerPreferences(
                                Gender.Male,
                                Arrays.asList(Profession.Engineer, Profession.Teacher, Profession.Doctor),
                                new AgeRange(20, 35)
                        )
                ),
                new User(
                        "Priyanka Shastri",
                        29,
                        Gender.Female,
                        Profession.Lawyer,
                        District.Buldhana,
                        Arrays.asList("Singing", "Painting"),
                        new PartnerPreferences(
                                Gender.Male,
                                Arrays.asList(Profession.Engineer, Profession.Doctor, Profession.BusinessPerson),
                                new AgeRange(20, 35)
                        )
                ),
                new User(
                        "Rani Sharma",
                        32,
                        Gender.Female,
                        Profession.Marketing,
                        District.Yavatmal,
                        Arrays.asList("Singing", "Cricket"),
                        new PartnerPreferences(
                                Gender.Male,
                                Arrays.asList(Profession.Engineer, Profession.Teacher),
                                new AgeRange(20, 35)
                        )
                )
        );
    }
}
