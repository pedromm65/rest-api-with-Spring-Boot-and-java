package br.com.pedrohlimadev.entities;

public class Sum extends Operation {
    public Sum() {
    }

    public double sum(String numberOne, String numberTwo) {
        return super.convertToDouble(numberOne) + super.convertToDouble(numberTwo);
    }
}
