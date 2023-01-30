import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GoblinTest {

    private Goblin goblin;

    @BeforeEach
    void init() {
        goblin = new Goblin(3, 3);
    }

    @Test
    @DisplayName("Goblin constructor test")
    void constructor() {
        assertAll(
                () -> assertEquals(3, goblin.posX),
                () -> assertEquals(3, goblin.posY),
                () -> assertEquals(80, goblin.health),
                () -> assertEquals(15, goblin.power));
    }

    @ParameterizedTest
    @DisplayName("Goblin isInRange test")
    @MethodSource("isInRangeProvider")
    void isInRange(int targetX, int targetY, boolean expectedIsInRange) {
        assertEquals(expectedIsInRange, goblin.isInRange(targetX, targetY));
    }

    static Stream<Arguments> isInRangeProvider() {
        return Stream.of(
                arguments(5, 5, true),
                arguments(5, 1, true),
                arguments(1, 1, true),
                arguments(1, 5, true),
                arguments(3, 3, true),
                arguments(3, 5, true),
                arguments(3, 1, true),
                arguments(1, 3, true),
                arguments(5, 3, true),
                arguments(2, 2, true),
                arguments(2, 4, true),
                arguments(4, 2, true),
                arguments(4, 4, true),
                arguments(6, 6, false),
                arguments(6, 0, false),
                arguments(0, 0, false),
                arguments(0, 6, false),
                arguments(1, 6, false),
                arguments(2, 6, false),
                arguments(4, 6, false),
                arguments(5, 6, false),
                arguments(1, 0, false),
                arguments(2, 0, false),
                arguments(4, 0, false),
                arguments(5, 0, false),
                arguments(0, 1, false),
                arguments(0, 2, false),
                arguments(0, 4, false),
                arguments(0, 5, false),
                arguments(6, 5, false),
                arguments(6, 4, false),
                arguments(6, 2, false),
                arguments(6, 1, false),
                arguments(3, 7, false));
    }
}
