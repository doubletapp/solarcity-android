package com.dmentors.solar_city.presentation.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseActivity
import com.dmentors.solar_city.base.BaseFragment
import com.dmentors.solar_city.presentation.main.MainActivity
import com.dmentors.solar_city.presentation.signIn.SignInViewModel
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : BaseFragment<TestViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_test

    override fun initViews() {
        testPrevBtn.setOnClickListener {
            testPrevBtn.visibility = View.GONE
            testSecondStep.visibility = View.GONE
            testFirstStep.visibility = View.VISIBLE
            testNextBtn.text = "Следующий шаг"
        }

        testNextBtn.setOnClickListener {
            if (testPrevBtn.visibility == View.VISIBLE) {
                testFakeDialog.visibility = View.VISIBLE
                testFakeDialogNotNowBtn.setOnClickListener {
                    viewModel.login("1111")
                }
            } else {
                testPrevBtn.visibility = View.VISIBLE
                testFirstStep.visibility = View.GONE
                testSecondStep.visibility = View.VISIBLE
                testNextBtn.text = "Завершить тест"
            }
        }
    }

    override fun subscribeToViewModel() {
        super.subscribeToViewModel()
        viewModel.loginData.observe(this, Observer {
            when (it) {
                true -> {
                    context?.let {
                        MainActivity.start(it)
                        activity?.finish()
                    }
                }
            }
        })
    }
}