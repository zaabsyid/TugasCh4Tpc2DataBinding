package com.zahirar.tugasch4tpc2databinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.Navigation
import com.zahirar.tugasch4tpc2databinding.databinding.FragmentDetailBeritaBinding

class DetailBeritaFragment : Fragment() {

    lateinit var binding : FragmentDetailBeritaBinding
    lateinit var btnBack : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDetailBeritaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title")
        val date = arguments?.getString("date")
        val writer = arguments?.getString("writer")
        val content = arguments?.getString("content")
        val image = arguments?.getInt("image")

        binding.dataBerita = ListDataBerita(title!!, date!!, writer!!, content!!, image!!)

        btnBack = view.findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailBeritaFragment_to_beritaFragment)
        }
    }
}