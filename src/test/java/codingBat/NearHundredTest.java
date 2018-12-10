package codingBat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class NearHundredTest {

    NearHundred tested;

    @Before
    public void initialize(){
        tested = new NearHundred();
    }

    @Test
    public void nearHundredShouldReturnFalseFor20() {
        // Given
        int a= 20;
        // When
        boolean actualOutput = tested.nearHundred(a);
        // Then
        assertFalse(actualOutput);

    }

    @Test
    public void nearHundredShouldReturnTrueFor90() {
        // Given
        int a= 90;
        // When
        boolean actualOutput = tested.nearHundred(a);
        // Then
        assertTrue(actualOutput);
    }

    @Test
    public void nearHundredShouldReturnFalseFor2() {
        // Given
        int a= 2;
        // When
        boolean actualOutput = tested.nearHundred(a);
        // Then
        assertFalse(actualOutput);
    }
}