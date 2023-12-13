package com.devdroid.ranchtracker.iu.bovino.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.databinding.FragmentBovinoBinding
import com.devdroid.ranchtracker.domain.model.BovinoItem
import com.devdroid.ranchtracker.iu.bovino.view.adapter.BovinoAdapter
import com.devdroid.ranchtracker.iu.bovino.viewModel.BovinoViewModel
import com.devdroid.ranchtracker.iu.utils.ResponseStatus
import com.devdroid.ranchtracker.iu.utils.UtilsMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BovinoFragment : Fragment(), BovinoAdapter.IOnClcikListener {

    private val bovinoViewModel: BovinoViewModel by viewModels()

    private var _binding: FragmentBovinoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBovinoBinding.inflate(layoutInflater, container, false)



        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_bovinoFragment_to_registrarBovinoActivity)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initUI() {
        initList()
    }


    private fun initList() {
        binding.rvBovino.layoutManager = LinearLayoutManager(requireContext())

        binding.rvBovino.adapter = BovinoAdapter(this)
        bovinoViewModel.bovinos.observe(viewLifecycleOwner){
            (binding.rvBovino.adapter as BovinoAdapter).submitList(it)
        }

        bovinoViewModel.stateList.observe(viewLifecycleOwner){
            when(it){
                is ResponseStatus.Error -> {
                    binding.progressBar.isVisible = false

                    if (it.message.isNotEmpty())
                        UtilsMessage.showAlertOk(
                            "ERROR", it.message, requireContext()
                        )
                }

                is ResponseStatus.Loading -> binding.progressBar.isVisible = true
                is ResponseStatus.Success -> binding.progressBar.isVisible = false
            }
        }



    }

    override fun onResume() {
        super.onResume()

        bovinoViewModel.listar()
    }

    override fun clickEliminar(bovinoItem: BovinoItem) {
        TODO("Not yet implemented")
    }


}