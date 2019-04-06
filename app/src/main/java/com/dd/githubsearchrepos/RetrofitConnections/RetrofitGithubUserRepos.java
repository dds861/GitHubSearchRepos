package com.dd.githubsearchrepos.RetrofitConnections;

import android.util.Log;

import com.dd.githubsearchrepos.Interfaces.IGithubUserReposInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.ServerClasses.GithubUserRepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGithubUserRepos {

    private APIService apiService;
    private IGithubUserReposInterface iGithubUserReposInterface;

    public RetrofitGithubUserRepos(IGithubUserReposInterface iGithubUserReposInterface) {
        this.iGithubUserReposInterface = iGithubUserReposInterface;
        installRetrofit();
    }

    private void installRetrofit() {
        try {
            String url = ConstantsApp.URL;
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService = retrofit.create(APIService.class);

        } catch (Exception e) {
            Log.i("autolog", "e: " + e);
        }
    }


    public void readCall(String username) {

        Call<List<GithubUserRepos>> retrieveCall = apiService.onGetGithubUserRepos(username);

        retrieveCall.enqueue(new Callback<List<GithubUserRepos>>() {
            @Override
            public void onResponse(Call<List<GithubUserRepos>> call, Response<List<GithubUserRepos>> response) {
                Log.i("autolog", "response.body(): " + response.body());

                List<GithubUserRepos> body = response.body();
                iGithubUserReposInterface.dataFromRetrofit(body);
            }

            @Override
            public void onFailure(Call<List<GithubUserRepos>> call, Throwable t) {
                Log.i("autolog", "call: " + call);
                Log.i("autolog", "t: " + t);

            }
        });
    }

}
