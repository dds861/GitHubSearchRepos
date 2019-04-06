package com.dd.githubsearchrepos.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dd.githubsearchrepos.Adapters.GithubUserReposAdapter;
import com.dd.githubsearchrepos.Interfaces.IGithubUserReposInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.RetrofitConnections.RetrofitGithubUserRepos;
import com.dd.githubsearchrepos.ServerClasses.GithubUserRepos;

import java.util.List;

public class GithubUserReposActivity extends AppCompatActivity implements IGithubUserReposInterface {

    private RecyclerView mRecycler;
    private String username;
    private List<GithubUserRepos> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user_repos);
        initView();
        setActionBarSettings();
        getIntentsFromPreviousActivity();
        connectToServer();
    }

    private void connectToServer() {
        RetrofitGithubUserRepos retrofitGithubUserRepos = new RetrofitGithubUserRepos(this);
        retrofitGithubUserRepos.readCall(username);

    }

    private void getIntentsFromPreviousActivity() {
        username = getIntent().getStringExtra(ConstantsApp.USERNAME);
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
    }

    private void setActionBarSettings() {
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
    }



    @Override
    public void dataFromRetrofit(List<GithubUserRepos> item) {
        this.item = item;
        setupRecyclerView(item);
    }

    private void setupRecyclerView(List<GithubUserRepos> item) {
        if (item == null) {
            return;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(GithubUserReposActivity.this);
        mRecycler.setLayoutManager(layoutManager);

        GithubUserReposAdapter recyclerViewAdapter = new GithubUserReposAdapter(getApplicationContext(), this.item);
        mRecycler.setAdapter(recyclerViewAdapter);
    }
}
