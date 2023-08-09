package com.wookgenie.android_design_pattern_mvvm.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * BaseViewModel
 * @author wookjin
 * @since 2023/06/14
 **/
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val AndroidViewModel.context: Context
        get() = getApplication<Application>().applicationContext

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    protected fun showProgress() {
        _isLoading.value = true
    }

    protected fun hideProgress() {
        _isLoading.value = false
    }
}