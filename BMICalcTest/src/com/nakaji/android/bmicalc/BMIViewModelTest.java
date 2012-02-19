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
        viewModel.Height.set("172");
        viewModel.Weight.set("60");
        viewModel.Calculate.Invoke(null, (Object[]) null);

        Assert.assertEquals("20.28", viewModel.BMI.get());
    }
}
