package com.shantanu.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView input_value;
    private AppCompatButton button_ac, delete_one_char, button_mod, button_divide, button_7, button_8, button_9, button_multiply, button_4, button_5, button_6, button_subtract, button_1, button_2, button_3, button_add, button_0, button_dot, button_equals;
    private String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = "";

        // obtain all id
        obtainID();

        // set onclick listener on all button
        setOnClickListener();
    }

    private void obtainID() {
        input_value = findViewById(R.id.input_value);

        button_dot = findViewById(R.id.button_dot);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_ac = findViewById(R.id.button_ac);
        delete_one_char = findViewById(R.id.delete_one_char);
        button_mod = findViewById(R.id.button_mod);
        button_divide = findViewById(R.id.button_divide);
        button_multiply = findViewById(R.id.button_multiply);
        button_subtract = findViewById(R.id.button_subtract);
        button_add = findViewById(R.id.button_add);
        button_equals = findViewById(R.id.button_equals);
    }

    private void setOnClickListener() {
        button_ac.setOnClickListener(this);
        delete_one_char.setOnClickListener(this);
        button_mod.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_equals.setOnClickListener(this);
        button_dot.setOnClickListener(this);

        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_ac:
                input_value.setText("");
                input = "";
                checkLength();
                break;
            case R.id.button_0:
                input_value.setText(input += button_0.getText().toString());
                checkLength();
                break;
            case R.id.button_1:
                input_value.setText(input += button_1.getText().toString());
                checkLength();
                break;
            case R.id.button_2:
                input_value.setText(input += button_2.getText().toString());
                checkLength();
                break;
            case R.id.button_3:
                input_value.setText(input += button_3.getText().toString());
                checkLength();
                break;
            case R.id.button_4:
                input_value.setText(input += button_4.getText().toString());
                checkLength();
                break;
            case R.id.button_5:
                input_value.setText(input += button_5.getText().toString());
                checkLength();
                break;
            case R.id.button_6:
                input_value.setText(input += button_6.getText().toString());
                checkLength();
                break;
            case R.id.button_7:
                input_value.setText(input += button_7.getText().toString());
                checkLength();
                break;
            case R.id.button_8:
                input_value.setText(input += button_8.getText().toString());
                checkLength();
                break;
            case R.id.button_9:
                input_value.setText(input += button_9.getText().toString());
                checkLength();
                break;
            case R.id.button_add: {
                input = input_value.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                else {
                    checkLength();
                    input_value.setText(input += button_add.getText().toString());
                }
                break;
            }
            case R.id.button_subtract: {
                input = input_value.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                else {
                    checkLength();
                    input_value.setText(input += button_subtract.getText().toString());
                }
                break;
            }
            case R.id.button_multiply: {
                input = input_value.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                else {
                    checkLength();
                    input_value.setText(input += button_multiply.getText().toString());
                }
                break;
            }
            case R.id.button_divide: {
                input = input_value.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                else {
                    checkLength();
                    input_value.setText(input += button_divide.getText().toString());
                }
                break;
            }
            case R.id.button_mod: {
                input = input_value.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
                else {
                    checkLength();
                    input_value.setText(input += button_mod.getText().toString());
                }
                break;
            }
            case R.id.button_dot: {
                checkLength();
                input = input_value.getText().toString();
                if(input.length() == 0) {
                    input += "0";
                    input_value.setText(input += button_dot.getText().toString());
                }
                else
                    input_value.setText(input += button_dot.getText().toString());
                break;
            }
            case R.id.delete_one_char: {
                input = input_value.getText().toString();
                input_value.setText(input.substring(0,input.length()-1));
                checkLength();
            }
            case R.id.button_equals: {
                input = input_value.getText().toString();
                if(input.contains("/")) {
                    checkLength();
                    input_value.setText(String.valueOf(divideOperation()));
                    input = String.valueOf(divideOperation());
                } else if (input.contains("*")) {
                    checkLength();
                    input_value.setText(String.valueOf(multiplyOperation()));
                    input = String.valueOf(multiplyOperation());
                } else if (input.contains("%")) {
                    checkLength();
                    input_value.setText(String.valueOf(modOperation()));
                    input = String.valueOf(modOperation());
                } else if (input.contains("+")) {
                    checkLength();
                    input_value.setText(String.valueOf(addOperation()));
                    input = String.valueOf(addOperation());
                } else if (input.contains("-")) {
                    checkLength();
                    input_value.setText(String.valueOf(subtractOperation()));
                    input = String.valueOf(subtractOperation());
                }  else
                    input_value.setText(input);
            }
        }
    }

    private double addOperation() {
        double add_result = 0;
        String[] r = input_value.getText().toString().split("\\+");

        for(int i=0; i<r.length; i++) {
            add_result = add_result + Double.parseDouble(r[i]);
        }

        return add_result;
    }

    private double subtractOperation() {
        double subtract_result = 0.0;
        String[] r = input_value.getText().toString().split("\\-");

        int index = 1;
        subtract_result  = Double.parseDouble(r[0]);

        while (index < r.length) {
            subtract_result -= Double.parseDouble(r[index]);
            index++;
        }

        return subtract_result;
    }

    private double divideOperation() {
        double divide_result = 1;
        String[] r = input_value.getText().toString().split("\\/");

        int index = 1;
        divide_result  = Double.parseDouble(r[0]);

        while (index < r.length) {
            divide_result /= Double.parseDouble(r[index]);
            index++;
        }
        return divide_result;
    }

    private double multiplyOperation() {
        double multiply_result = 1;
        String[] r = input_value.getText().toString().split("\\*");

        for(int i=0; i<r.length; i++) {
            multiply_result = multiply_result * Double.parseDouble(r[i]);
        }

        return multiply_result;
    }

    private double modOperation() {
        double mod_result = 1;
        String[] r = input_value.getText().toString().split("\\%");

        mod_result = Double.parseDouble(r[0]);

        int index = 1;
        while (index < r.length) {
            mod_result %= Double.parseDouble(r[index]);
            index++;
        }

        return mod_result;
    }

    private void checkLength() {
        int length = input_value.getText().toString().length();
        if(length <= 6) {
            input_value.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        } if(length >= 7 && length < 10) {
            input_value.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
        } else if (length >= 10 && length < 15) {
            input_value.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        }
    }
}