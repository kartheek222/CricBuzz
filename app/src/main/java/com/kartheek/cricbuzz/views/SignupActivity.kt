package com.kartheek.cricbuzz.views

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.kartheek.cricbuzz.R
import com.kartheek.cricbuzz.presenters.SignupPresenter
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity(), IView.SignupView {

    val presenter = SignupPresenter(this);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
    }

    private fun initViews() {
        tvSubmit.setOnClickListener(View.OnClickListener {
            presenter.signupUser(
                etName.text.toString(), etUsername.text.toString(),
                etpassword.text.toString()
            );
        })
    }

    override fun onSuccess() {
        Toast.makeText(applicationContext, "You have successfully signed up.", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            finish();
        }, 2000);
    }

    override fun onError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun showUsernameError(errorMsg: String) {
        etUsername.setError(errorMsg);
    }

    override fun showPasswordError(errorMsg: String) {
        etpassword.setError(errorMsg);
    }

    override fun showNameError(errorMsg: String) {
        etName.setError(errorMsg);
    }

    override fun removeErrors() {
        etUsername.setError(null)
        etpassword.setError(null)
    }
}


