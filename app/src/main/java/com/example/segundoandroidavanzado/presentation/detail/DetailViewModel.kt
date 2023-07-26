package com.example.segundoandroidavanzado.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.model.LocationModel
import com.example.segundoandroidavanzado.domain.useCase.GetDetailUseCase
import com.example.segundoandroidavanzado.domain.useCase.GetHeroLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase,
    private val getHeroLocationUseCase: GetHeroLocationUseCase
): ViewModel() {
    //private val hero = getDetailUseCase.invoke()

    private var _hero = MutableLiveData<HeroModel>()
    private val _location = MutableLiveData<LocationModel>()

    val hero: LiveData<HeroModel> get() = _hero
    val location: LiveData<LocationModel> get() =_location



    fun getData(id:String){
        viewModelScope.launch {
            getHero(id)
            getLocation(id)
        }
    }

    private fun getLocation(id: String) = viewModelScope.launch {
        val result = withContext(Dispatchers.IO){
            getHeroLocationUseCase.invoke(id)
        }
        _location.value = result
    }

    private fun getHero(id: String) = viewModelScope.launch {
        val result = withContext(Dispatchers.IO){
            getDetailUseCase.invoke(id)
        }
        _hero.value = result
    }
}