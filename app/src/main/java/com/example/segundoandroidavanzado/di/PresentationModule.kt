package com.example.segundoandroidavanzado.di

import com.example.segundoandroidavanzado.presentation.detail.DetailViewModel
import com.example.segundoandroidavanzado.presentation.list.ListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val pesentationModule = module{
    viewModel{ ListFragmentViewModel(get(), get()) }

    viewModelOf(::ListFragmentViewModel)

    viewModel{ DetailViewModel(get(), get(), get(), get()) }
    viewModelOf(::DetailViewModel)


}