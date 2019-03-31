package com.kartheek.cricbuzz.presenters

import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.kartheek.cricbuzz.CricApp
import com.kartheek.cricbuzz.db.CricDB
import com.kartheek.cricbuzz.db.dao.UserDao
import com.kartheek.cricbuzz.db.entity.User
import com.kartheek.cricbuzz.views.IView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class LoginPresenter() {

    internal var disposable = CompositeDisposable()

    constructor(view: IView.LoginView) : this() {
        CricApp.cricAppComponent.inject(this)
        this.loginView=view;
    }

    private companion object {
        val TAG  = LoginPresenter::class.simpleName;
    }

     lateinit var  loginView :IView.LoginView;

    @Inject lateinit var username : String;

    @Inject lateinit var database : UserDao;

    private fun isValidLoginDetails(userName: String, password: String) {

    }

    public fun valideUser(userName: String, password: String){
        Log.d(TAG,"Username : "+username);
        if (!isValidUsername(userName)) {
            loginView.showUsernameError("Please enter a valid username");
        }

        if (!isValidPassword(password)) {
            loginView.showPasswordError("Please enter a valid password");
        }

        if (database == null) {
            Log.d(TAG,"DB is null")
        }else{
            val user = database?.getUserById(userName)
////                loginView.onSuccess();
//
            val singleObserver =   user.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<User?>() {
                    override fun onSuccess(users: User?) {
                        Log.d(TAG,"Got the user from DB "+users)
                            loginView.onSuccess();
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG,"Got the error when getting user from DB "+e)
                            loginView.onError("Please check your username or password")
                    }
                })

            disposable.add(singleObserver)

            Log.d(TAG,"DB is not null")
        }

    }

    private fun isValidUsername(username: String): Boolean {
        return !TextUtils.isEmpty(username)
    }

    private fun isValidPassword(password: String): Boolean {
        return !TextUtils.isEmpty(password)
    }


}
