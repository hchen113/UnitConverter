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
import android.widget.TextView;


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

        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cm_val = Double.parseDouble(text_input.getText().toString());
                double in_val = cm_val/2.54;
                int ft_val = (int) in_val/12;
                double ft_remain_in = in_val - (ft_val*12);

                text_output.setText(String.valueOf(df2.format(in_val)) + " inches" + "\n" + ft_val + " feet " + ft_remain_in + " in");

            }
        });
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
