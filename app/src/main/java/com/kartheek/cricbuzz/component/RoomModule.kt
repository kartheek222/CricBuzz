package com.kartheek.cricbuzz.component

import android.arch.persistence.room.Room
import android.content.Context
import com.kartheek.cricbuzz.db.CricDB
import com.kartheek.cricbuzz.db.dao.UserDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class RoomModule(var context: Context){

    private var INSTANCE: CricDB? = null

    @Provides
    fun getDatabase(): CricDB {
        if (INSTANCE == null) {
            synchronized(CricDB::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CricDB::class.java!!, "CricDB"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
        }
        return INSTANCE!!;
    }

    @Provides
    fun getUserDAO(cricDB : CricDB): UserDao {
        return cricDB.getUserDao();
    }

}
