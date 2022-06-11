JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    JSONArray jsonArray = response.getJSONArray("weather");

                                    //for(int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject with = jsonArray.getJSONObject(0);
                                  
                                        // without JSONArray
                                        JSONObject json = response.getJSONObject("sys");

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
