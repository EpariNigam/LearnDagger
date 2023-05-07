package com.nigam.learndagger.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        doInjection()
        super.onCreate(savedInstanceState)
        binding = initializeBinding()
        setContentView(binding.root)
        initView()
        bindListeners()
        observeLiveData()
    }

    abstract fun initializeBinding(): VB

    abstract fun bindListeners()

    abstract fun doInjection()

    abstract fun observeLiveData()

    abstract fun initView()
}
