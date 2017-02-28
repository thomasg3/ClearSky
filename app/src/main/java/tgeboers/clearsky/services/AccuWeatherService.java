package tgeboers.clearsky.services;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tgeboers.clearsky.data.AccuWeatherLocation;

public interface AccuWeatherService {
    @GET("/locations/v1/cities/autocomplete")
    Call<List<AccuWeatherLocation>> autocompleteLocations(@Query("q") String query);
}
