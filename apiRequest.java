String url = ""; // url of your api

JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                  
                                    // without JSONArray and JSONObject of Object that means only JSONObject
                                    /*
                                      {
                                        "base":"stations",
                                        "visibility":10000,
                                        "timezone":28800,
                                        "id":1880252,
                                        "name":"Singapore",
                                        "cod":200
                                      }
                                    */
                                    String base = response.getString("base");
                                    int visibility = response.getInt("visibility");
                                    int timezone = response.getInt("timezone");
                                    int id = response.getInt("id");
                                    String name = response.getString("name");
                                    int cod = response.getInt("cod");
                                  
                                  // print the result with Toast
                                  Toast.makeText(MainActivity.this, "base: " + base + ",visibility : " + visibility + ",timezone : " + timezone + ",id : " + id + ",name : " + name + ",cod : " + cod, Toast.LENGTH_SHORT).show();
                                  
                                  
                                  
                                    // with JSONArray of Object
                                    JSONArray jsonArray = response.getJSONArray("weather");

                                    
                                        JSONObject arrayObj = jsonArray.getJSONObject(0);
                                        /*
                                        "weather":[
                                          {
                                            "id":501,
                                            "main":"Rain",
                                            "description":"moderate rain",
                                            "icon":"10n"
                                          }
                                        ]
                                        */
                                        int id = arrayObj.getInt("id");
                                        String main = arrayObj.getString("main");
                                        String description = arrayObj.getString("description");
                                        String icon = arrayObj.getString("icon");
                                  
                                       // print the result with Toast
                                     Toast.makeText(MainActivity.this, "id: " + id + ",main : " + main + ",description : " + description + ",icon : " + icon, Toast.LENGTH_SHORT).show();
                                  
                                  
                                  
                                  
                                  
                                        // with JSONObject of Object
                                        JSONObject jsonObj = response.getJSONObject("sys");
                                       /*
                                         "sys":
                                         {
                                           "type":1,
                                           "id":9470,
                                           "country":"SG",
                                           "sunrise":1654901907,
                                           "sunset":1654945804
                                         }
                                       */
                                        int type = jsonObj.getInt("type");
                                        int id = jsonObj.getInt("id");
                                        String country = jsonObj.getString("country");
                                        int sunrise = jsonObj.getInt("sunrise");
                                        int sunset = jsonObj.getInt("sunset");
                                         // print the result with Toast
                                      Toast.makeText(MainActivity.this, "type: " + type + ",id : " + id + ",country : " + country + ",sunrise : " + sunrise + ",sunset : " + sunset, Toast.LENGTH_SHORT).show();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                //Toast.makeText(MainActivity.this, "hi: ", Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Error Occured!", Toast.LENGTH_SHORT).show();
                            }
 });
