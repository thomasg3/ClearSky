package tgeboers.clearsky.services;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class ServiceFactory {

    private final static String ACCU_WEATHER_API_KEY = "SQxHyCplchKldLeqV3EFzHHZGsM5tHk0";

    public AccuWeatherService createAccuWeatherService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com")
                .client(new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            HttpUrl originalHttpUrl = original.url();

                            HttpUrl url = originalHttpUrl.newBuilder()
                                    .addQueryParameter("apikey", ACCU_WEATHER_API_KEY)
                                    .build();

                            // Request customization: add request headers
                            Request.Builder requestBuilder = original.newBuilder()
                                    .url(url);

                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                    })
                    .build())
                .build();
        return retrofit.create(AccuWeatherService.class);
    }

}
