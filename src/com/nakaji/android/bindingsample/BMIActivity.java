package com.nakaji.android.bindingsample;

import gueei.binding.Binder;
import gueei.binding.pojo.PojoViewModelWrapper;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class BMIActivity extends Activity {

    private EditText heightText;
    private EditText weightText;

    private BMIViewModel viewModel = new BMIViewModel();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binder.init(this.getApplication());
        Binder.setAndBindContentView(this, R.layout.main, PojoViewModelWrapper.create(viewModel));

        heightText = (EditText) findViewById(R.id.height);
        weightText = (EditText) findViewById(R.id.weight);

        heightText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charsequence, int i, int j, int count) {
                if (count > 0) {
                    viewModel.setHeight(Double.valueOf(charsequence.toString()));
                } else {
                    viewModel.setHeight(0);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        weightText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence charsequence, int i, int j, int count) {
                if (count > 0) {
                    viewModel.setWeight(Double.valueOf(charsequence.toString()));
                }
                else {
                    viewModel.setWeight(0);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}