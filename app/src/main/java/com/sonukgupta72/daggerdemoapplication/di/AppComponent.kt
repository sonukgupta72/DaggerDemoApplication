package com.sonukgupta72.daggerdemoapplication.di

import android.app.Application
import android.os.Binder
import com.sonukgupta72.daggerdemoapplication.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import java.security.AccessController
import javax.inject.Singleton

@Singleton
@Component (modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ApiModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}