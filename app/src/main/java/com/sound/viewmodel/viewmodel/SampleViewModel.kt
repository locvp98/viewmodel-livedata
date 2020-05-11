package com.sound.viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class SampleViewModel:ViewModel() {

    private var listData : ArrayList<String>?=null

    init {
        listData = ArrayList()
        listData?.add("liveData")
        listData?.add("ViewModel")
        listData?.add("RoomDatabase")
    }


    private val liveData = MutableLiveData<ArrayList<String>>()

    val badgeCount: LiveData<ArrayList<String>>
        get() = liveData

    fun incrementBadgeCount(){
        liveData.postValue(listData)
    }

    override fun onCleared() {
        super.onCleared()
    }
}