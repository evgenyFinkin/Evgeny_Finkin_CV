package com.example.jonfi.evgenyfinkincv.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jonfi.evgenyfinkincv.Constants;
import com.example.jonfi.evgenyfinkincv.GitHubRepo;
import com.example.jonfi.evgenyfinkincv.MainActivity;
import com.example.jonfi.evgenyfinkincv.Service.GitHubRepoAdapter;
import com.example.jonfi.evgenyfinkincv.Interfaces.GithubClient;
import com.example.jonfi.evgenyfinkincv.R;
import com.example.jonfi.evgenyfinkincv.Service.GithubApiBuilder;

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

    private RecyclerView gitlist;
    List<GitHubRepo> gitHubRepos;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skills_projects, container, false);

        gitlist = (RecyclerView) view.findViewById(R.id.git_list);

        getUserListData();

        return view;
    }

    private void getUserListData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        (GithubApiBuilder.getClient().getRepo()).enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                Log.d("responseGET", response.body().get(0).getName());
                progressDialog.dismiss();
                gitHubRepos = response.body();
                setDataInRecyclerView();

            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setDataInRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        gitlist.setLayoutManager(linearLayoutManager);
        GitHubRepoAdapter usersAdapter = new GitHubRepoAdapter(getActivity(), gitHubRepos);
        gitlist.setAdapter(usersAdapter);
    }
}
