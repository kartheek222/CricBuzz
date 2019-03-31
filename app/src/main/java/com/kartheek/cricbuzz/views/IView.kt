package com.kartheek.cricbuzz.views

interface IView{
    interface LoginView{
        fun onSuccess();

        fun onError(errorMsg : String);

        fun showUsernameError(errorMsg : String);

        fun showPasswordError(errorMsg : String);

        fun removeErrors();
    }

    interface SignupView{
        fun onSuccess();

        fun onError(errorMsg : String);

        fun showUsernameError(errorMsg : String);

        fun showPasswordError(errorMsg : String);

        fun showNameError(errorMsg : String);

        fun removeErrors();
    }

}
