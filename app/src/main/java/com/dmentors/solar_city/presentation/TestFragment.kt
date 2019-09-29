package com.dmentors.solar_city.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseActivity
import com.dmentors.solar_city.presentation.main.MainActivity
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_test, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                    MainActivity.start(activity as BaseActivity<*>)
                    activity?.finish()
                }
            } else {
                testPrevBtn.visibility = View.VISIBLE
                testFirstStep.visibility = View.GONE
                testSecondStep.visibility = View.VISIBLE
                testNextBtn.text = "Завершить тест"
            }
        }
    }
}