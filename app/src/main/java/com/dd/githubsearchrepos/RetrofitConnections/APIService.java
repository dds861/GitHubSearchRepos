package com.dd.githubsearchrepos.RetrofitConnections;

import com.dd.githubsearchrepos.ServerClasses.GithubUser;
import com.dd.githubsearchrepos.ServerClasses.GithubUserRepos;
import com.dd.githubsearchrepos.ServerClasses.GithubUserSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * искать пользователей по GitHub (https://api.github.com/search/users?q=%username%)
 * просматривать информацию (https://api.github.com/users/%username%)
 * и список репозиториев (https://api.github.com/users/%username%/repos)
 */

public interface APIService {
    @GET("search/users")
    Call<GithubUserSearch> onGetGithubUserSearchResults(@Query("q") String username);
//    Call<List<GithubUserSearch>> onGetGithubUserSearchResults(@Path("username") String username);

    @GET("users/{username}")
    Call<GithubUser> onGetGithubUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<GithubUserRepos>> onGetGithubUserRepos(@Path("username") String username);
}
