package com.example.lastpage.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lastpage.R
import com.example.lastpage.database.MainDatabase
import com.example.lastpage.databinding.FragmentInventoryBinding
import com.example.lastpage.ui.inventory.InventoryViewModel
import com.example.lastpage.ui.inventory.ProductRecyclerViewAdapter

class InventoryFragment : Fragment() {

    private lateinit var mInventoryFragment : InventoryFragment
    private var _binding : FragmentInventoryBinding? =null
    private lateinit var mInventoryViewModel: InventoryViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mInventoryViewModel = ViewModelProvider(this).get(InventoryViewModel::class.java)
        _binding = FragmentInventoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val application = requireNotNull(activity).application
        val dataSource = MainDatabase.getInstance(application).mainDao


        mInventoryViewModel.productList.observe(viewLifecycleOwner, Observer {
            with(_binding!!.productsRecyclerview){
                adapter = ProductRecyclerViewAdapter(it)
            }
        })
        _binding!!.addProductButton.setOnClickListener {
            findNavController().navigate(R.id.navigate_to_add_product)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}