package com.example.segundoandroidavanzado.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ListFragmentViewModel(
        val getHeroListUseCase: GetHeroListUseCase
    ): ViewModel() {
        private var _heroList = MutableLiveData<List<HeroModel>>()

        val heroList: LiveData<List<HeroModel>> get() = _heroList

        fun getData(){
            //Scope
            viewModelScope.launch {
                val result = withContext(Dispatchers.IO){
                    getHeroListUseCase.invoke()
                }
                _heroList.value = result

            }
        }
    }
