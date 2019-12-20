package com.sonukgupta72.daggerdemoapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sonukgupta72.daggerdemoapplication.fragment.ShowListViewModel
import com.sonukgupta72.daggerdemoapplication.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(ShowListViewModel::class)
    protected abstract fun movieListViewModel(moviesListViewModel: ShowListViewModel): ViewModel
}