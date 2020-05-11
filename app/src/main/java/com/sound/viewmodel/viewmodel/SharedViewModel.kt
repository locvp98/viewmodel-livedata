package com.sound.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {

    val livedata = MutableLiveData<String>()

    fun selectItem(item:String){
        livedata.value = item
    }
}