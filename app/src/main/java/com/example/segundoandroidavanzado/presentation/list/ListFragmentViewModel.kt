package com.example.segundoandroidavanzado.presentation.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoandroidavanzado.R
import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.useCase.GetHeroListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException


class ListFragmentViewModel(
    private val context: Context,
    private val getHeroListUseCase: GetHeroListUseCase
) : ViewModel() {
    private var _heroList = MutableLiveData<List<HeroModel>>()

    val heroList: LiveData<List<HeroModel>> get() = _heroList

    //Live Data para infroamr de la infroamcion a la vista

    private var _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    fun getData() {
        //Scope
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getHeroListUseCase.invoke()
                }
                _heroList.value = result
            } catch (unknown: UnknownHostException){
                _errorMessage.value = "Error de Host"
            } catch (t: Throwable) {
                //context.getString(R.string.error_message)
                _errorMessage.value = context.getString(R.string.error_message)
            }
        }
    }
}
