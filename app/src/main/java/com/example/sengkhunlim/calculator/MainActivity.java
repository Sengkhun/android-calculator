package com.example.sengkhunlim.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private Double result;
    private String lastOp;
    private Boolean clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = 0.0;
        lastOp = "";
        clear = false;
        displayTextView = (TextView) findViewById(R.id.result);

    }

    // Function that handle the operator
    public void operation(View view) {

        int opId;
        Double currentValue;

        opId = view.getId();
        Button opButton = (Button) findViewById(opId);

        String currentOp = opButton.getText().toString();
        currentValue = Double.parseDouble(displayTextView.getText().toString());

        result = calculate(result, currentValue, lastOp);

        lastOp = currentOp;
        displayTextView.setText(fmt(result));
        clear = true;

        if (currentOp.equals("=")) {

            lastOp = "";
            result = 0.0;

        }

    }

    // Function that do the operation
    public Double calculate(Double n1, Double n2, String op) {

        switch (op) {

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
    public void typeDigit(View view) {

        int digitButtonId;
        String currentTextInDislpay;
        String newTextInDisplay;

        digitButtonId = view.getId();
        Button typeDigitButton = (Button) findViewById(digitButtonId);

        String currentType = typeDigitButton.getText().toString();
        currentTextInDislpay = displayTextView.getText().toString();

        if (currentTextInDislpay.equals("0")) {

            currentTextInDislpay = "";

        }

        if (currentType.equals("0") && currentTextInDislpay.equals("")) {

            newTextInDisplay = "0";

        } else if (clear) {

            newTextInDisplay = typeDigitButton.getText().toString();
            clear = false;

        } else {

            newTextInDisplay = currentTextInDislpay + typeDigitButton.getText().toString();

        }

        displayTextView.setText(newTextInDisplay);

    }

    // Function that handle the dot sign
    public void dot(View view) {

        String currentTextInDisplay = displayTextView.getText().toString();

        if (!currentTextInDisplay.contains(".")) {

            displayTextView.setText(currentTextInDisplay + ".");

        }

    }

    // Function that clear the display
    public void clear(View view) {

        displayTextView.setText("0");

    }

    // Function that delete the last digit
    public void del(View view) {

        String str = displayTextView.getText().toString();

        if (str.length() <= 1) {

            str = "0";

        } else {

            str = str.substring(0, str.length() - 1);

        }

        displayTextView.setText(str);

    }

    // Function that handle the fraction to show or not
    public String fmt(double d)
    {

        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);

    }

}
