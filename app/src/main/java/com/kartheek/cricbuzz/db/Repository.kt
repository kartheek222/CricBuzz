package com.kartheek.cricbuzz.db

import android.os.AsyncTask
import com.kartheek.cricbuzz.db.entity.User
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class Repository() {

    val database: CricDB? = null;

//    fun insertUser(user: User): Maybe<Int> {
//        return database?.getUserDao()!!.insertUser(user);
//    }

//    fun deleteUsers(userId: String) {
//        AsyncTask.execute {
//            database?.getUserDao()!!.deleteAllUsers();
//        }
//
//    }


//    fun getUserById(userId: String, callback: Callback<Int,Throwable>?) {
//        insertUser(User("", "", "")).
//            observeOn(AndroidSchedulers.mainThread()).
//            subscribeOn(Schedulers.io()).subscribe({
//            callback?.onSuccess(it);
//        }, {
//            callback?.onError(it)
//        }, {
//            callback?.onComplete();
//        })
//    }

}

interface Callback<R,T>{
    fun onSuccess(result:R);
    fun onError(result:T);
    fun onComplete();
}
