package br.com.pedrohlimadev.entities;

public class Division extends Operation {
    public Division() {
    }

    public double division(String numberOne, String numberTwo) {
        return super.convertToDouble(numberOne) / super.convertToDouble(numberTwo);
    }
}
