package com.example.jonfi.evgenyfinkincv.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jonfi.evgenyfinkincv.Constants;
import com.example.jonfi.evgenyfinkincv.GitHubRepo;
import com.example.jonfi.evgenyfinkincv.Service.GitHubRepoAdapter;
import com.example.jonfi.evgenyfinkincv.Interfaces.GithubClient;
import com.example.jonfi.evgenyfinkincv.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jonfi on 07/03/2018.
 */

public class SkillsAndProjects extends Fragment {
    private static final String TAG = "SkillsAndProjects";

    private ListView gitlist;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skills_projects, container, false);

        gitlist = (ListView) view.findViewById(R.id.git_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.getmGitUrl())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        GithubClient client = retrofit.create(GithubClient.class);
        Call<List<GitHubRepo>> call = client.mMyrepos(Constants.getmMyName());
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();

                gitlist.setAdapter(new GitHubRepoAdapter(getActivity(), repos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(getActivity(),"error",Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
