package com.kartheek.cricbuzz.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kartheek.cricbuzz.R
import com.kartheek.cricbuzz.component.AppModule
import com.kartheek.cricbuzz.component.RoomModule
import com.kartheek.cricbuzz.presenters.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, IView.LoginView {

    var presenter : LoginPresenter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this);


        initViews();
    }

    private fun initViews() {
        tvForgotPassword.setOnClickListener(this);
        tvSignup.setOnClickListener(this);
        tvSubmit.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            tvForgotPassword -> {

            }
            tvSignup -> {
                startActivity(Intent(this,SignupActivity::class.java));
            }
            tvSubmit -> {
                presenter?.valideUser(etUsername.text.toString(),etpassword.text.toString());
            }

        }
    }

    override fun onSuccess() {
        Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_SHORT).show();
    }

    override fun onError(errorMsg : String) {
        Toast.makeText(applicationContext,errorMsg,Toast.LENGTH_SHORT).show();
    }

    override fun showUsernameError(errorMsg : String) {
        etUsername.setError(errorMsg);
    }

    override fun showPasswordError(errorMsg : String) {
        etpassword.setError(errorMsg);
    }

    override fun removeErrors() {
        etUsername.setError("");
        etpassword.setError("");
    }


}
