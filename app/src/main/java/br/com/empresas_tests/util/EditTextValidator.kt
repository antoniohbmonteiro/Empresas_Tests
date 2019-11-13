package br.com.empresas_tests.util

import androidx.core.util.PatternsCompat

object EditTextValidator {

    fun validEmailPattern(text: String): Boolean =
        PatternsCompat.EMAIL_ADDRESS.matcher(text).matches()

    fun textIsBlank(text: String) =
        text.isBlank()
}