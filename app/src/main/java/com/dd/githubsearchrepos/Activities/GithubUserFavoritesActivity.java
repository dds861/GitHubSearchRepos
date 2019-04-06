package com.dd.githubsearchrepos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dd.githubsearchrepos.Adapters.GithubUserFavoritesAdapter;
import com.dd.githubsearchrepos.Interfaces.IGithubUserFavoritesInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.Models.ItemClickSupport;
import com.dd.githubsearchrepos.Presenter.Presenter;
import com.dd.githubsearchrepos.R;
import com.dd.githubsearchrepos.ServerClasses.GithubUser;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class GithubUserFavoritesActivity extends AppCompatActivity implements IGithubUserFavoritesInterface {

    private RecyclerView mRecycler;
    private Presenter presenter;
    private List<GithubUser> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user_favorites);
        initView();
        setActionBarSettings();




        onItemRecyclerViewClickListerner();
    }

    @Override
    protected void onResume() {
        super.onResume();

        item = presenter.getAll();
        setupRecyclerView(item);
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        presenter = new Presenter();
    }

    private void setActionBarSettings() {
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
    }


    private void setupRecyclerView(List<GithubUser> item) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(GithubUserFavoritesActivity.this);
        mRecycler.setLayoutManager(layoutManager);

        GithubUserFavoritesAdapter recyclerViewAdapter = new GithubUserFavoritesAdapter(getApplicationContext(), item);
        mRecycler.setAdapter(recyclerViewAdapter);
    }

    private void onItemRecyclerViewClickListerner() {
        ItemClickSupport.addTo(mRecycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                Intent intent = new Intent(getApplicationContext(), GithubUserActivity.class);
                intent.putExtra(ConstantsApp.USERNAME, item.get(position).getLogin());
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }

}
