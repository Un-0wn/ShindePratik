package com.example.shindepratik.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.shindepratik.databinding.FragmentDashboardBinding
import com.example.shindepratik.ui.home.HomeViewModel
import com.example.shindepratik.ui.home.UserPagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var unkAdapter: UnkPagingAdapter
    private val viewModel: HomeViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.wtf("LifeCycle","Dashboard:onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.wtf("LifeCycle","Dashboard:onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        Log.wtf("LifeCycle","Dashboard:onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.wtf("LifeCycle","Dashboard:onViewCreated")
        unkAdapter = UnkPagingAdapter()
        binding.apply {
            rvUser.adapter = unkAdapter
        }
        lifecycleScope.launchWhenStarted {
            viewModel.getUnknown.collectLatest {

                Log.wtf("User", it.toString())
                unkAdapter.submitData(it)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Log.wtf("LifeCycle","Dashboard:onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.wtf("LifeCycle","Dashboard:onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.wtf("LifeCycle","Dashboard:onDestory")
        _binding = null
    }
}