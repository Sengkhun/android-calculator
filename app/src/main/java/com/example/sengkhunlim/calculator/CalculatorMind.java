package com.example.sengkhunlim.calculator;

public class CalculatorMind {

    private Double preResult;
    private String currentDisplay, lastOp;
    private Boolean clear, pressed;

    public CalculatorMind() {

        preResult = 0.0;
        currentDisplay = "0";
        lastOp = "";
        clear = pressed = false;

    }

    // Function that handle the operator
    public String operation( String op ) {

        if ( !pressed )
            preResult = calculate( preResult, Double.parseDouble( currentDisplay ), lastOp );

        lastOp = op;
        clear = pressed = true;

        currentDisplay = fmt( preResult );

        if ( op.equals( "=" ) ) {

            preResult = 0.0;
            pressed = false;

        }

        return currentDisplay;

    }

    // Function that do the operation
    public Double calculate( Double n1, Double n2, String op ) {

        switch ( op ) {

            case "+":
                return n1 + n2;

            case "-":
                return n1 - n2;

            case "x":
                return n1 * n2;

            case "/":
                return n1 / n2;

            case "%":
                return n1 % n2;

        }

        return n1 + n2;

    }

    // Function that handle the button number
    public String typeDigit( String digit ) {

        pressed = false;

        String newTextInDisplay;

        if ( currentDisplay.equals( "0" ) )
            currentDisplay = "";

        if ( digit.equals( "0" ) && currentDisplay.equals( "0" ) ) {

            newTextInDisplay = "0";

        } else if ( clear ) {

            newTextInDisplay = digit;
            clear = false;

        } else {

            newTextInDisplay = currentDisplay + digit;

        }

        currentDisplay = newTextInDisplay;
        return currentDisplay;

    }

    // Function that handle the dot sign
    public String dot() {

        clear = false;

        if ( pressed || lastOp.equals( "=" ) )
            currentDisplay = "0.";

        if ( !currentDisplay.contains( "." ) )
            currentDisplay += ".";

        return currentDisplay;

    }

    // Function that clear the display
    public String clear() {

        preResult = 0.0;
        currentDisplay = "0";
        lastOp = "";
        clear = pressed = false;

        return currentDisplay;

    }

    // Function that delete the last digit
    public String del( String currentText ) {

        if ( currentText.length() <= 1 )
            currentDisplay = "0";
        else
            currentDisplay = currentText.substring( 0, currentText.length() - 1 );

        return currentDisplay;

    }

    // Function that handle the fraction to show or not
    public String fmt(double d)
    {

        if ( d == (long) d )
            return String.format( "%d", (long) d );
        else
            return String.format( "%s", d );

    }

}
