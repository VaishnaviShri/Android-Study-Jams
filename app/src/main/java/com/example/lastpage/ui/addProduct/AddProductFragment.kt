package com.example.lastpage.ui.addProduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lastpage.R
import com.example.lastpage.database.MainDatabase
import com.example.lastpage.databinding.FragmentAddProductBinding

class AddProductFragment : Fragment() {

    companion object {
        fun newInstance() = AddProductFragment()
    }

    private lateinit var viewModel: AddProductViewModel
    private lateinit var binding: FragmentAddProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_product, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addProductButton.setOnClickListener {
            val name = binding.productNameET.text.toString()
            val price = binding.productPriceET.text.toString().toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                viewModel.addProduct(name, price)
            }

            binding.productNameET.setText("")
            binding.productPriceET.setText("")
            binding.addProductButton.setOnClickListener {
                findNavController().navigate(R.id.navigate_to_home)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val application = requireNotNull(activity).application
        val dataSource = MainDatabase.getInstance(application).mainDao

        val vm: AddProductViewModel by viewModels { AddProductViewModelFactory(dataSource = dataSource) }
        viewModel = vm
    }
}