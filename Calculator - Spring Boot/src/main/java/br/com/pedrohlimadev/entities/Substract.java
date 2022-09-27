package br.com.pedrohlimadev.entities;

public class Substract extends Operation{

    public Substract() {
        super();
    }

    public double substract(String numberOne, String numberTwo) {
        return super.convertToDouble(numberOne) - super.convertToDouble(numberTwo);
    }
}
