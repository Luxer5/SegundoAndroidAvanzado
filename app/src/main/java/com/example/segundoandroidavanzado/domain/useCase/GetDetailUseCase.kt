package com.example.segundoandroidavanzado.domain.useCase

import com.example.segundoandroidavanzado.data.HeroRepository

class GetDetailUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String) = heroRepository.getHeroById(id)

}