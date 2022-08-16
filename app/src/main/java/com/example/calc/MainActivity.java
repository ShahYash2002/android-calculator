package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import logic.*;

public class MainActivity extends AppCompatActivity {

  static String expression = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void clearFields(View view) {
    TextView display = (TextView) findViewById(R.id.textView);
    display.setText("");
    expression = "";
  }

  public void numberBtnClickHandler(View view) {
    Button btn = (Button) findViewById(view.getId());
    expression += btn.getText();
    TextView display = (TextView) findViewById(R.id.textView);
    display.setText(expression);
  }

  public void operatorHandler(View view) {
    Button btn = (Button) findViewById(view.getId());
    expression += btn.getText();
    TextView display = (TextView) findViewById(R.id.textView);
    display.setText(expression);
  }

  public void evaluate(View view) {
    TextView display = (TextView) findViewById(R.id.textView);
    String infix = display.getText().toString();
    try {

      String postfix = PostfixConvertor.toPostFix(infix);

      double ans = PostfixEvaluation.evaluate(postfix);

      display.setText(infix + " = " + ans);
    }
    catch (Exception e) {
      display.setText("Invalid Expression : "+infix);
    }
    expression = "";
  }

  public void decimalHandler(View view) {
    Button btn = (Button) findViewById(view.getId());
    expression += btn.getText();
    TextView display = (TextView) findViewById(R.id.textView);
    display.setText(expression);
  }
}