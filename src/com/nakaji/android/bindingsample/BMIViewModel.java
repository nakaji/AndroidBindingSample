package com.nakaji.android.bindingsample;

import gueei.binding.pojo.PojoViewModel;
import gueei.binding.pojo.PojoViewModelHelper;

public class BMIViewModel implements PojoViewModel {

    private PojoViewModelHelper helper = new PojoViewModelHelper();
    private double bmi;
    private double height;
    private double weight;

    public PojoViewModelHelper getHelper() {
        return helper;
    }

    public void notifyPropertyChanged(String propertyName) {
        helper.notifyPropertyChanged(propertyName);
    }

    public void Calculate() {
        double bmi = weight / Math.pow(height / 100.0, 2);
        setBMI(bmi);
    };

    public void setBMI(double bmi) {
        this.bmi = bmi;
        notifyPropertyChanged("BMI");
    }

    public String getBMI() {
        return "Your BMI is " + String.valueOf(bmi);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
