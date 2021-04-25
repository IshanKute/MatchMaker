package matchmaker.input;

import matchmaker.models.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserBuilderTest {
    PropertyReader mockPropertyReader = mock(PropertyReader.class);
    UserBuilder userBuilder = new UserBuilder(mockPropertyReader);

    @Test
    void should_build_and_return_user() {
        User expectedUser = new User(
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
        );
        when(mockPropertyReader.getProperty("Full name", String.class, Collections.emptyList())).thenReturn("Deepika Kumar");
        when(mockPropertyReader.getProperty("Age", Integer.class, Collections.emptyList())).thenReturn(27);
        when(mockPropertyReader.getProperty("Gender", Gender.class, Arrays.asList(Gender.values()))).thenReturn(Gender.Female);
        when(mockPropertyReader.getProperty("Profession", Profession.class, Arrays.asList(Profession.values()))).thenReturn(Profession.CA);
        when(mockPropertyReader.getProperty("District", District.class, Arrays.asList(District.values()))).thenReturn(District.Amravati);
        when(mockPropertyReader.getListProperty("Hobbies", String.class, Collections.emptyList())).thenReturn(Arrays.asList("Singing", "Cooking"));
        when(mockPropertyReader.getProperty("Partner's preferred gender", Gender.class, Arrays.asList(Gender.values()))).thenReturn(Gender.Male);
        when(mockPropertyReader.getListProperty("Partner's preferred professions", Profession.class, Arrays.asList(Profession.values()))).thenReturn(Arrays.asList(Profession.Engineer, Profession.Teacher, Profession.Doctor));
        when(mockPropertyReader.getProperty("Partner's preferred minimum age", Integer.class, Collections.emptyList())).thenReturn(20);
        when(mockPropertyReader.getProperty("Partner's preferred maximum age", Integer.class, Collections.emptyList())).thenReturn(35);
        User user = userBuilder.build();
        assertEquals(expectedUser.toString(), user.toString());
    }
}