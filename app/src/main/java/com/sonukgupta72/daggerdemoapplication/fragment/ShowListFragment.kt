package com.sonukgupta72.daggerdemoapplication.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sonukgupta72.daggerdemoapplication.R
import com.sonukgupta72.daggerdemoapplication.factory.ViewModelFactory
import com.sonukgupta72.daggerdemoapplication.network.ResponseModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.show_list_fragment.*
import javax.inject.Inject

class ShowListFragment : DaggerFragment() {

    companion object {
        fun newInstance() = ShowListFragment()
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ShowListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ShowListViewModel::class.java)

        viewModel.getResponseMutableLiveData().observe(this, Observer<ResponseModel> { onSuccess(it) })
        viewModel.getErrorMutableLiveData().observe(this, Observer<String> { onError(it) })
        viewModel.getApiResponse()
    }

    private fun onSuccess(responseModel: ResponseModel?) {
        tv_message.text = responseModel?.response
    }

    private fun onError(errorMessage: String?) {
        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show()
    }

}
