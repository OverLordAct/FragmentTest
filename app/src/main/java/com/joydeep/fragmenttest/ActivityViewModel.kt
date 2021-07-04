package com.joydeep.fragmenttest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    val livedData = MutableLiveData<String>()

    init {
        Log.d("TAG", "ActivityViewModel init called $this")
    }

    override fun onCleared() {
        Log.d("TAG", "ActivityViewModel onCleared called")
        super.onCleared()
    }

    fun showToast() {
        Log.d("TAG", "ActivityViewModel instance $this")
        livedData.value = "ViewModel instance $this"
    }
}