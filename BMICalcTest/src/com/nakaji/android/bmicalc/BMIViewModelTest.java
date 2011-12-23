package com.nakaji.android.bmicalc;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class BMIViewModelTest {
    private BMIViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new BMIViewModel();
    }

    @Test
    public void Calc() {
        viewModel.height.set("172");
        viewModel.weight.set("60");
        viewModel.Calculate.Invoke(null, (Object[]) null);

        Assert.assertEquals(60 / Math.pow(172 / 100.0, 2), viewModel.BMI.get());
    }
}
