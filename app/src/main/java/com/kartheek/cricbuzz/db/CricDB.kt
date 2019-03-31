package com.kartheek.cricbuzz.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Database
import android.arch.persistence.room.Entity
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.kartheek.cricbuzz.db.dao.UserDao
import com.kartheek.cricbuzz.db.entity.User
import android.arch.persistence.room.Room

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
public abstract class CricDB : RoomDatabase() {

    //TODO: Create a singleton objet for database



    abstract fun getUserDao() : UserDao;
}