package com.joydeep.fragmenttest

import android.util.Log
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    init {
        Log.d("TAG", "FragmentViewModel init called $this")
    }

    override fun onCleared() {
        Log.d("TAG", "FragmentViewModel onCleared called")
        super.onCleared()
    }

    fun showToast() {
        Log.d("TAG", "FragmentViewModel instance $this")
    }
}