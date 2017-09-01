package com.crats.mvcprat3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Victor on 2017-06-12.
 */


public class HandlerTwo implements ApiDelegate {
    private Context context;
    private String TAG = "TEST EXERCISE";
    public IHandlerTwo delegate = null;


    //constructor
    public HandlerTwo(Context context) {
        this.context = context;
    }



    @Override
    public void gotExercisesSuccess(String exerList){

        Log.i(TAG, "you are the bomb");

        this.delegate.handleTwoSuccess(exerList);

    }

    @Override
    public void gotExercisesfailed(String noList) {
        Log.i(TAG, "fetchExercisefailed2: " + noList);
        this.delegate.handleTwofailure(noList);
    }
}