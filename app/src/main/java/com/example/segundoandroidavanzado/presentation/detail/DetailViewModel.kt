package com.example.segundoandroidavanzado.presentation.detail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundoandroidavanzado.R
import com.example.segundoandroidavanzado.data.local.model.HeroLocal
import com.example.segundoandroidavanzado.domain.model.HeroModel
import com.example.segundoandroidavanzado.domain.model.LocationModel
import com.example.segundoandroidavanzado.domain.useCase.GetDetailUseCase
import com.example.segundoandroidavanzado.domain.useCase.GetDistanceFromHeroUseCase
import com.example.segundoandroidavanzado.domain.useCase.GetHeroLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val context: Context,
    private val getDetailUseCase: GetDetailUseCase,
    private val getHeroLocationUseCase: GetHeroLocationUseCase,
    private val getDistanceFromHeroUseCase: GetDistanceFromHeroUseCase
): ViewModel() {
    //private val hero = getDetailUseCase.invoke()

    private var _hero = MutableLiveData<HeroModel>()
    private val _location = MutableLiveData<String>()

    val hero: LiveData<HeroModel> get() = _hero
    val location: LiveData<String> get() =_location

    private var userLocation: LocationModel? = null
    private var heroLocation: LocationModel? = null


    fun setUserLocation(lat: Double, long: Double){
        userLocation = LocationModel(
            latitud = lat,
            longitud = long
        )
        showLocation()
    }

    private fun showLocation(){
        //Comprobar que tengo ambas ubicaciones
        //Unwrap
        userLocation?.let { userLocationSafe ->
            heroLocation?.let { heroLocationSafe ->

               val distance = getDistanceFromHeroUseCase.invoke(
                    userLocationSafe,
                    heroLocationSafe
                )
                _location.value = context.getString(R.string.user_location, distance.toString())
            }
        }

        //Devolver la distancia
        //_location.value = result
    }

    fun getData(id:String){
        viewModelScope.launch {
            getHero(id)
            getLocation(id)
        }
    }

    private fun getLocation(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO){
                getHeroLocationUseCase.invoke(id)
            }
            heroLocation = result
            showLocation()
        }catch (_: Throwable){} //Error silencioso
    }

    private fun getHero(id: String) = viewModelScope.launch {
        val result = withContext(Dispatchers.IO){
            getDetailUseCase.invoke(id)
        }
        _hero.value = result
    }

}