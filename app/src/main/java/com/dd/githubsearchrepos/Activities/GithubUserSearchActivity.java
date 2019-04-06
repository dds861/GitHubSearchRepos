package com.dd.githubsearchrepos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dd.githubsearchrepos.Adapters.GithubUserSearchAdapter;
import com.dd.githubsearchrepos.Interfaces.IGithubUserSearchInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.Models.ItemClickSupport;
import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.RetrofitConnections.RetrofitGithubUserSearch;
import com.dd.githubsearchrepos.ServerClasses.GithubUserSearch;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class GithubUserSearchActivity extends AppCompatActivity implements IGithubUserSearchInterface {

    private RecyclerView mRecycler;
    private String username;
    private GithubUserSearch item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user_search);
        initView();
        setActionBarSettings();
        getIntentsFromPreviousActivity();
        connectToServer();
        onItemRecyclerViewClickListerner();
    }

    private void connectToServer() {
        RetrofitGithubUserSearch retrofitGithubUserSearch = new RetrofitGithubUserSearch(this);
        retrofitGithubUserSearch.readCall(username);

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
    public void dataFromRetrofit(GithubUserSearch item) {
        this.item = item;

        setupRecyclerView(item);

    }

    private void setupRecyclerView(GithubUserSearch item) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(GithubUserSearchActivity.this);
        mRecycler.setLayoutManager(layoutManager);

        GithubUserSearchAdapter recyclerViewAdapter = new GithubUserSearchAdapter(getApplicationContext(), this.item);
        mRecycler.setAdapter(recyclerViewAdapter);
    }


    private void onItemRecyclerViewClickListerner() {
        ItemClickSupport.addTo(mRecycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                Intent intent = new Intent(getApplicationContext(), GithubUserActivity.class);
                intent.putExtra(ConstantsApp.USERNAME, item.getItems().get(position).getLogin());
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}
