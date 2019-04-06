package com.dd.githubsearchrepos.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dd.githubsearchrepos.Adapters.GithubUserAdapter;
import com.dd.githubsearchrepos.Interfaces.IGithubUserInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.Presenter.Presenter;
import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.RetrofitConnections.RetrofitGithubUser;
import com.dd.githubsearchrepos.ServerClasses.GithubUser;

public class GithubUserActivity extends AppCompatActivity implements IGithubUserInterface, View.OnClickListener {

    private RecyclerView mRecycler;
    private String username;
    private GithubUser item;
    private Button mAddToFavoritesBtn;
    private Button mDeleteToFavoritesBtn;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user);
        initView();
        setActionBarSettings();

        getIntentsFromPreviousActivity();
        connectToServer();
    }

    private void getIntentsFromPreviousActivity() {
        username = getIntent().getStringExtra(ConstantsApp.USERNAME);
    }

    private void connectToServer() {
        RetrofitGithubUser retrofitGithubUser = new RetrofitGithubUser(this);
        retrofitGithubUser.readCall(username);

    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mAddToFavoritesBtn = (Button) findViewById(R.id.btn_add_to_favorites);
        mAddToFavoritesBtn.setOnClickListener(this);
        mDeleteToFavoritesBtn = (Button) findViewById(R.id.btn_delete_to_favorites);
        mDeleteToFavoritesBtn.setOnClickListener(this);
        presenter = new Presenter();
    }


    @Override
    public void dataFromRetrofit(GithubUser item) {
        this.item = item;

        setupRecyclerView(item);
    }

    private void setupRecyclerView(GithubUser item) {
        if(item==null){
            return;
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(GithubUserActivity.this);
        mRecycler.setLayoutManager(layoutManager);

        GithubUserAdapter recyclerViewAdapter = new GithubUserAdapter(getApplicationContext(), this.item);
        mRecycler.setAdapter(recyclerViewAdapter);

    }


    private void setActionBarSettings() {
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_to_favorites:
                if (item != null) {
                    presenter.insert(item);
                }
                break;
            case R.id.btn_delete_to_favorites:
                presenter.delete(item);
                break;
            default:
                break;
        }
    }
}
