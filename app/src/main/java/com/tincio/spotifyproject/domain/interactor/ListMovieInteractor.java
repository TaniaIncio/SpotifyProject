package com.tincio.spotifyproject.domain.interactor;



public class ListMovieInteractor {
/*
    ListMovieCallback callback;
    public int TIMEOUT = 5000;
    PopularMoviesApplication application = PopularMoviesApplication.mApplication;
    public ListMovieInteractor(ListMovieCallback callback){
        this.callback = callback;
    }

    public void callListMovies(String option){
        try{
            getRequesListMovies(Constants.serviceNames.GET_LIST_MOVIES(option));
        }catch(Exception e){
            throw e;
        }
    }

    void getRequesListMovies(String url) {
        try{
            PopularMoviesApplication application = PopularMoviesApplication.mApplication;
            if (application != null) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                        url,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Gson gson = new Gson();
                                ResponseMovies responseMovies = gson.fromJson(response.toString(), ResponseMovies.class);
                                callback.onResponse(checkFavoriteInList(responseMovies));
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                              callback.onResponse(null, error.getMessage());
                            }
                        });
                jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                        TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                application.getRequestQueue().add(jsonObjectRequest);
            }
        }catch(Exception e){
            throw e;
        }
    }

   */

}
