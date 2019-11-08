package br.com.empresas_tests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun validEmailPattern_isEmail() {
        assertFalse(viewModel.validIsNotEmailPattern("email@gmail.com"))
    }

    @Test
    fun validEmailPattern_isEmail_subDomain() {
        assertFalse(viewModel.validIsNotEmailPattern("email@gmail.com.br"))
    }

    @Test
    fun validEmailPattern_isNotEmail() {
        assertTrue(viewModel.validIsNotEmailPattern("email"))
    }

    @Test
    fun validEmailPattern_isNotEmail_blank() {
        assertTrue(viewModel.validIsNotEmailPattern(""))
    }

    @Test
    fun validEmailPattern_isNotEmail_whiteSpace() {
        assertTrue(viewModel.validIsNotEmailPattern("   "))
    }

    @Test
    fun validEmailPattern_isNotEmail_whiteSpaceValid() {
        assertTrue(viewModel.validIsNotEmailPattern("  email@gmail.com "))
    }

    @Test
    fun validTextBlank_True(){
        assertTrue(viewModel.textIsBlank("   "))
    }

    @Test
    fun validTextBlank_False(){
         assertFalse(viewModel.textIsBlank("asdadqf"))
    }
}