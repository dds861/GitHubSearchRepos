package com.dd.githubsearchrepos.Presenter;


import com.dd.githubsearchrepos.RoomDatabase.App;
import com.dd.githubsearchrepos.RoomDatabase.AppDatabase;
import com.dd.githubsearchrepos.RoomDatabase.GithubUserDao;
import com.dd.githubsearchrepos.ServerClasses.GithubUser;

import java.util.List;

public class Presenter {

    private AppDatabase db;
    private GithubUserDao githubUserDao;


    public Presenter() {
        this.db =  App.getInstance().getDatabase();
        this.githubUserDao = db.githubUserDao();
    }

    public void insert(GithubUser githubUserRoom) {
        if (githubUserRoom != null) {
            githubUserDao.insert(githubUserRoom);
        }
    }

    public void update(GithubUser githubUserRoom) {

        if(githubUserRoom!=null){
        githubUserDao.update(githubUserRoom);
        }
    }

    public void delete(GithubUser githubUser) {
        if (githubUser != null) {
            githubUserDao.delete(githubUser);
        }
    }

    public List<GithubUser> getAll() {
        return githubUserDao.getAll();
    }

    public GithubUser getById(long id) {

        return githubUserDao.getById(id);
    }

    public GithubUser getByLogin(String login) {
        return githubUserDao.getByLogin(login);
    }


}
