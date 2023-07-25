package com.example.segundoandroidavanzado.domain.model

class TestDataBuilder() {
    var id = ""
    var name = ""
    var photoUrl = ""
    var description = ""
    var numElements: Int = 1

    fun withName(name: String): TestDataBuilder{
        this.name =  name
        return  this
    }
    fun withPhotoUrl(photoUrl: String): TestDataBuilder{
        this.photoUrl =  photoUrl
        return  this
    }
    fun withNumElements(numElements: Int): TestDataBuilder{
        this.numElements =  numElements
        return  this
    }

    fun build():List<HeroModel>{
        val list = mutableListOf<HeroModel>()
        for(i in 0 .. numElements){
            list.add(HeroModel(id,name, photoUrl, description))
        }
        return list.toList()
    }

}