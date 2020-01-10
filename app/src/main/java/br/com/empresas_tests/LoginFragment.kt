package br.com.empresas_tests

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import br.com.empresas_tests.util.ToolbarConfiguration
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        (activity as AppActivity).updateToolbar(
            ToolbarConfiguration(
                hide = true
            )
        )

        viewModel.emailValidLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.verifyLoginReady()
        })

        viewModel.passwordValidLiveData.observe(viewLifecycleOwner, Observer {
            viewModel.verifyLoginReady()
        })

        viewModel.loginButtonEnableLiveData.observe(viewLifecycleOwner, Observer {
            enterBtn.isEnabled = it
        })

        emailEdt.doOnTextChanged { text, _, _, _ ->
            text?.let {
                viewModel.emailTextChanged(it.toString())
            }
        }

        passwordEdt.doOnTextChanged { text, _, _, _ ->
            text?.let {
                viewModel.passwordTextChanged(it.toString())
            }
        }
    }

}
