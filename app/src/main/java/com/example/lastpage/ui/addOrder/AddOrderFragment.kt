package com.example.lastpage.ui.addOrder

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lastpage.R
import com.example.lastpage.database.MainDatabase
import com.example.lastpage.databinding.AddOrderFragmentBinding

class AddOrderFragment : Fragment() {

    companion object {
        fun newInstance() = AddOrderFragment()
    }

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
        val application = requireNotNull(activity).application
        val dataSource = MainDatabase.getInstance(application).mainDao

        val viewModel: AddOrderViewModel by viewModels { AddOrderViewModelFactory(dataSource = dataSource) }
        // TODO: Use the ViewModel
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.navigate_to_home)
            Log.v("button", "clicked")
        }

    }

}