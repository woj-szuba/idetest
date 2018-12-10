package pl.altkom;

import codingBat.service.MathService;

public class MathApp {




    private MathService mathService;

    public int multiplyAndAdd(int a, int b, int c){

        int result = (mathService.multiply(a, b)) + c;
        return result;
    }
}
