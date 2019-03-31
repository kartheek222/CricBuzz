package com.kartheek.cricbuzz.component

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kartheek.cricbuzz.network.CricAPI
import com.kartheek.cricbuzz.utilities.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule{
    @Provides
    fun provideCricApiClient(): CricAPI {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().baseUrl(Constants.BASE_URL_CRIC)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build().create(CricAPI::class.java)
    }
}
