package com.kartheek.cricbuzz.component

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var context: Context){

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    fun getUsename() = "Hello"


}