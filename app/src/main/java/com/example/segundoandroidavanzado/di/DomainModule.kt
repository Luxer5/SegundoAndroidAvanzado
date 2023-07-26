package com.example.segundoandroidavanzado.di

import com.example.segundoandroidavanzado.domain.useCase.GetDetailUseCase
import com.example.segundoandroidavanzado.domain.useCase.GetHeroListUseCase
import com.example.segundoandroidavanzado.domain.useCase.GetHeroLocationUseCase
import org.koin.dsl.module

val domainModule  = module {

    single { GetHeroListUseCase(get()) }

    single { GetDetailUseCase(get()) }

    single { GetHeroLocationUseCase(get()) }

}