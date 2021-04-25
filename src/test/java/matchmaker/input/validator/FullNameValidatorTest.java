package matchmaker.input.validator;

import matchmaker.exceptions.EmptyStringException;
import matchmaker.exceptions.NonAlphabeticCharacterException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FullNameValidatorTest {
    FullNameValidator fullNameValidator = new FullNameValidator();

    @Test
    void should_return_true_if_the_name_is_non_empty_and_pure_alphabetic() {
        assertDoesNotThrow(() -> assertTrue(fullNameValidator.validate("Kanha Yadav")));
    }

    @Test
    void should_return_EmptyStringException_if_the_name_is_empty() {
        EmptyStringException exception = assertThrows(EmptyStringException.class, () -> fullNameValidator.validate(""));
        assertEquals("Full-name cannot be empty", exception.getMessage());
    }

    @Test
    void should_return_NonAlphabeticCharacterException_if_the_name_contains_characters_other_than_alphabets_and_space() {
        NonAlphabeticCharacterException exception = assertThrows(NonAlphabeticCharacterException.class, () -> fullNameValidator.validate("Kanha123_&"));
        assertEquals("Full-name cannot contain non-alphabetic characters", exception.getMessage());
    }
}