package com.example.jonfi.evgenyfinkincv.Interfaces;

import com.example.jonfi.evgenyfinkincv.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jonfi on 15/03/2018.
 */

public interface GithubClient {
    @GET("/users/evgenyFinkin/repos")
    Call<List <GitHubRepo>> getRepo();
}
