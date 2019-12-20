package com.sonukgupta72.daggerdemoapplication.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    internal fun provideContext(context: Context): Context {
        return context
    }

}