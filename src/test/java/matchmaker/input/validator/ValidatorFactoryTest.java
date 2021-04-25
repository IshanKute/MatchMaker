package matchmaker.input.validator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ValidatorFactoryTest {
    ValidatorFactory factory = new ValidatorFactory();

    @Test
    void should_return_FullNameValidator_when_type_is_either_Full_name_or_Hobbies() {
        Validator fullNameValidator = factory.getValidator("Full name");
        Validator hobbiesValidator = factory.getValidator("Hobbies");
        assertTrue(fullNameValidator instanceof FullNameValidator);
        assertTrue(hobbiesValidator instanceof FullNameValidator);
    }

    @Test
    void should_return_AgeValidator_when_type_is_age() {
        Validator ageValidator1 = factory.getValidator("Age");
        Validator ageValidator2 = factory.getValidator("Partner's preferred minimum age");
        Validator ageValidator3 = factory.getValidator("Partner's preferred maximum age");

        assertAll(
                () -> assertTrue(ageValidator1 instanceof AgeValidator),
                () -> assertTrue(ageValidator2 instanceof AgeValidator),
                () -> assertTrue(ageValidator3 instanceof AgeValidator)
        );
    }

    @Test
    void should_return_DefaultValidator_when_type_does_not_match_any_case() {
        Validator defaultValidator = factory.getValidator("Gender");
        assertTrue(defaultValidator instanceof DefaultValidator);
    }
}