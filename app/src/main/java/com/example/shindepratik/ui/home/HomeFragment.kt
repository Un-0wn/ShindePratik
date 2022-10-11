package com.example.shindepratik.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.shindepratik.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var userAdapter: UserPagingAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.wtf("LifeCycle","Home:onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.wtf("LifeCycle","Home:onCreate")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.wtf("LifeCycle","Home:onCreateView")

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.wtf("LifeCycle","Home:onViewCreated")

        userAdapter = UserPagingAdapter()
        binding.apply {
            rvUser.adapter = userAdapter
        }
        lifecycleScope.launchWhenCreated {
            viewModel.user.collectLatest {

                Log.wtf("User", it.toString())
                userAdapter.submitData(it)
            }
        }
    }
    override fun onPause() {
        super.onPause()
        Log.wtf("LifeCycle","Home:onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.wtf("LifeCycle","Home:onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.wtf("LifeCycle","Home:onDestory")
        _binding = null
    }
}