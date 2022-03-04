package kg.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Float firstVar, secondVar;
    private Boolean isClickOperation = false;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                if (tvResult.getText().toString().equals("0")) {
                    break;
                } else if (isClickOperation) {
                    tvResult.setText("0");
                } else {
                    tvResult.append("0");
                }
                isClickOperation = false;
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                firstVar = Float.valueOf(0);
                secondVar = Float.valueOf(0);
                isClickOperation = false;
                break;
            case R.id.btn_dot:
                if (tvResult.toString().endsWith(".")) {
                    break;
                } else if (!tvResult.toString().contains(".")) {
                    break;
                } else {
                    tvResult.append(".");
                }
        }
    }

    public void setNumber(String num) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(num);
        } else if (isClickOperation) {
            tvResult.setText(num);
        } else {
            tvResult.append(num);
        }
        isClickOperation = false;
        Toast.makeText(MainActivity.this, tvResult.getText(), Toast.LENGTH_SHORT).show();
    }

    public void setOperation(String operation) {
        firstVar = Float.parseFloat(tvResult.getText().toString());
        isClickOperation = true;
        this.operation = operation;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                setOperation("+");
                break;
            case R.id.btn_minus:
                setOperation("-");
                break;
            case R.id.btn_divide:
                setOperation("/");
                break;
            case R.id.btn_multiply:
                setOperation("*");
                break;
            case R.id.btn_equal:
                secondVar = Float.parseFloat(tvResult.getText().toString());
                Float result = Float.valueOf(0);
                switch (operation) {
                    case "+":
                        result = (Float) firstVar + (Float)secondVar;
                        break;
                    case "-":
                        result = (Float)firstVar - (Float)secondVar;
                        break;
                    case "*":
                        result = (Float)firstVar * (Float)secondVar;
                        break;
                    case "/":
                        result = (Float)firstVar / (Float)secondVar;
                        break;
                }
                tvResult.setText(result.toString());
                isClickOperation = true;
                break;
        }
    }
}