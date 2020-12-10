package com.example.scaffold.pages.index

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.scaffold.R

class IndexActivity : AppCompatActivity() {

    lateinit var viewModel: IndexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        viewModel = ViewModelProvider(this).get(IndexViewModel::class.java)
    }
}