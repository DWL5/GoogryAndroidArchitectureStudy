package com.test.androidarchitecture.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    protected val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}