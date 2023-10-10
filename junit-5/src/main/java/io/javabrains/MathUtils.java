package io.javabrains;

public class MathUtils { // to create a test press ctrl+shift+T
    public int add(int a, int b){
        return a + b;
    }

    public int divide(int a, int b){
        if (b==0){
            throw new ArithmeticException("Can't divide by 0");
        } else {
            return a/b;
        }
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public double rectangleArea(Integer width, Integer length){
        return width * length;
    }

}
