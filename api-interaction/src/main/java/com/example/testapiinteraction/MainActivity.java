package com.example.testapiinteraction;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonResponseString;
        requestConversionRate("EUR","USD");
        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        jsonResponseString = share.getString("Response", "");
        Gson gson = new Gson();
        ConversionRate conversion = gson.fromJson(jsonResponseString, ConversionRate.class);

        TextView rate = findViewById(R.id.textView);
        String EURUSD = conversion.getPrice().getEURUSD().toString();
        rate.setText(EURUSD);


    }

    public void requestConversionRate(String curAbrvFrom, String curAbrvTo){
        String requestURL = "https://fxmarketapi.com/apilive?api_key=kL3JkTc0rul_Ulaz1NWY&currency="+curAbrvFrom+curAbrvTo;
        //Currency currencyInfo = new Currency();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                requestURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response", response.toString());
                        TextView jsonResponseText = findViewById(R.id.editText);
                        jsonResponseText.setText(response.toString());
                        sharedResponse(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Response", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }

    private void sharedResponse(String response){
        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("Response", response);
        editor.commit();
    }

    private void writeToFile(String data, Context context){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}



//  try {
//          JSONArray currencyResponse = response.getJSONArray("price");
//          for (int i =0; i < currencyResponse.length(); i++){
//        JSONObject curencyJson = currencyResponse.getJSONObject(i);
//        currencyInfo.conversionRate =
//        }
//
//        } catch (JSONException e) {
//        e.printStackTrace();
//        }


