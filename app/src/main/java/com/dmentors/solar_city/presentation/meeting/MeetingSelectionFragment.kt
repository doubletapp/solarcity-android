package com.dmentors.solar_city.presentation.meeting


import com.dmentors.solar_city.R
import com.dmentors.solar_city.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_meeting_type_selection.*

class MeetingSelectionFragment : BaseFragment<MeetingSelectionViewModel>() {

    companion object {
        fun newInstance(callback: MeetingCallback): MeetingSelectionFragment {
            val fragment = MeetingSelectionFragment()
            fragment.callback = callback
            return fragment
        }
    }

    private var callback: MeetingCallback? = null
    override fun getLayoutId(): Int = R.layout.fragment_meeting_type_selection

    override fun initViews() {
        meetingCreateNew.setOnClickListener {
            callback?.openAddNewScreen()
        }
    }

    override fun subscribeToViewModel() {

    }
}