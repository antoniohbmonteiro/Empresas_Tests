package br.com.empresas_tests

import android.service.autofill.Validators.and
import android.util.Patterns
import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var emailValidLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var passwordValidLiveData: MutableLiveData<Boolean> = MutableLiveData()

    var loginButtonEnableLiveData: MutableLiveData<Boolean> = MutableLiveData(false)

    fun emailTextChanged(text: String) {
        val valid = validEmailEditText(text)

        emailValidLiveData.value = valid
    }

    fun passwordTextChanged(text: String) {
        val valid = validPasswordEditText(text)
        passwordValidLiveData.value = valid
    }

    fun verifyLoginReady() {
        val loginReady =
            (emailValidLiveData.value ?: false) && (passwordValidLiveData.value ?: false)

        loginButtonEnableLiveData.value = loginReady
    }

    private fun validEmailEditText(emailText: String): Boolean {
        var isValid = true

        if (textIsBlank(emailText)) {
            isValid = false
        } else if (validIsNotEmailPattern(emailText)) {
            isValid = false
        }

        return isValid
    }

    fun textIsBlank(text: String): Boolean{
        return text.isBlank()
    }

    private fun validPasswordEditText(passwordText: String): Boolean {
        var isValid = true

        if (textIsBlank(passwordText))
            isValid = false

        return isValid
    }

    fun validIsNotEmailPattern(emailText: String): Boolean {
        return !PatternsCompat.EMAIL_ADDRESS.matcher(emailText).matches()
    }

}
