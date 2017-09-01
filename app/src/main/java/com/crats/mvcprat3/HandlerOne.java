package com.crats.mvcprat3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Victor on 2017-06-12.
 */

public class HandlerOne implements ApiDelegate {
    private Context context;
    private String TAG = "TEST";
    HandlerOneDelegate handlerOneDelegate;





    //constructor
    public HandlerOne(Context context) {
        this.context = context;

    }

    @Override
    public void gotExercisesSuccess(String exerList) {

        Log.i(TAG, "I appreciate you, " + exerList);
        handlerOneDelegate.success(exerList);





    }

    @Override
    public void gotExercisesfailed(String noList) {
        Log.i(TAG, "gotExercises failed: " + noList);
        handlerOneDelegate.failure(noList);




    }
}