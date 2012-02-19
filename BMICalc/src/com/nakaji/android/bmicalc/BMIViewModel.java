package com.nakaji.android.bmicalc;

import gueei.binding.Command;
import gueei.binding.observables.StringObservable;

import java.math.BigDecimal;

import android.view.View;

public class BMIViewModel {
    public StringObservable BMI = new StringObservable();
    public StringObservable Height = new StringObservable();
    public StringObservable Weight = new StringObservable();

    public Command Calculate = new Command() {
        @Override
        public void Invoke(View arg0, Object... arg1) {
            double height = Double.valueOf(Height.get());
            double weight = Double.valueOf(Weight.get());
            double bmi = weight / Math.pow(height / 100.0, 2);
            BigDecimal bd = new BigDecimal(bmi);
            BMI.set(bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        }
    };
}
