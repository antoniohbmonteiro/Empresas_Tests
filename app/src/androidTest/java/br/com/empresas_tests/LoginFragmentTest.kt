package br.com.empresas_tests

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.*
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Before
    fun init(){
        val appActivity: ActivityTestRule<AppActivity> = ActivityTestRule(AppActivity::class.java)
        appActivity.launchActivity(Intent())
    }

    @Test
    fun testTwoInputsShouldEnableTheButton(){
        onView(withId(R.id.emailEdt))
            .perform(typeText("antoniohbmonteiro@gmail.com"))

        onView(withId(R.id.passwordEdt))
            .perform(closeSoftKeyboard())
            .perform(typeText("123456"))

        onView(withId(R.id.enterBtn))
            .perform(closeSoftKeyboard())
            .check(matches(isEnabled()))
    }

    @Test
    fun testEmailWithSubDomainShouldEnableTheButton(){
        onView(withId(R.id.emailEdt))
            .perform(typeText("antoniohbmonteiro@gmail.com.br"))

        onView(withId(R.id.passwordEdt))
            .perform(closeSoftKeyboard())
            .perform(typeText("123456"))

        onView(withId(R.id.enterBtn))
            .perform(closeSoftKeyboard())
            .check(matches(isEnabled()))
    }

    @Test
    fun testEmailEmptyShouldNotEnableTheButton(){
        onView(withId(R.id.emailEdt))
            .perform(typeText(""))

        onView(withId(R.id.passwordEdt))
            .perform(closeSoftKeyboard())
            .perform(typeText("123456"))

        onView(withId(R.id.enterBtn))
            .perform(closeSoftKeyboard())
            .check(matches(not(isEnabled())))
    }

    @Test
    fun testPasswordEmptyShouldNotEnableTheButton(){
        onView(withId(R.id.emailEdt))
            .perform(typeText("antoniohbmonteiro@gmail.com"))

        onView(withId(R.id.passwordEdt))
            .perform(closeSoftKeyboard())
            .perform(typeText(""))

        onView(withId(R.id.enterBtn))
            .perform(closeSoftKeyboard())
            .check(matches(not(isEnabled())))
    }

    @Test
    fun testEmailPatternNotRightShouldNotEnableTheButton(){
        onView(withId(R.id.emailEdt))
            .perform(typeText("antoniohbmonteiro"))

        onView(withId(R.id.passwordEdt))
            .perform(closeSoftKeyboard())
            .perform(typeText("123456"))

        onView(withId(R.id.enterBtn))
            .perform(closeSoftKeyboard())
            .check(matches(not(isEnabled())))
    }

}