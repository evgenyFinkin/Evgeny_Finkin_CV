package com.example.jonfi.evgenyfinkincv.Service;

import com.example.jonfi.evgenyfinkincv.Constants;
import com.example.jonfi.evgenyfinkincv.Interfaces.GithubClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jonfi on 18/03/2018.
 */

public class GithubApiBuilder {
    private static Retrofit retrofit = null;
    public static GithubClient getClient() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.getGitUrl())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        GithubClient api = retrofit.create(GithubClient.class);
        return api;
    }
}
