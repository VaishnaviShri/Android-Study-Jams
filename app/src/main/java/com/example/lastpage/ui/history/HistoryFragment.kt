package com.example.lastpage.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lastpage.database.MainDatabase
import com.example.lastpage.databinding.FragmentHistoryBinding
import com.example.lastpage.ui.home.HomeViewModelFactory
import com.example.lastpage.ui.home.OrderRecyclerViewAdapter

class HistoryFragment : Fragment() {

    private lateinit var mHistoryViewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(activity).application
        val dataSource = MainDatabase.getInstance(application).mainDao

        val viewModel: HistoryViewModel by viewModels { HistoryViewModelFactory(dataSource = dataSource) }

        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.orderList.observe(viewLifecycleOwner, {
            with(_binding!!.ordersRecyclerview) {
                adapter = OrderRecyclerViewAdapter(it) { /* DO NOTHING */ }
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}