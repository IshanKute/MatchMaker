package matchmaker.input;

import matchmaker.models.Profession;
import matchmaker.util.Console;
import matchmaker.util.Util;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PropertyReaderTest {
    InputReader mockInputReader = mock(InputReader.class);
    Util mockUtil = mock(Util.class);
    Console mockConsole = mock(Console.class);

    PropertyReader propertyReader = new PropertyReader(mockInputReader, mockUtil, mockConsole);



    @Test
    void should_keep_asking_input_until_d_is_pressed_for_list_property() {
        when(mockInputReader.getValidInput("Profession", Profession.class)).thenReturn(Profession.Doctor).thenReturn(Profession.Farmer);
        when(mockConsole.read()).thenReturn("a").thenReturn("d");
        List<Profession> professions = propertyReader.getListProperty("Profession", Profession.class, Arrays.asList(Profession.values()));
        assertArrayEquals(new Profession[]{Profession.Doctor, Profession.Farmer}, professions.toArray());
        List<Profession> professionList = Arrays.asList(Profession.values());
        List<Profession> modifiedProfessionList = Arrays.stream(Profession.values()).filter(profession -> profession!=Profession.Doctor).collect(Collectors.toList());
        InOrder orderVerifier = inOrder(mockUtil, mockConsole);
        orderVerifier.verify(mockUtil).printEnterPropertyMessage("Profession", professionList);
        orderVerifier.verify(mockConsole).print("Profession: [Doctor]");
        orderVerifier.verify(mockConsole).print("Press any key to continue adding more Profession or press 'D' if you are done");
        orderVerifier.verify(mockUtil).printEnterPropertyMessage("Profession", modifiedProfessionList);
        orderVerifier.verify(mockConsole).print("Profession: [Doctor, Farmer]");
        orderVerifier.verify(mockConsole).print("Press any key to continue adding more Profession or press 'D' if you are done");
    }

    @Test
    void should_get_property() {
        when(mockInputReader.getValidInput("Age", Integer.class)).thenReturn(27);
        int age = propertyReader.getProperty("Age", Integer.class, null);
        assertEquals(27, age);
    }
}