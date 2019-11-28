package com.example.a1stexampart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String operator;
    private double res, n1, n2;
    private TextView screen;
    private boolean done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operator = "";
        screen = findViewById(R.id.textView);
        done = false;
    }

    public void num(View view) {
        if (done) screen.setText(""); done = false;
        Button b = (Button) view;
        screen.setText(screen.getText().toString() + b.getText().toString());
    }

    public void clean(View view) {
        screen.setText("");
        res = 0.0; n1 = 0.0; n2 = 0.0;
    }

    public void operate(View view) {
        Button b = (Button) view;
        if (operator.equals("")) {
            checkOp(b.getText().toString());
        } else if (b.getText().equals("=")) {
            checkOp("=");
        } else {
            checkOp(operator);
        }
    }

    public void checkOp(String s) {
        if (screen.getText().equals("")) n1 = 0.0;
        else n1 = Double.valueOf(screen.getText().toString());
        try {
            switch (s) {
                case "+":
                    res = n2 + n1;
                    operator = "+";
                    screen.setText(Double.toString(res));
                    break;
                case "-":
                    res = n2 - n1;
                    operator = "-";
                    screen.setText(Double.toString(res));
                    break;
                case "x":
                    res = n2 * n1;
                    operator = "x";
                    screen.setText(Double.toString(res));
                    break;
                case "÷":
                    if (n1 == 0.0) {
                        Toast t = Toast.makeText(this, "You cannot divide by zero. Please try again.", Toast.LENGTH_SHORT);
                        t.show();
                    } else {
                        res = n2 / n1;
                        operator = "÷";
                        screen.setText(Double.toString(res));
                    }
                    break;
                default:
                    Toast t = Toast.makeText(this, "There's an error on the operation. Please clean and try again.", Toast.LENGTH_SHORT);
                    t.show();
                    break;
            }
            n2 = n1;
            done = true;
        } catch (Exception e) {
            Toast t = Toast.makeText(this, "There's an error on the number. Please clean and try again.", Toast.LENGTH_SHORT);
            t.show();
        }
    }
    public void equals(View view) {
        checkOp(operator);
        screen.setText(Double.toString(res));
        operator = "";
        n2 = 0.0;
        done = true;
    }
}
