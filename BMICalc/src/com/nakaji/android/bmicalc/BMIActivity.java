package com.nakaji.android.bmicalc;

import gueei.binding.Binder;
import gueei.binding.app.BindingActivity;
import android.os.Bundle;

import com.nakaji.android.bindingsample.R;

public class BMIActivity extends BindingActivity {

    private BMIViewModel viewModel = new BMIViewModel();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binder.init(this.getApplication());
        setAndBindRootView(R.layout.main, viewModel);
    }
}