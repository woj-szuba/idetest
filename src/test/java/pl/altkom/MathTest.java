package pl.altkom;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {

    @Test
    public void multiply() {
        // Given
        Math math = new Math();
        int a = 10, b = 20;
        int expectedOutput = 200;
        // When
        int actualOutput = math.multiply(a, b);
        // Then
        assertEquals(expectedOutput, actualOutput);
    }
}