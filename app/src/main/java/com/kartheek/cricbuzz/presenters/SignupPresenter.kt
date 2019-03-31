package com.kartheek.cricbuzz.presenters

import android.text.TextUtils
import com.kartheek.cricbuzz.CricApp
import com.kartheek.cricbuzz.db.dao.UserDao
import com.kartheek.cricbuzz.db.entity.User
import com.kartheek.cricbuzz.views.IView
import javax.inject.Inject

class SignupPresenter() {

    constructor(view: IView.SignupView) : this() {
        this.signupView = view;
        CricApp.cricAppComponent.inject(this);
    }

    lateinit var signupView: IView.SignupView;

    @Inject
    lateinit var userDao: UserDao;

    public fun signupUser(name: String, userName: String, password: String) {
        if (!isValidUsername(userName)) {
            signupView.showUsernameError("Please enter a valid username");
            return;
        }

        if (!isValidPassword(password)) {
            signupView.showPasswordError("Please enter a valid password");
            return;
        }
        if (!isValidName(name)) {
            signupView.showNameError("Please enter a valid name");
            return;
        }
        val user = User(userName,name,password);
        userDao.insertUser(user);
        signupView.onSuccess();
    }

    private fun isValidUsername(username: String): Boolean {
        return !TextUtils.isEmpty(username)
    }

    private fun isValidPassword(password: String): Boolean {
        return !TextUtils.isEmpty(password)
    }

    private fun isValidName(name: String): Boolean {
        return !TextUtils.isEmpty(name)
    }


}
