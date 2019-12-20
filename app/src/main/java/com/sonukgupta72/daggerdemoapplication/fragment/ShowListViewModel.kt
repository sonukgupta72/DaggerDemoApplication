package com.sonukgupta72.daggerdemoapplication.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sonukgupta72.daggerdemoapplication.network.ApiService
import com.sonukgupta72.daggerdemoapplication.network.ResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ShowListViewModel @Inject constructor(val apiService: ApiService) : ViewModel() {

    private val responseMutableLiveData: MutableLiveData<ResponseModel> = MutableLiveData()
    private val errorMutableLiveData: MutableLiveData<String> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun getApiResponse() {
        compositeDisposable.add(
            apiService.getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) //import rxjava2
                .subscribe(this::onSuccess, this::onError)
        )
    }

    private fun onSuccess(responseModel: ResponseModel) {
        responseMutableLiveData.value = responseModel
    }

    private fun onError(throwable: Throwable) {
        errorMutableLiveData.value = throwable.message
    }

    fun getResponseMutableLiveData(): LiveData<ResponseModel> {
        return responseMutableLiveData
    }

    fun getErrorMutableLiveData(): LiveData<String> {
        return errorMutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
