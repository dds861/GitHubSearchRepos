package com.dd.githubsearchrepos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mGithubUserSearchEt;
    private Button mGithubUserSearchBtn;
    private EditText mGithubUserEt;
    private Button mGithubUserBtn;
    private EditText mGithubUserReposEt;
    private Button mGithubUserReposBtn;
    private Button mFavoritesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mGithubUserSearchEt = (EditText) findViewById(R.id.et_github_user_search);
        mGithubUserSearchBtn = (Button) findViewById(R.id.btn_github_user_search);
        mGithubUserSearchBtn.setOnClickListener(this);
        mGithubUserEt = (EditText) findViewById(R.id.et_github_user);
        mGithubUserBtn = (Button) findViewById(R.id.btn_github_user);
        mGithubUserBtn.setOnClickListener(this);
        mGithubUserReposEt = (EditText) findViewById(R.id.et_github_user_repos);
        mGithubUserReposBtn = (Button) findViewById(R.id.btn_github_user_repos);
        mGithubUserReposBtn.setOnClickListener(this);
        mFavoritesBtn = (Button) findViewById(R.id.btn_favorites);
        mFavoritesBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_github_user_search:
                Intent intentUserSearch = new Intent(this, GithubUserSearchActivity.class);
                intentUserSearch.putExtra(ConstantsApp.USERNAME, mGithubUserSearchEt.getText().toString());
                startActivity(intentUserSearch);

                break;
            case R.id.btn_github_user:
                Intent intentUser = new Intent(this, GithubUserActivity.class);
                intentUser.putExtra(ConstantsApp.USERNAME, mGithubUserEt.getText().toString());
                startActivity(intentUser);
                break;
            case R.id.btn_github_user_repos:
                Intent intentUserRepos = new Intent(this, GithubUserReposActivity.class);
                intentUserRepos.putExtra(ConstantsApp.USERNAME, mGithubUserReposEt.getText().toString());
                startActivity(intentUserRepos);
                break;
            case R.id.btn_favorites:
                Intent intentFavorites = new Intent(this, GithubUserFavoritesActivity.class);
                startActivity(intentFavorites);

                break;
            default:
                break;
        }
    }
}
