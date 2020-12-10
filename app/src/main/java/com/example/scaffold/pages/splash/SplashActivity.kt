package com.example.scaffold.pages.splash

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.scaffold.R
import com.example.scaffold.dagger.DaggerSplashComponent
import com.example.scaffold.dagger.SplashModule
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DaggerSplashComponent.builder().splashModule(SplashModule(this)).build().inject(this)
        viewModel.test.observe(this, Observer {
            tvContent.text = it
        })

//        startActivity(Intent(this, IndexActivity::class.java))


    }
}