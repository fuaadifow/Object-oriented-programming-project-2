import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CreatureTest {

    private class Unicorn extends Creature {
        boolean inRange = true;
        public Unicorn() {
            health = 100;
            power = 20;
            posX = 10;
            posY = 5;
        }

        @Override
        public boolean isInRange(int targetPosX, int targetPosY) {
            return inRange;
        }
    }

    private Unicorn unicorn;

    @BeforeEach
    void init() {
        unicorn = new Unicorn();
    }

    @ParameterizedTest
    @DisplayName("Test attack")
    @MethodSource("attackProvider")
    void attack(boolean inRange, int expectedHealth) {
        unicorn.inRange = inRange;
        Unicorn anotherUnicorn = new Unicorn();
        unicorn.attack(anotherUnicorn);
        assertEquals(expectedHealth, anotherUnicorn.health);
    }

    static Stream<Arguments> attackProvider() {
        return Stream.of(
            arguments(true, 80),
            arguments(false, 100)
        );
    }

    @ParameterizedTest
    @DisplayName("Test move")
    @MethodSource("moveProvider")
    void move(int xMove, int yMove, int expectedPosX, int expectedPosY) {
        unicorn.move(xMove,yMove);
        assertEquals(expectedPosX, unicorn.posX);
        assertEquals(expectedPosY, unicorn.posY);
    }

    static Stream<Arguments> moveProvider() {
        return Stream.of(
                arguments(3, 2, 13, 7),
                arguments(-2, -6, 8, -1));
    }

    @ParameterizedTest
    @DisplayName("Test isDefeated")
    @MethodSource("isDefeatedProvider")
    void isDefeated(int health, boolean expectedIsDefeated) {
        unicorn.health = health;
        assertEquals(expectedIsDefeated, unicorn.isDefeated());
    }

    static Stream<Arguments> isDefeatedProvider() {
        return Stream.of(
                arguments(1, false),
                arguments(0, true),
                arguments(-1, true)
        );
    }

}