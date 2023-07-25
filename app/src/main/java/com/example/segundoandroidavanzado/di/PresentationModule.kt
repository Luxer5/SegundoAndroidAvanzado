package com.example.segundoandroidavanzado.di

import com.example.segundoandroidavanzado.presentation.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val pesentationModule = module{
    viewModel{ ListFragmentViewModel(get(), get()) }

    viewModelOf(::ListFragmentViewModel)
}