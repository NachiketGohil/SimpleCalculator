package com.nachiket.simplecalculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView tvInput, tvSign;
    String sign, value1, value2;
    Double num1, num2, result;
    boolean hasDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInput = findViewById(R.id.tv_input);
        tvSign = findViewById(R.id.tv_sign);

        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void clickZero(View view) {
        tvInput.setText(tvInput.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void clickOne(View view) {
        tvInput.setText(tvInput.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void clickTwo(View view) {
        tvInput.setText(tvInput.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void clickThree(View view) {
        tvInput.setText(tvInput.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void clickFour(View view) {
        tvInput.setText(tvInput.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void clickFive(View view) {
        tvInput.setText(tvInput.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void clickSix(View view) {
        tvInput.setText(tvInput.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void clickSeven(View view) {
        tvInput.setText(tvInput.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void clickEight(View view) {
        tvInput.setText(tvInput.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void clickNine(View view) {
        tvInput.setText(tvInput.getText() + "9");
    }

    @SuppressLint("SetTextI18n")
    public void clickDot(View view) {
        if (!hasDot) {
            if (tvInput.getText().equals("")) {
                tvInput.setText("0.");
            } else {
                tvInput.setText(tvInput.getText().toString() + ".");
            }
            hasDot = true;
        }
    }

    public void clearField(View view) {
        tvInput.setText(null);
        tvSign.setText(null);
        value1 = null;
        value2 = null;
        sign = null;
        hasDot = false;
    }

    public void clearChar(View view) {
        //to delete text one by one
        if (tvInput.getText().equals(""))
            tvInput.setText(null);
        else {
            int len = tvInput.getText().length();
            String equation = tvInput.getText().toString();

            if (equation.charAt(len - 1) == '.') {
                hasDot = false;
                tvInput.setText(tvInput.getText().subSequence(0, tvInput.getText().length() - 1));
            } else {
                tvInput.setText(tvInput.getText().subSequence(0, tvInput.getText().length() - 1));
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void clickPower(View view) {
        sign = "power";
        value1 = tvInput.getText().toString();
        tvInput.setText(null);
        hasDot = false;
        tvSign.setText("xⁿ");
    }

    @SuppressLint("SetTextI18n")
    public void clickSqrRoot(View view) {
        sign = "root";
        tvInput.setText(null);
        hasDot = false;
        tvSign.setText("√");
    }

    public void clickPlus(View view) {
        sign = "+";
        value1 = tvInput.getText().toString();
        tvInput.setText(null);
        tvSign.setText("+");
        hasDot = false;
    }

    public void clickMinus(View view) {
        sign = "−";
        value1 = tvInput.getText().toString();
        tvInput.setText(null);
        tvSign.setText("−");
        hasDot = false;
    }

    public void clickCross(View view) {
        sign = "×";
        value1 = tvInput.getText().toString();
        tvInput.setText(null);
        tvSign.setText("×");
        hasDot = false;
    }

    public void clickDivision(View view) {
        sign = "÷";
        value1 = tvInput.getText().toString();
        tvInput.setText(null);
        tvSign.setText("÷");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void clickEqual(View view) {
        if (sign == null) {
            tvSign.setText(R.string.error);
        } else if (tvInput.getText().equals("")) {
            tvSign.setText(R.string.error);
        } else if ((sign.equals("+") || sign.equals("−") || sign.equals("×") || sign.equals("÷")) && value1.equals("")) {
            tvSign.setText(R.string.error);
        } else {
            switch (sign) {
                case "+" :
                    value2 = tvInput.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 + num2;
                    tvInput.setText(result + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                case "−" :
                    value2 = tvInput.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 - num2;
                    tvInput.setText(result + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                case "×" :
                    value2 = tvInput.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 * num2;
                    tvInput.setText(result + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                case "÷" :
                    value2 = tvInput.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 / num2;
                    tvInput.setText(result + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                case "power":
                    num1 = Double.parseDouble((value1));
                    value2 = tvInput.getText().toString();
                    num2 = Double.parseDouble(value2);
                    tvInput.setText(Math.pow(num1, num2) + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                case "root":
                    value1 = tvInput.getText().toString();
                    num1 = Double.parseDouble((value1));
                    tvInput.setText(Math.sqrt(num1) + "");
                    sign = null;
                    tvSign.setText(null);
                    break;

                default:
                    break;
            }
        }
    }

}
