package com.example.segundoandroidavanzado.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.segundoandroidavanzado.databinding.FragmentListBinding
import com.example.segundoandroidavanzado.domain.model.HeroModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val listViewModel: ListFragmentViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentListBinding.inflate(inflater, container, false).apply{
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHeroList.adapter = ListAdapter()
        listViewModel.heroList.observe(viewLifecycleOwner){ heroList ->
            initList(heroList)
        }
        listViewModel.getData()
    }

    private fun initList(data: List<HeroModel>) = binding.rvHeroList.run {
        adapter = ListAdapter(data)
    }
}