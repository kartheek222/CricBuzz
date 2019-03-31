package com.kartheek.cricbuzz

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.kartheek.cricbuzz.component.AppModule
import com.kartheek.cricbuzz.component.CricAppComponent
import com.kartheek.cricbuzz.component.DaggerCricAppComponent
import com.kartheek.cricbuzz.component.RoomModule
import com.kartheek.cricbuzz.db.CricDB


class CricApp : Application() {


    companion object {
        public lateinit var cricAppComponent: CricAppComponent

    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);

         cricAppComponent = DaggerCricAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .roomModule(RoomModule(applicationContext))
            .build();
    }

    fun getApplication() : Context{
        return this;
    }

}
