package matchmaker.input.validator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DefaultValidatorTest {
    DefaultValidator defaultValidator = new DefaultValidator();

    @Test
    void should_return_true() {
        assertTrue(defaultValidator.validate(""));
    }
}