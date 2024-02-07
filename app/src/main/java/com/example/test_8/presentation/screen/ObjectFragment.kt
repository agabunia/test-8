package com.example.test_8.presentation.screen

import com.example.test_8.databinding.PlaceLayoutBinding
import com.example.test_8.presentation.base.BaseFragment
import com.example.test_8.presentation.model.Places
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ObjectFragment : BaseFragment<PlaceLayoutBinding>(PlaceLayoutBinding::inflate) {

    companion object {
        const val ARG_PLACE = "place"
    }

    override fun bind() {
        arguments?.takeIf { it.containsKey(ARG_PLACE) }?.apply {
            val place = getSerializable(ARG_PLACE) as? Places
            place?.let {
                binding.title.text = it.title
            }
        }
    }

    override fun bindListeners() {
    }

    override fun bindObserves() {
    }

}
