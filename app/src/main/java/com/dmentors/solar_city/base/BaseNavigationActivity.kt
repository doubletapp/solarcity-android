package com.dmentors.solar_city.base

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.dmentors.solar_city.R
import com.dmentors.solar_city.presentation.blog.BlogFragment
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.titlebar.*

abstract class BaseNavigationActivity<T : BaseViewModel> : BaseActivity<T>() {

    companion object {
        private const val BACK_STACK = "back_stack"
    }

    protected abstract fun getFragment(): Fragment
    protected open fun getFragmentContainerId(): Int = R.id.fragment_container

    override fun getLayoutId(): Int = R.layout.activity_navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(getFragmentContainerId(), BlogFragment.newInstance())
                .addToBackStack(BACK_STACK)
                .commit()
        }
        titlebarMenu.setOnClickListener {
            onMenuClicked()
        }
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }

    fun replaceFragment(fragment: Fragment, containerId: Int, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerId, fragment, tag)
            .addToBackStack(BACK_STACK)
            .commit()
    }

    protected fun onMenuClicked() {
        if (navigationDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeDrawer()
        } else {
            openDrawer()
        }
    }

    protected fun closeDrawer() {
        navigationDrawerLayout.closeDrawer(GravityCompat.START)
    }

    protected fun openDrawer() {
        navigationDrawerLayout.openDrawer(GravityCompat.START)
    }

    protected fun blockDrawer() {
        navigationDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

    protected fun unBlockDrawer() {
        navigationDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN)
    }
}