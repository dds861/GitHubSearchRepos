package com.dd.githubsearchrepos.RetrofitConnections;

import android.util.Log;

import com.dd.githubsearchrepos.Interfaces.IGithubUserSearchInterface;
import com.dd.githubsearchrepos.Models.ConstantsApp;
import com.dd.githubsearchrepos.ServerClasses.GithubUserSearch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGithubUserSearch {

    private APIService apiService;
    private IGithubUserSearchInterface iGithubUserSearchInterface;

    public RetrofitGithubUserSearch(IGithubUserSearchInterface iGithubUserSearchInterface) {
        this.iGithubUserSearchInterface = iGithubUserSearchInterface;
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

        Call<GithubUserSearch> retrieveCall = apiService.onGetGithubUserSearchResults(username);

        retrieveCall.enqueue(new Callback<GithubUserSearch>() {
            @Override
            public void onResponse(Call<GithubUserSearch> call, Response<GithubUserSearch> response) {
                Log.i("autolog", "response.body(): " + response.body());
                GithubUserSearch githubUserSearch = response.body();

                iGithubUserSearchInterface.dataFromRetrofit(githubUserSearch);
            }

            @Override
            public void onFailure(Call<GithubUserSearch> call, Throwable t) {
                Log.i("autolog", "call: " + call);
                Log.i("autolog", "t: " + t);

            }
        });
    }

}
