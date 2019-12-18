package link.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import link.bmicalculator.core.Health;

public class MainActivity extends AppCompatActivity {
    NumberPicker heightNumberPicker;
    NumberPicker weightNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  }
    public void calculateBtnClick(View v){
        double height = 0;
        double weight = 0;
        if(heightNumberPicker != null){
            height = heightNumberPicker.getValue();
        }
        if(weightNumberPicker != null){
            weight = weightNumberPicker.getValue();
        }
        Health health = new Health();
        double bmiResult = health.calculateBMI(height, weight);
        TextView resultTextView = findViewById(R.id.resultTextView);
        if(bmiResult == -1){
            resultTextView.setText(health.getErrorMessage());
        } else{
            String bmiCat = health.determineBMIcategory(bmiResult);
            resultTextView.setText("Your BMI index is" + String.format("%.2f", bmiResult) + "\nBMI Category " + bmiCat);
        }

    }


}