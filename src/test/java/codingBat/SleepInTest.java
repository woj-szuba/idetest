package codingBat;

import org.junit.Test;

import static org.junit.Assert.*;

public class SleepInTest {

    @Test
    public void sleepInShouldReturnTrueWhenFalseFalse() {
        //Given
        SleepIn sleepIn = new SleepIn();
        boolean first = false, second = false;
        // When
        boolean actualOutput = sleepIn.sleepIn(first, second);
        // Then
        assertTrue(actualOutput);
    }

    @Test
    public void sleepInShouldReturnTrueWhenFalseTrue() {
        //Given
        SleepIn sleepIn = new SleepIn();
        boolean first = false, second = true;
        // When
        boolean actualOutput = sleepIn.sleepIn(first, second);
        // Then
        assertTrue(actualOutput);
    }

    @Test
    public void sleepInShouldReturnTrueWhenTrueTrue() {
        //Given
        SleepIn sleepIn = new SleepIn();
        boolean first = true, second = true;
        // When
        boolean actualOutput = sleepIn.sleepIn(first, second);
        // Then
        assertTrue(actualOutput);
    }

    @Test
    public void sleepInShouldReturnFalseWhenTrueFalse() {
        //Given
        SleepIn sleepIn = new SleepIn();
        boolean first = true, second = false;
        // When
        boolean actualOutput = sleepIn.sleepIn(first, second);
        // Then
        assertFalse(actualOutput);
    }
}