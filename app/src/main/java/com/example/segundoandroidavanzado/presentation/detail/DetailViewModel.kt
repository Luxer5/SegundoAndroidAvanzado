package com.example.segundoandroidavanzado.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.useCase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
): ViewModel() {
    //private val hero = getDetailUseCase.invoke()

    private var _hero = MutableLiveData<HeroModel>()

    val hero: LiveData<HeroModel> get() = _hero

    fun getHero(id:String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getDetailUseCase.invoke(id)
            }
            _hero.value = result
        }
    }
}