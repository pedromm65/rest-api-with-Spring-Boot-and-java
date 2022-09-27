package br.com.pedrohlimadev.entities;

public class SquareRoot extends Operation{
    public SquareRoot() {
    }

    public double sqrt(String number) {
        return Math.sqrt(super.convertToDouble(number));
    }
}
