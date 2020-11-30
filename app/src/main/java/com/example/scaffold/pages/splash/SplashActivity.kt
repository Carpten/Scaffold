package com.example.scaffold.pages.splash

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scaffold.R

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        setContentView(R.layout.activity_splash)
        viewModel.test.observe(this, Observer {
            Log.i("test", "test:" + it)
        })
        Handler().postDelayed({
            viewModel.test.value = "!23"
        }, 5000)
//        startActivity(Intent(this, IndexActivity::class.java))
    }
}