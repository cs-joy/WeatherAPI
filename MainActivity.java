package edu.gcu.shadsluiter.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Button btn_CityID, btn_getWeatherID, btn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign values to each control on the layout
        btn_CityID = findViewById(R.id.btn_getCityID);
        btn_getWeatherID = findViewById(R.id.btn_getWeatherByCityID);
        btn_getWeatherByName = findViewById(R.id.btn_getWeatherByCityName);

        et_dataInput = findViewById(R.id.et_dataInput);
        lv_weatherReports = findViewById(R.id.lv_weatherReports);

        // click listeners for each buttons
        btn_CityID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String apiKey = "";

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "http://api.openweathermap.org/data/2.5/weather?q=singapore&APPID=" +apiKey;

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    //JSONArray jsonArray = response.getJSONArray("weather");

                                    //for(int i = 0; i < jsonArray.length(); i++) {
                                        //JSONObject with = jsonArray.getJSONObject(0);
                                        //JSONObject json = response.getJSONObject("sys");

                                        //int id = with.getInt("id");
                                        int main = response.getInt("id");
                                        //int main = json.getInt("sunrise");
                                       // String description = with.getString("description");
                                        //String icon = with.getString("icon");

                                        Toast.makeText(MainActivity.this, "dt: " + main, Toast.LENGTH_SHORT).show();
                                    //}

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //Toast.makeText(MainActivity.this, "hi: ", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Something wrong!", Toast.LENGTH_SHORT).show();
                            }
                        });
                /*
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error Occurred! That didn't work!", Toast.LENGTH_SHORT).show();
                    }
                });
                */
                // Add the request to the RequestQueue.
                queue.add(request);

                //Toast.makeText(MainActivity.this, "You Clicked Me! btn_CityID", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "You clicked me! btn_getWeatherID", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "You clicked " + et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
