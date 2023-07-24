package com.example.segundoandroidavanzado.domain.useCase

import com.example.segundoandroidavanzado.data.HeroRepository
import com.example.segundoandroidavanzado.domain.model.HeroModel

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke() = heroRepository.getHeroList()

}