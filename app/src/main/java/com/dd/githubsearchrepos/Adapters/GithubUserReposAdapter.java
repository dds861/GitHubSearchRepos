package com.dd.githubsearchrepos.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.ServerClasses.GithubUserRepos;

import java.util.List;


public class GithubUserReposAdapter extends RecyclerView.Adapter<GithubUserReposAdapter.ViewHolder> {

    private List<GithubUserRepos> item;
    private Context context;

    public GithubUserReposAdapter(Context context, List<GithubUserRepos> item) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.items_activity_github_user_repos, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("autolog", "onBindViewHolder");
        holder.mNameTv.setText(item.get(position).getName());
        holder.mUrlTv.setText(item.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mNameTv;
        private TextView mUrlTv;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("autolog", "ViewHolder");
            initView(itemView);

        }

        private void initView(@NonNull final View itemView) {
            mNameTv = (TextView) itemView.findViewById(R.id.tv_name);
            mUrlTv = (TextView) itemView.findViewById(R.id.tv_url);
        }
    }
}
