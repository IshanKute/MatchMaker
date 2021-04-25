package matchmaker.models;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static matchmaker.models.District.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DistrictTest {

    @Test
    void should_get_nearby_districts() {
        assertAll(
                () -> assertArrayEquals(new District[]{Yavatmal, Akola, Wardha, Washim}, Amravati.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Yavatmal, Akola, Wardha, Washim}, Nanded.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Yavatmal, Akola, Wardha, Washim}, Buldhana.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Amravati, Wardha, Washim, Nanded}, Yavatmal.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Amravati, Buldhana, Washim}, Akola.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Yavatmal, Amravati, Nagpur}, Wardha.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Wardha}, Nagpur.getNearbyDistricts().toArray()),
                () -> assertArrayEquals(new District[]{Yavatmal, Akola, Amravati, Nanded}, Washim.getNearbyDistricts().toArray())
        );
    }
}
