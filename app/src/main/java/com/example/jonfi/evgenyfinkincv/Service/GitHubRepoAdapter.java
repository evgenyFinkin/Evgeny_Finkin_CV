package com.example.jonfi.evgenyfinkincv.Service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.gesture.Prediction;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonfi.evgenyfinkincv.Constants;
import com.example.jonfi.evgenyfinkincv.GitHubRepo;
import com.example.jonfi.evgenyfinkincv.GitWebViewActivity;
import com.example.jonfi.evgenyfinkincv.MainActivity;
import com.example.jonfi.evgenyfinkincv.R;

import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * Created by jonfi on 15/03/2018.
 */

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.UsersViewHolder> {

    private static final String TAG = "GitHubRepoAdapter";

    private Context mContext;
    private List<GitHubRepo> mGitHubRepos;
    private UsersViewHolder holder;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> userListResponseData) {
        this.mGitHubRepos = userListResponseData;
        this.mContext = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_pagination, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        holder.list_item_name.setText(mGitHubRepos.get(position).getName());
        holder.list_item_pagination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gitIntent = new Intent(mContext, GitWebViewActivity.class);
                gitIntent.putExtra("Url",mGitHubRepos.get(position).getHtml_url());
                mContext.startActivity(gitIntent);
            }
        });
        }

    @Override
    public int getItemCount() {return mGitHubRepos.size();}

    class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView list_item_name;
        ImageView project_type;
        RelativeLayout list_item_pagination;

        public UsersViewHolder(View itemView) {
            super(itemView);
            list_item_name = (TextView) itemView.findViewById(R.id.list_item_name);
            project_type = (ImageView)itemView.findViewById(R.id.project_type);
            list_item_pagination = (RelativeLayout) itemView.findViewById(R.id.list_item_pagination);
        }
    }
}
