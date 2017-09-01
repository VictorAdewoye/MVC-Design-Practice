package com.crats.mvcprat3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoDisp3 extends AppCompatActivity implements ControllerDelegate  {

    Button button1;
    TextView textview;
    Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_disp3);

        button1 = (Button) findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textView2);

        this.controller = new Controller(this.getBaseContext());
        this.controller.controllerDelegate = this;




    }


    public void fetch(View view) {
        Log.i("TEST", "Button Clicked");

        this.controller.getInfo();

    }



//    @Override
//    public void displayOnView(String display) {
//        //String show = display;
//        textview.setText(display);
//
//
//    }

    @Override
    public void failure(String show) {

    }

    @Override
    public void success(String show) {


       textview.append("Arrived here safely, hurray \n  \n");
        textview.setText(show);
    }

    public void clientSuccess(String show) {
        textview.append("Arrived here safely, hurray \n  \n");
        textview.setText(show);

    }

    public void clientFailure(String error) {
        textview.append("Arrived here safely, hurray \n  \n");
        textview.setText(error);

    }
}
