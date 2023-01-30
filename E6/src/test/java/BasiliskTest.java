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

public class BasiliskTest {

    private Basilisk basilisk;

    @BeforeEach
    void init() {
        basilisk = new Basilisk(3, 3);
    }

    @Test
    @DisplayName("Basilisk constructor test")
    void constructor() {
        assertAll(
                () -> assertEquals(3, basilisk.posX),
                () -> assertEquals(3, basilisk.posY),
                () -> assertEquals(200, basilisk.health),
                () -> assertEquals(30, basilisk.power));
    }

    @ParameterizedTest
    @DisplayName("Basilisk isInRange test")
    @MethodSource("isInRangeProvider")
    void isInRange(int targetX, int targetY, boolean expectedIsInRange) {
        assertEquals(expectedIsInRange, basilisk.isInRange(targetX, targetY));
    }

    static Stream<Arguments> isInRangeProvider() {
        return Stream.of(
                arguments(1, 5, true),
                arguments(5, 5, true),
                arguments(3, 3, false),
                arguments(0, 5, false),
                arguments(6, 5, false),
                arguments(3, 4, false),
                arguments(3, 6, false),
                arguments(1, 1, false),
                arguments(5, 1, false)
        );
    }

}
