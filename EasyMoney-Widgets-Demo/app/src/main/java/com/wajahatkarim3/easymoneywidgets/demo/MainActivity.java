package com.wajahatkarim3.easymoneywidgets.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.wajahatkarim3.easymoneywidgets.EasyMoneyEditText;
import com.wajahatkarim3.easymoneywidgets.EasyMoneyTextView;

public class MainActivity extends AppCompatActivity {

    EasyMoneyEditText moneyEditText;
    EasyMoneyTextView moneyTextView;
    Spinner spinnerCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyEditText = (EasyMoneyEditText) findViewById(R.id.moneyEditText);
        moneyTextView = (EasyMoneyTextView) findViewById(R.id.moneyTextView);
        spinnerCurrency = (Spinner) findViewById(R.id.spinnerCurrency);

        CheckBox checkCommas = (CheckBox) findViewById(R.id.checkCommas);
        checkCommas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b)
                {
                    moneyEditText.showCommas();
                    moneyTextView.showCommas();
                }
                else{
                    moneyEditText.hideCommas();
                    moneyTextView.hideCommas();
                }
            }
        });

        CheckBox checkCurrency = (CheckBox) findViewById(R.id.checkCurrency);
        checkCurrency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    moneyEditText.showCurrencySymbol();
                    moneyTextView.showCurrencySymbol();
                }
                else {
                    moneyEditText.hideCurrencySymbol();
                    moneyTextView.hideCurrencySymbol();
                }
            }
        });

        spinnerCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String itemName = spinnerCurrency.getSelectedItem().toString();
                String symbol = itemName.substring(itemName.indexOf("(")+1, itemName.indexOf(")"));
                moneyEditText.setCurrency(symbol);
                moneyTextView.setCurrency(symbol);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
