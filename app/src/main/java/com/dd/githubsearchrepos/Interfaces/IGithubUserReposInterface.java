package com.dd.githubsearchrepos.Interfaces;

import com.dd.githubsearchrepos.ServerClasses.GithubUserRepos;

import java.util.List;

public interface IGithubUserReposInterface {
    void dataFromRetrofit(List<GithubUserRepos> item);
}
