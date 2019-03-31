package com.kartheek.cricbuzz.component

import android.app.Application
import android.content.Context
import com.kartheek.cricbuzz.CricApp
import com.kartheek.cricbuzz.db.CricDB
import com.kartheek.cricbuzz.db.dao.UserDao
import com.kartheek.cricbuzz.presenters.LoginPresenter
import com.kartheek.cricbuzz.presenters.SignupPresenter
import com.kartheek.cricbuzz.views.LoginActivity
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, RoomModule::class))
interface CricAppComponent {

    fun inject(app: CricApp);

    fun inject(controller: LoginPresenter);

    fun inject(controller: LoginActivity);

    fun inject(controller: SignupPresenter);



    fun getDatabase(): CricDB;

    fun getUserDAO(): UserDao;

    fun provideContext(): Context
}
