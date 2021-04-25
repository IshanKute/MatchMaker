package matchmaker.input;

import matchmaker.exceptions.CastException;
import matchmaker.util.Console;
import matchmaker.util.Util;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputReaderTest {
    Console mockConsole = mock(Console.class);
    Util mockUtil = mock(Util.class);
    InputReader inputReader = new InputReader(mockConsole, mockUtil);

    @Test
    void should_keep_asking_for_input_until_valid_input_is_received() {
        when(mockConsole.read()).thenReturn("Some name 123").thenReturn("Some name");
        assertDoesNotThrow(() -> when(mockUtil.cast("Some name 123", String.class)).thenReturn("Some name 123"));
        assertDoesNotThrow(() -> when(mockUtil.cast("Some name", String.class)).thenReturn("Some name"));
        String name = inputReader.getValidInput("Full name", String.class);
        assertEquals("Some name", name);
        verify(mockConsole).print("Full-name cannot contain non-alphabetic characters");
        verify(mockConsole).print("Please enter again: ");
    }
}