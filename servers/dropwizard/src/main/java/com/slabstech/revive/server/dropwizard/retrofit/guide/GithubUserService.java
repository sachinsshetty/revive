package com.slabstech.revive.server.dropwizard.retrofit.guide;

import com.slabstech.revive.server.dropwizard.retrofit.guide.GithubUser;

import java.util.List;

public interface GithubUserService {
    @GET("/users")
    public Call<List<GithubUser>> getUsers(
            @Query("per_page") int per_page,
            @Query("page") int page);

    @GET("/users/{username}")
    public Call<GithubUser> getUser(@Path("username") String username);
}
