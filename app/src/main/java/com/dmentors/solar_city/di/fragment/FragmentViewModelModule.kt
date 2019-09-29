package com.dmentors.solar_city.di.fragment

import androidx.lifecycle.ViewModelProviders
import com.dmentors.solar_city.di.ViewModelFactory
import com.dmentors.solar_city.presentation.blog.BlogFragment
import com.dmentors.solar_city.presentation.blog.BlogViewModel
import com.dmentors.solar_city.presentation.chat.ChatFragment
import com.dmentors.solar_city.presentation.chat.ChatViewModel
import com.dmentors.solar_city.presentation.chat.ChatsFragment
import com.dmentors.solar_city.presentation.chat.ChatsViewModel
import com.dmentors.solar_city.presentation.profile.ProfileFragment
import com.dmentors.solar_city.presentation.profile.ProfileViewModel
import com.dmentors.solar_city.presentation.recommendation.RecommendationFragment
import com.dmentors.solar_city.presentation.recommendation.RecommendationViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentViewModelModule {

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

    @Provides
    fun provideChatsViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ChatsFragment
    ): ChatsViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ChatsViewModel::class.java)

    @Provides
    fun provideChatViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: ChatFragment
    ): ChatViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(ChatViewModel::class.java)

    @Provides
    fun provideRecommendationViewModel(
        viewModelFactory: ViewModelFactory,
        fragment: RecommendationFragment
    ): RecommendationViewModel =
        ViewModelProviders.of(fragment, viewModelFactory).get(RecommendationViewModel::class.java)
}