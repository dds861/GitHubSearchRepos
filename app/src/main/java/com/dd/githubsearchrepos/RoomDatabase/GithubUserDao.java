package com.dd.githubsearchrepos.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dd.githubsearchrepos.ServerClasses.GithubUser;

import java.util.List;

@Dao
public interface GithubUserDao {

    @Query("SELECT * FROM githubUser")
    List<GithubUser> getAll();

    @Query("SELECT * FROM githubUser WHERE id = :id")
    GithubUser getById(long id);

    @Query("SELECT * FROM githubUser WHERE login = :login")
    GithubUser getByLogin(String login);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GithubUser githubUser);

    @Update
    void update(GithubUser githubUser);

    @Delete
    void delete(GithubUser githubUser);
}
