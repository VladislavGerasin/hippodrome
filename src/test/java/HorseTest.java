import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

public class HorseTest {


    @Test
    public void testConstructorThrowsExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null,1.1,1.1));
    }

    @Test
    public void testConstructorThrowsExceptionWithMessageOnNull() {
        try {
            new Horse(null, 1.1, 1.1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"","   ", "\t\t", "\n\n"})
    public void testConstructorThrowsExceptionOnInvalidNames(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1.1, 1.1));
        assertEquals("Name cannot be blank.", e.getMessage());
    }

    @Test
   public void testConstructorThrowsExceptionWithMessageOnSpeedNegative() {
        try {
            new Horse("Мурзилка", -4, 1.1);
        } catch (IllegalArgumentException e) {
            assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void testConstructorThrowsExceptionWithMessageOnDistanceNegative() {
        try {
            new Horse("Мурзилка", 1.1, -5);
        } catch (IllegalArgumentException e) {
            assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void testGetNameReturnsCorrectName() {
        String expectedName = "Мурзилка";
        Horse horse = new Horse(expectedName, 1.1, 1.1);
        assertEquals(expectedName, horse.getName());
    }

    @Test
   public void testGetSpeedReturnsCorrectSpeed() {
        double expectedSpeed = 1.1;
        Horse horse = new Horse("Мурзилка", expectedSpeed, 1.1);
        assertEquals(expectedSpeed, horse.getSpeed());
    }


    @Test
    public void testGetDistanceReturnsCorrectDistance() {
        double expectedDistance = 5.0;
        Horse horse = new Horse("Мурзилка", 10.5, expectedDistance);
        assertEquals(expectedDistance, horse.getDistance());
    }

    @Test
    public void testGetDistanceReturnsZeroForTwoParamConstructor() {
        Horse horse = new Horse("Мурзилка", 10.5);
        assertEquals(0.0, horse.getDistance());
    }


    @ParameterizedTest
    @ValueSource(doubles = {1.1,1.2,1.3})
   public void testMoveCallsGetRandomDoubleAndUpdatesDistance(double random) {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)) {
            Horse horse = new Horse("Мурзилка", 1.1,5.4);

            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
            horse.move();
            assertEquals(5.4 * 31 * random, horse.getDistance());

        }
    }



}
