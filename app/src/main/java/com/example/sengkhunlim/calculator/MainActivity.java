package com.example.sengkhunlim.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private String result;
    private CalculatorMind cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal = new CalculatorMind();
        displayTextView = (TextView) findViewById(R.id.result);

    }

    // Function that handle the operator
    public void operation(View view) {

        int opId = view.getId();
        Button opButton = findViewById(opId);
        String currentOp = opButton.getText().toString();

        result = cal.operation( currentOp );
        displayTextView.setText( result );

    }

    // Function that handle the button number
    public void typeDigit(View view) {

        Button typeDigitButton = findViewById( view.getId() );
        String currentType = typeDigitButton.getText().toString();

        result = cal.typeDigit( currentType );
        displayTextView.setText( result );

    }

    // Function that handle the dot sign
    public void dot(View view) {

        result = cal.dot();
        displayTextView.setText( result );

    }

    // Function that clear the display
    public void clear(View view) {

        cal.clear();
        displayTextView.setText("0");

    }

    // Function that delete the last digit
    public void del(View view) {

        String str = displayTextView.getText().toString();

        result = cal.del( str );

        displayTextView.setText( result );

    }

}
