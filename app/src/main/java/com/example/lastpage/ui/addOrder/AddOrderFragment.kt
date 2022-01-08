package com.example.lastpage.ui.addOrder

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lastpage.R
import com.example.lastpage.databinding.AddOrderFragmentBinding

class AddOrderFragment : Fragment() {

    companion object {
        fun newInstance() = AddOrderFragment()
    }

    private lateinit var viewModel: AddOrderViewModel
    private lateinit var binding: AddOrderFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_order_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddOrderViewModel::class.java)
        // TODO: Use the ViewModel
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

}