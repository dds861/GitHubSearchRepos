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
import com.dd.githubsearchrepos.ServerClasses.GithubUserSearch;


public class GithubUserSearchAdapter extends RecyclerView.Adapter<GithubUserSearchAdapter.ViewHolder> {

    private GithubUserSearch item;
    private Context context;

    public GithubUserSearchAdapter(Context context, GithubUserSearch item) {
        Log.i("autolog", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("autolog", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.items_activity_github_user_search, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("autolog", "onBindViewHolder");
        holder.mLoginTv.setText(item.getItems().get(position).getLogin());
        holder.mUrlTv.setText(item.getItems().get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        Log.i("autolog", "getItemCount");
        return item.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView mLoginTv;
        private TextView mUrlTv;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.i("autolog", "ViewHolder");

            initView(itemView);
        }

        private void initView(@NonNull final View itemView) {
            mLoginTv = (TextView) itemView.findViewById(R.id.tv_login);
            mUrlTv = (TextView) itemView.findViewById(R.id.tv_url);
        }
    }
}
