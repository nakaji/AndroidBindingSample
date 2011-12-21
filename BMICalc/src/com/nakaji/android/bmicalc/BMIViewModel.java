package com.nakaji.android.bmicalc;

import gueei.binding.Command;
import gueei.binding.observables.DoubleObservable;
import gueei.binding.observables.StringObservable;
import android.view.View;

public class BMIViewModel {

    public DoubleObservable BMI = new DoubleObservable();
    public StringObservable height = new StringObservable();
    public StringObservable weight = new StringObservable();

    public Command Calculate = new Command() {

        @Override
        public void Invoke(View arg0, Object... arg1) {
            Calculate();
        }
    };

    private void Calculate() {
        double bmi = Double.parseDouble(weight.get()) / Math.pow(Double.parseDouble(height.get()) / 100.0, 2);
        BMI.set(bmi);
    };

}
