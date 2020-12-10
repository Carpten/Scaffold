package com.example.scaffold.dagger

import androidx.lifecycle.ViewModelProvider
import com.example.scaffold.pages.splash.SplashActivity
import com.example.scaffold.pages.splash.SplashViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class SplashModule(val splashActivity: SplashActivity) {

    @Provides
    @Singleton
    fun provideUser(): SplashViewModel {
        return ViewModelProvider(splashActivity).get(SplashViewModel::class.java)
    }

}