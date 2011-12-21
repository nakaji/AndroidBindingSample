package com.nakaji.android.bmicalc;

import com.nakaji.android.bindingsample.R;

import gueei.binding.Binder;
import android.app.Activity;
import android.os.Bundle;

public class BMIActivity extends Activity {

    private BMIViewModel viewModel = new BMIViewModel();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.main, viewModel);
    }
}