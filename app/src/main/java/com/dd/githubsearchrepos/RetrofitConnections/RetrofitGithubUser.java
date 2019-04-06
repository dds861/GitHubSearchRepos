package com.dd.githubsearchrepos.RetrofitConnections;

import android.util.Log;

import com.dd.githubsearchrepos.Interfaces.IGithubUserInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.ServerClasses.GithubUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGithubUser {

    private APIService apiService;
    private IGithubUserInterface iGithubUserInterface;

    public RetrofitGithubUser(IGithubUserInterface iGithubUserInterface) {
        this.iGithubUserInterface = iGithubUserInterface;
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

        Call<GithubUser> retrieveCall = apiService.onGetGithubUser(username);

        retrieveCall.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {

                GithubUser list = response.body();
                iGithubUserInterface.dataFromRetrofit(list);
                Log.i("autolog", "response.body(): " + response.body());
            }

            @Override
            public void onFailure(Call<GithubUser> call, Throwable t) {
                Log.i("autolog", "call: " + call);
                Log.i("autolog", "t: " + t);

            }
        });
    }

}
