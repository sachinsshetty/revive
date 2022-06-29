package com.slabstech.revive.server.dropwizard.retrofit.guide;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    public static void main(String[] args) {
        // Manual creation
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
        GithubUserService service = retrofit.create(GithubUserService.class);
        // Using GitHubServiceGenerator
        service = GitHubServiceGenerator.createService(GithubUserService.class);
        Call<GithubUser> callSync = service.getGithubUser("eugenp");
        Call<GithubUser> callAsync = service.getGithubUser("eugenp");

        try {
            Response<GithubUser> response = callSync.execute();
            GithubUser GithubUser = response.body();
            System.out.println(GithubUser);
        } catch (IOException ex) {
        }

        // Execute the call asynchronously. Get a positive or negative callback.
        callAsync.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
                GithubUser GithubUser = response.body();
                System.out.println(user);
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });

    }
}