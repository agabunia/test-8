package com.example.test_8.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test_8.R
import com.example.test_8.presentation.model.Places
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollectionAdapter(fragment: Fragment, private val placesList: List<Places>): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = placesList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = ObjectFragment()
        fragment.arguments = Bundle().apply {
            putSerializable(ObjectFragment.ARG_PLACE, placesList[position])
        }
        return fragment
    }
}
