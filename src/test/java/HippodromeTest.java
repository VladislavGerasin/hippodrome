import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class HippodromeTest {



    @Test
    public void testConstructorWithNull(){
        List<Horse> horses = null;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
        assertEquals("Horses cannot be null.", e.getMessage());
    }

    @Test
    public void testConstructorListEmpty(){
        List<Horse> horses = new ArrayList<>();
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
        assertEquals("Horses cannot be empty.", e.getMessage());
    }

    @Test
    public void testGetHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse" + i, i ,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses,hippodrome.getHorses());
    }

    @Test
    public void testMove() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for(Horse horse:horses){
            verify(horse).move();
        }

    }

    @Test
    public void testGetWinner() {
        Horse horse1 = new Horse("n1",1,1);
        Horse horse2 = new Horse("n2",1,2);
        Horse horse3 = new Horse("n3",1,3);
        Horse horse4 = new Horse("n4",1,4);
        Hippodrome hippodrome = new Hippodrome(List.of(horse1,horse2,horse3,horse4));
        assertSame(horse4,hippodrome.getWinner());



    }







}
