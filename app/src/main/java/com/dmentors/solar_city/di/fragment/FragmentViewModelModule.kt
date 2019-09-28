package com.dmentors.solar_city.di.fragment

import androidx.lifecycle.ViewModelProviders
import com.dmentors.solar_city.di.ViewModelFactory
import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.blog.BlogViewModel
import com.dmentors.solar_city.presentation.just.JustViewModel
import com.dmentors.solar_city.presentation.just.JustFragment
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import com.dmentors.solar_city.presentation.profile.ProfileViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelModule {

    @Provides
    fun provideJustViewModel(
        viewModelFactory: ViewModelFactory,
        justFragment: JustFragment
    ): JustViewModel =
        ViewModelProviders.of(justFragment, viewModelFactory).get(JustViewModel::class.java)

    @Provides
    fun provideProfileViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ProfileFragment
    ): ProfileViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ProfileViewModel::class.java)

    @Provides
    fun provideBlogViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: BlogFragment
    ): BlogViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(BlogViewModel::class.java)
}