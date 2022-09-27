package br.com.pedrohlimadev.entities;

public class Mean extends Operation {
    public Mean() {
        super();
    }

    public double mean(String numberOne, String numberTwo) {
        return (super.convertToDouble(numberOne) + super.convertToDouble(numberTwo)) / 2;
    }
}
