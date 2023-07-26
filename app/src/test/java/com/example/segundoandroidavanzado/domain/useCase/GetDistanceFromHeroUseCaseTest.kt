package com.example.segundoandroidavanzado.domain.useCase

import com.example.segundoandroidavanzado.domain.model.LocationModel
import org.junit.Assert.*
import org.junit.Test

class GetDistanceFromHeroUseCaseTest {

    private val losAngelesNewYorkDistance = 3937

    @Test
    fun `test distance between points`(){
        val useCase = GetDistanceFromHeroUseCase()
        val newYork = LocationModel(latitud = 40.748817, longitud = -73.985428)
        val losAngeles = LocationModel(latitud = 34.052235, longitud = -118.243683)

        val res = useCase.invoke(newYork,losAngeles)
        assertEquals(res.toInt(), losAngelesNewYorkDistance)
    }
}