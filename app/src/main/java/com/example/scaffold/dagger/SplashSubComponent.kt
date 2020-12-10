package com.example.scaffold.dagger

import com.example.scaffold.pages.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SplashModule::class])
interface SplashSubComponent {

    fun inject(activity: SplashActivity)
}