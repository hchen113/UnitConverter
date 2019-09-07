package com.example.unitconverter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final EditText text_input = findViewById(R.id.text_input);
        FloatingActionButton convert_button = findViewById(R.id.convert_button);
        final TextView text_output = findViewById(R.id.text_output);
        final Spinner unit_spinner = findViewById(R.id.spinner);

        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String selected = unit_spinner.getSelectedItem().toString();

                if (selected.equals("centimeter to inches") == true){
                    double cm_val = Double.parseDouble(text_input.getText().toString());
                    double in_val = cm_val/2.54;
                    int ft_val = (int) in_val/12;
                    double ft_remain_in = in_val - (ft_val*12);

                    text_output.setText(String.valueOf(round(in_val,2)) + " inches" + "\n" + ft_val + " feet " + String.valueOf(round(ft_remain_in,2)) + " in");
                }

                else if(selected.equals("inches to centimeter") == true){
                    double in_val = Double.parseDouble(text_input.getText().toString());
                    double cm_val = in_val*2.54;
                    int meter_val = (int) cm_val / 100;
                    double meter_remain_cm = cm_val - (meter_val*100);

                    text_output.setText(String.valueOf(round(cm_val,2)) + "centimeters" + "\n" + meter_val + " meter(s) " + String.valueOf(round(meter_remain_cm,2)) + "centimeters");
                }


            }
        });
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
