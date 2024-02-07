package com.example.test_8.presentation.screen

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.test_8.databinding.FragmentStatisticsBinding
import com.example.test_8.presentation.base.BaseFragment
import com.example.test_8.presentation.state.PlaceState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StatisticsFragment :
    BaseFragment<FragmentStatisticsBinding>(FragmentStatisticsBinding::inflate) {
    private val viewModel: StatisticsViewModel by viewModels()
    private lateinit var collectionAdapter: CollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun bind() {
    }

    override fun bindListeners() {
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.placeState.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun handleState(state: PlaceState) {
        state.data?.let {
            collectionAdapter = CollectionAdapter(this, it)
            viewPager = binding.viewPager
            viewPager.adapter = collectionAdapter
        }
    }

}
