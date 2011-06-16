package com.nakaji.android.bindingsample;

import gueei.binding.Binder;
import gueei.binding.Command;
import gueei.binding.observables.StringObservable;
import gueei.binding.pojo.PojoViewModel;
import gueei.binding.pojo.PojoViewModelHelper;
import gueei.binding.pojo.PojoViewModelWrapper;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BMIActivity extends Activity implements PojoViewModel {

    private PojoViewModelHelper helper = new PojoViewModelHelper();

    public PojoViewModelHelper getHelper() {
        return helper;
    }

    public void notifyPropertyChanged(String propertyName) {
        helper.notifyPropertyChanged(propertyName);
    }

    private EditText heightText;
    private EditText weightText;
    private double _bmi;

    public void setBMI(double bmi) {
        _bmi = bmi;
        notifyPropertyChanged("BMI");
    }

    public String getBMI() {
        return "Your BMI is " + String.valueOf(_bmi);
    }

    public void Calculate() {
        double height = Integer.valueOf(heightText.getText().toString());
        double weight = Integer.valueOf(weightText.getText().toString());
        double bmi = weight / Math.pow(height / 100.0, 2);
        setBMI(bmi);
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.main, PojoViewModelWrapper.create(this));

        heightText = (EditText) findViewById(R.id.height);
        weightText = (EditText) findViewById(R.id.weight);
    }
}