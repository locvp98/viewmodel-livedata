package com.sound.viewmodel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sound.viewmodel.R
import com.sound.viewmodel.viewmodel.SampleViewModel
import com.sound.viewmodel.viewmodel.SharedViewModel

class Fragment2 : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            viewModel = (activity?.let {
                ViewModelProvider(it).get(SharedViewModel::class.java)
            } ?: throw Exception("Activity is null"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_layout_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.livedata.observe(this, Observer {
            Toast.makeText(activity!!, it, Toast.LENGTH_LONG).show()
        })
    }
}