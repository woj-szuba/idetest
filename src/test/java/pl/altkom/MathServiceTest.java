package pl.altkom;

import codingBat.service.MathService;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathServiceTest {

    @Test
    public void multiply() {
        // Given
        MathService math = new MathService();
        int a = 10, b = 20;
        int expectedOutput = 200;
        // When
        int actualOutput = math.multiply(a, b);
        // Then
        assertEquals(expectedOutput, actualOutput);
    }
}