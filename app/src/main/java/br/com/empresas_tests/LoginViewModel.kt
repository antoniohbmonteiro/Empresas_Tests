package br.com.empresas_tests

import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.empresas_tests.util.EditTextValidator

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

        enableLoginButton(loginReady)
    }

    private fun enableLoginButton(loginReady: Boolean) {
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

    private fun validPasswordEditText(passwordText: String): Boolean {
        var isValid = true

        if (textIsBlank(passwordText))
            isValid = false

        return isValid
    }

    fun textIsBlank(text: String): Boolean {
        return EditTextValidator.textIsBlank(text)
    }

    fun validIsNotEmailPattern(emailText: String): Boolean {
        return !EditTextValidator.validEmailPattern(emailText)
    }

}
