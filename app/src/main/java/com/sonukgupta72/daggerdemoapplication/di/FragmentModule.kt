package com.sonukgupta72.daggerdemoapplication.di

import com.sonukgupta72.daggerdemoapplication.fragment.ShowListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeShowListFragment(): ShowListFragment
}