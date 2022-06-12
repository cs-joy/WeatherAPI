btn_CityID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String apiKey = ""; //should be need to fill up with key

                // Instantiate the RequestQueue.
                //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                String url = "http://api.openweathermap.org/data/2.5/weather?q="+ et_dataInput.getText().toString() +"&APPID=" +apiKey;

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    //JSONArray jsonArray = response.getJSONArray("weather");

                                    //for(int i = 0; i < jsonArray.length(); i++) {
                                        //JSONObject with = jsonArray.getJSONObject(0);
                                        //JSONObject json = response.getJSONObject("sys");

                                        //int id = with.getInt("id");
                                        int cityId = response.getInt("id");
                                        //int main = json.getInt("sunrise");
                                       // String description = with.getString("description");
                                        //String icon = with.getString("icon");

                                        Toast.makeText(MainActivity.this, "CityID= " + cityId, Toast.LENGTH_SHORT).show();
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
                //queue.add(request);
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);

                //Toast.makeText(MainActivity.this, "You Clicked Me! btn_CityID", Toast.LENGTH_SHORT).show();
            }
        });
