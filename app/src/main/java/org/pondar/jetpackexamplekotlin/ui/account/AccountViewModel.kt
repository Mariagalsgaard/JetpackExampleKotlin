package org.pondar.jetpackexamplekotlin.ui.account

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import org.pondar.jetpackexamplekotlin.R
import org.pondar.jetpackexamplekotlin.models.Gender
import org.pondar.jetpackexamplekotlin.models.User
import org.pondar.jetpackexamplekotlin.tools.Utils.validate


class AccountViewModel(application: Application) : AndroidViewModel(application) {

    //user is for the signup part
    var user = User()

    // loginEmail and password is for the login for users who are already registered.
    var loginEmail = ""
    var loginPassword = ""
    var signupPassword = ""
    var signupPasswordRepeat = ""

    var loginOkay = MutableLiveData(false)


    fun signUp(view:View) {
        if (!validate(
                user.fullName, user.email, user.postalAdress, user.city,
                context = getApplication<Application>().applicationContext
            )
        )
            return

        if (signupPassword.equals(signupPasswordRepeat) && signupPassword.length >= 6)
            signUpWithEmailAndPasswordFirebase(user.email, signupPassword)
        else if (signupPassword.length < 6) {
            val toast = Toast.makeText(
                getApplication<Application>().applicationContext,
                R.string.invalid_password,
                Toast.LENGTH_LONG
            )
            toast.show()
        } else {
            val toast = Toast.makeText(
                getApplication<Application>().applicationContext,
                R.string.password_does_not_match,
                Toast.LENGTH_LONG
            )
            toast.show()
        }

    }

    //Add the User object to firestore document.
    private fun addUserToFirebase() {

    }

    fun signUpWithEmailAndPasswordFirebase(email: String, password: String) {
        Log.d("signup"," With user = $user")

    }

    fun login(view: View) {
        Log.d("login","login pressed : user $loginEmail - pword: $loginPassword")
        if (!validate(loginEmail, loginPassword,context = getApplication<Application>().applicationContext))
            return
        else
            loginOkay.value=true

    }


    fun handleRadioClick(radioGroup: RadioGroup?, id: Int) {
        Log.d("handle radioclick"," id clicked: $id")
        if (id == R.id.account_radiobutton_female)
            user.gender = Gender.Female
        else if (id == R.id.account_radiobutton_male)
            user.gender = Gender.Male
    }


}