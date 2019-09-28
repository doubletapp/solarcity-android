package com.dmentors.solar_city.di.fragment

import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.chat.ChatFragment
import com.dmentors.solar_city.presentation.chat.ChatsFragment
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("unused")
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindBlogFragment(): BlogFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindChatsFragment(): ChatsFragment

    @ContributesAndroidInjector(modules = [FragmentViewModelModule::class])
    abstract fun bindChatFragment(): ChatFragment
}