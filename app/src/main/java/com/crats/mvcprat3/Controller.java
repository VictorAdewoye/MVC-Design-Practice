package com.crats.mvcprat3;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;

import static com.android.volley.toolbox.Volley.newRequestQueue;

/**
 * Created by Victor on 2017-06-12.
 */

public class Controller implements HandlerOneDelegate, IHandlerTwo {

    private Context context;
    private Api api;
    private RequestQueue requestQueue;
    public ControllerDelegate controllerDelegate =null;
    public HandlerOne handlerOne;
    //public HandlerTwo handlerTwo;

    public Controller(Context context){
        this.context = context;
        this.api = new Api (this.context);
        Log.i("TEST", "Controller created");
        this.handlerOne = new HandlerOne(this.context);
        //this.handlerTwo = new HandlerTwo(this.context);
        requestQueue = newRequestQueue(this.context);
        this.handlerOne.handlerOneDelegate = this;

    }



    public  void getInfo(){
        Log.i("TEST", "Controller: GETINFO");
        this.requestQueue.add(this.api.objectRequest("https://dev.trainerpl.us/api/v1/exercises","token dcf2350d4c334d9d79a11f289af6ce79c41e6915",this.handlerOne));
        //this.requestQueue.add(this.api.objectRequest("https://dev.trainerpl.us/api/v1/exercises","token dcf2350d4c334d9d79a11f289af6ce79c41e6915",this.handlerTwo));
        this.requestQueue.start();

    }

    @Override
    public void success(String show) {
        Log.i("TEST", "on to the view, " + show);
        controllerDelegate.success(show);
    }

    @Override
    public void failure(String show) {
        Log.i("TEST", "on to the view, " + show);
        controllerDelegate.failure(show);
    }

    public void handleTwoSuccess(String show)
    {
        controllerDelegate.clientSuccess(show);
    }

    public void handleTwofailure(String error) {
        controllerDelegate.clientFailure(error);
    }
}
