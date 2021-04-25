package matchmaker.input.validator;

import matchmaker.exceptions.NonPositiveAgeException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AgeValidatorTest {
    AgeValidator ageValidator = new AgeValidator();

    @Test
    void should_return_true_when_age_is_non_zero_positive_integer() {
        assertDoesNotThrow( () -> assertTrue(ageValidator.validate(12)));
    }

    @Test
    void should_throw_NonPositiveAgeException_when_age_is_zero_or_negative() {
        NonPositiveAgeException exception = assertThrows(NonPositiveAgeException.class, () -> ageValidator.validate(0));
        assertEquals("Age cannot be zero or negative", exception.getMessage());
    }
}