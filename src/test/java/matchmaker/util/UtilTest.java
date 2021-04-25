package matchmaker.util;

import matchmaker.TestData;
import matchmaker.exceptions.CastException;
import matchmaker.models.*;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UtilTest {
    Console mockConsole = mock(Console.class);
    Util util = new Util(mockConsole);
    InOrder orderVerifier = inOrder(mockConsole);

    @Test
    void cast_should_return_input_as_it_is_when_type_is_string() {
        assertDoesNotThrow(() -> assertEquals("Some name", util.cast("Some name", String.class)));
    }

    @Test
    void cast_should_return_integer_when_type_is_integer() {
        assertDoesNotThrow(() -> assertEquals(153, util.cast("153", Integer.class)));
    }

    @Test
    void cast_should_return_Gender_enum_when_type_is_Gender() {
        assertDoesNotThrow(() -> assertEquals(Gender.Female, util.cast("Female", Gender.class)));
    }

    @Test
    void cast_should_return_Profession_enum_when_type_is_Profession() {
        assertDoesNotThrow(() -> assertEquals(Profession.CA, util.cast("CA", Profession.class)));
    }

    @Test
    void cast_should_return_District_enum_when_type_is_District() {
        assertDoesNotThrow(() -> assertEquals(District.Akola, util.cast("Akola", District.class)));
    }

    @Test
    void cast_should_return_input_as_it_is_for_any_other_type() {
        assertDoesNotThrow(() -> assertEquals("Some name", util.cast("Some name", Exception.class)));
    }

    @Test
    void cast_should_throw_CastException_when_integer_cannot_be_parsed() {
        CastException exception = assertThrows(CastException.class, () -> util.cast("12ui", Integer.class));
        assertEquals("Cannot cast 12ui to type Integer", exception.getMessage());
    }

    @Test
    void cast_should_throw_CastException_when_incorrect_gender_value_is_provided() {
        CastException exception = assertThrows(CastException.class, () -> util.cast("Mal", Gender.class));
        String expectedMessage = "Cannot cast Mal to type Gender" + "\nPlease select from given options only";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void cast_should_throw_CastException_when_incorrect_district_value_is_provided() {
        CastException exception = assertThrows(CastException.class, () -> util.cast("yavatmal", District.class));
        String expectedMessage = "Cannot cast yavatmal to type District" + "\nPlease select from given options only";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void cast_should_throw_CastException_when_incorrect_profession_value_is_provided() {
        CastException exception = assertThrows(CastException.class, () -> util.cast("engine", Profession.class));
        String expectedMessage = "Cannot cast engine to type Profession" + "\nPlease select from given options only";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void should_print_correct_enter_property_message_when_options_are_present() {
        util.printEnterPropertyMessage("Gender", Arrays.asList(Gender.values()));
        orderVerifier.verify(mockConsole).print("Select your Gender from the following list");
        orderVerifier.verify(mockConsole).print("[Male, Female, Transgender]");
        verify(mockConsole, never()).print("Enter Gender:");
    }

    @Test
    void should_print_correct_enter_property_message_when_options_are_null() {
        util.printEnterPropertyMessage("Gender", null);
        verify(mockConsole).print("Enter Gender:");
        verify(mockConsole, never()).print("Select your Gender from the following list");
        verify(mockConsole, never()).print("[Male, Female, Transgender]");
    }

    @Test
    void should_print_result_when_there_is_at_least_one_matching_profile() {
        List<User> testData = new TestData().getData();
        User firstMatch = testData.get(0);
        User secondMatch = testData.get(1);
        List<Score> result = Arrays.asList(new Score(firstMatch, 25), new Score(secondMatch, 20));
        util.printResult(result);
        orderVerifier.verify(mockConsole).print("-------------------------------------------------------------------------------------------");
        orderVerifier.verify(mockConsole).print("Matched users are:");
        orderVerifier.verify(mockConsole).print(firstMatch.getFullName() + ": 25");
        orderVerifier.verify(mockConsole).print(firstMatch.toBasicString());
        orderVerifier.verify(mockConsole).print("\n");
        orderVerifier.verify(mockConsole).print(secondMatch.getFullName() + ": 20");
        orderVerifier.verify(mockConsole).print(secondMatch.toBasicString());
        orderVerifier.verify(mockConsole).print("\n");
    }

    @Test
    void should_print_no_matching_messsage_when_there_are_no_matches() {
        List<Score> result = Collections.emptyList();
        util.printResult(result);
        verify(mockConsole).print("There are no matching profiles");
        verify(mockConsole, never()).print("-------------------------------------------------------------------------------------------");
        verify(mockConsole, never()).print("Matched users are:");
    }
}