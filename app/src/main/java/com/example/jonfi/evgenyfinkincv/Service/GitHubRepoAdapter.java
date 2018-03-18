package com.example.jonfi.evgenyfinkincv.Service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonfi.evgenyfinkincv.Constants;
import com.example.jonfi.evgenyfinkincv.GitHubRepo;
import com.example.jonfi.evgenyfinkincv.R;

import java.util.List;

/**
 * Created by jonfi on 15/03/2018.
 */

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.UsersViewHolder> {

    Context context;
    List<GitHubRepo> gitHubRepos;
    private UsersViewHolder holder;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> userListResponseData) {
        this.gitHubRepos = userListResponseData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_pagination, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        holder.list_item_name.setText("Name: " + gitHubRepos.get(position).getName());
        holder.list_item_html_url.setText("Html: " + gitHubRepos.get(position).getHtml_url());
        }

    @Override
    public int getItemCount() {
        return gitHubRepos.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView list_item_name, list_item_html_url;

        public UsersViewHolder(View itemView) {
            super(itemView);
            list_item_name = (TextView) itemView.findViewById(R.id.list_item_name);
            list_item_html_url = (TextView) itemView.findViewById(R.id.list_item_html_url);
        }
    }

}
