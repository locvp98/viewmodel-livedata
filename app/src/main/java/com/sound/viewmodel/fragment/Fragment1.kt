package com.sound.viewmodel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sound.viewmodel.R
import com.sound.viewmodel.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_layout_one.*

class Fragment1 : Fragment() {
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
        return layoutInflater.inflate(R.layout.fragment_layout_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listener()
    }

    private fun listener() {
        btnSenTitle.setOnClickListener {
            viewModel.selectItem("New Item posted")
        }
    }
}