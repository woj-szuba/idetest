package pl.altkom;

import codingBat.service.MathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathAppTest {

    @Mock
    MathService mathService;

    @InjectMocks
    MathApp mathApp = new MathApp();

    @Test
    public void multiply() {
        when(mathService.multiply(10, 20)).thenReturn(200);
        assertEquals(220, mathApp.multiplyAndAdd(10, 20, 20));
    }
}