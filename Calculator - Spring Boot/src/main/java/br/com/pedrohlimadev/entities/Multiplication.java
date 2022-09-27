package br.com.pedrohlimadev.entities;

public class Multiplication extends Operation {
    public Multiplication() {
    }

    public double multiplication(String numberOne, String numberTwo) {
        return super.convertToDouble(numberOne) * super.convertToDouble(numberTwo);
    }
}
