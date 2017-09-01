package com.crats.mvcprat3;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Victor on 2017-06-12.
 */

public class Api {


    private Context context;

    public Api(Context context){

        this.context = context;
        Log.i("TEST", "Api created");


    }



    public JsonObjectRequest objectRequest(String url, final String authToken, final ApiDelegate callback){ //Because callback is accessed from within inner class it has to be declared final

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.i("TEST", "worked");
                        String box = "wow what a good response";
                        callback.gotExercisesSuccess(box);


                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TEST EXERCISE", "error: " + error.getMessage());

                String box2 = " Sorry it did not worked";
                callback.gotExercisesfailed(box2);

            }

        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                headers.put("Authorization", authToken);
                return headers;

            }


        };




        return jsonObjectRequest;
    }
}
