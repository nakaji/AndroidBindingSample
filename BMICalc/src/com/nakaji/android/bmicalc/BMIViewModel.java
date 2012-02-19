package com.nakaji.android.bmicalc;

import gueei.binding.Command;
import gueei.binding.observables.StringObservable;
import gueei.binding.validation.ModelValidator;
import gueei.binding.validation.ValidationResult;
import gueei.binding.validation.validators.Required;

import java.math.BigDecimal;

import android.view.View;

public class BMIViewModel {
    public StringObservable BMI = new StringObservable();
    @Required(ErrorMessage = "Height is required.")
    public StringObservable Height = new StringObservable();
    @Required(ErrorMessage = "Weight is required.")
    public StringObservable Weight = new StringObservable();

    public Command Calculate = new Command() {
        @Override
        public void Invoke(View arg0, Object... arg1) {
            ValidationResult res = ModelValidator.ValidateModel(BMIViewModel.this);
            if (res.isValid()) {
                double height = Double.valueOf(Height.get());
                double weight = Double.valueOf(Weight.get());
                double bmi = weight / Math.pow(height / 100.0, 2);
                BigDecimal bd = new BigDecimal(bmi);
                BMI.set(bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
            } else {
                String errorMessage = "";
                for (String error : res.getValidationErrors()) {
                    errorMessage += error + "\n";
                }
                BMI.set(errorMessage);
            }
        }
    };
}
