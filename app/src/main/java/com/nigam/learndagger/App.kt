package com.nigam.learndagger

import android.app.Application
import com.nigam.learndagger.di.AppComponent
import com.nigam.learndagger.di.DaggerAppComponent

class App : Application() {
    /**
     * App level component to make sure we create and inject single instance of database / preference
     */
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}