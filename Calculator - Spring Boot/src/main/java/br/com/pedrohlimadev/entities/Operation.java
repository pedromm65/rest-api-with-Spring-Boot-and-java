package br.com.pedrohlimadev.entities;

import br.com.pedrohlimadev.exceptions.UnsupportedMathOperationException;

public abstract class Operation {


    public Operation() {
    }


    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String strNumber) {
        if(!isNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }
}
