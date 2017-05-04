package com.example.android.bayes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCaculate;
    EditText mx , my , mz;
    TextView P;
    int x, y, z;
    int Odds;
    InputMethodManager inputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        mx = (EditText) findViewById(R.id.mX);
        my = (EditText) findViewById(R.id.mY);
        mz = (EditText) findViewById(R.id.mZ);
        P = (TextView) findViewById(R.id.mResult);

        btnCaculate =(Button) findViewById(R.id.btnCaculate);
        btnCaculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        x=Integer.parseInt(mx.getText().toString());
        y=Integer.parseInt(my.getText().toString());
        z=Integer.parseInt(mz.getText().toString());

        Odds= x*y*100 /(x*y+z*(100-x));


        P.setText(Integer.toString(Odds)+"%");


        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }
}
