package com.nakaji.android.bindingsample;

import gueei.binding.Binder;
import gueei.binding.Command;
import gueei.binding.observables.StringObservable;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AndroidBindingSampleActivity extends Activity {

    private EditText heightText;
    private EditText weightText;

    public StringObservable BMI = new StringObservable("");

    public Command Calculate = new Command() {
        @Override
        public void Invoke(View arg0, Object... arg1) {
            double height = Integer.valueOf(heightText.getText().toString());
            double weight = Integer.valueOf(weightText.getText().toString());
            double bmi = weight / Math.pow(height / 100.0, 2);
            BMI.set("Your BMI is " + String.valueOf(bmi));
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.main, this);

        heightText = (EditText) findViewById(R.id.height);
        weightText = (EditText) findViewById(R.id.weight);
    }

}