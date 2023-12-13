package com.devdroid.ranchtracker.iu.ovino.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devdroid.ranchtracker.R
import com.devdroid.ranchtracker.databinding.FragmentOvinoBinding
import com.devdroid.ranchtracker.domain.model.OvinoItem
import com.devdroid.ranchtracker.iu.ovino.view.adapter.OvinoAdapter
import com.devdroid.ranchtracker.iu.ovino.viewModel.OvinoViewModel
import com.devdroid.ranchtracker.iu.utils.ResponseStatus
import com.devdroid.ranchtracker.iu.utils.UtilsMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OvinoFragment : Fragment(), OvinoAdapter.OnItemClickListener{

    private val ovinoViewModel: OvinoViewModel by viewModels()

    private var _binding: FragmentOvinoBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOvinoBinding.inflate(layoutInflater, container, false)

        binding.fabOvino.setOnClickListener {
            findNavController().navigate(R.id.action_ovinoFragment_to_registerOvinoActivity)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initIU()
    }

    private fun initIU() {
        initList()
    }

    private fun initList() {
        binding.recyclerViewOvino.apply {
            adapter = OvinoAdapter(this@OvinoFragment)
            layoutManager = LinearLayoutManager(requireContext())
        }

        ovinoViewModel.ovino.observe(viewLifecycleOwner){
            (binding.recyclerViewOvino.adapter as OvinoAdapter).submitList(it)
        }

        ovinoViewModel.stateList.observe(viewLifecycleOwner){
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
        ovinoViewModel.listarOvinos()
    }

    override fun onItemClickDelete(ovino: OvinoItem) {
        TODO("Not yet implemented")
    }

}