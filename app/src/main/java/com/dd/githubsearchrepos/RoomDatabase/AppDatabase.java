package com.dd.githubsearchrepos.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dd.githubsearchrepos.ServerClasses.GithubUser;

@Database(entities = {GithubUser.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GithubUserDao githubUserDao();
}

