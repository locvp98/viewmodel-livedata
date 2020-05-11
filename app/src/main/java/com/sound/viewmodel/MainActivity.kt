package com.sound.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sound.viewmodel.adapter.ViewPageAdapter
import com.sound.viewmodel.fragment.Fragment1
import com.sound.viewmodel.fragment.Fragment2
import com.sound.viewmodel.fragment.Fragment3
import com.sound.viewmodel.viewmodel.SampleViewModel
import com.sound.viewmodel.viewmodel.SampleViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var viewModel: SampleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createViewModel()
        observeViewModel()
        initListeners()
        createFragment()
    }

    private fun createFragment() {
        viewpager.offscreenPageLimit = 5
        val myViewPageStateAdapter = ViewPageAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(Fragment1(), "tab1")
        myViewPageStateAdapter.addFragment(Fragment2(), "tab2")
        myViewPageStateAdapter.addFragment(Fragment3(), "tab3")
        viewpager.adapter = myViewPageStateAdapter
        viewpagertab.setupWithViewPager(viewpager)
    }

    private fun initListeners() {
        btnListener.setOnClickListener {
            viewModel?.incrementBadgeCount()
        }
    }

    private fun observeViewModel() {
        viewModel?.badgeCount?.observe(this, Observer {
            showToast(it[0])
        })
    }

    /**
     * ViewModelFactory: ViewModel nhận tham số chuyền vào
     * không nhân vào tham số{
     * viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)
     * }
     */
    private fun createViewModel() {
        val factory = SampleViewModelFactory("sample")
        viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)
    }

    private fun showToast(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }
}
