package com.zahirar.tugasch4tpc2databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.zahirar.tugasch4tpc2databinding.databinding.ItemBeritaBinding

class BeritaAdapter(var listBerita: ArrayList<ListDataBerita>): RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemBeritaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun dataBind(itemData : ListDataBerita){
            binding.dataBerita = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.ViewHolder {
        val v = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: BeritaAdapter.ViewHolder, position: Int) {
        holder.dataBind(listBerita[position])
        val title = listBerita[position].title
        val writer = listBerita[position].writer
        val image = listBerita[position].image
        val content = listBerita[position].content
        val date = listBerita[position].date
        holder.binding.cvBerita.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val bundle = Bundle()
                bundle.putString("title", title)
                bundle.putString("date", date)
                bundle.putString("writer", writer)
                bundle.putString("content", content)
                bundle.putInt("image", image)

                Navigation.findNavController(holder.itemView).navigate(R.id.action_beritaFragment_to_detailBeritaFragment, bundle)
            }
        })
    }

    override fun getItemCount(): Int {
        return listBerita.size
    }
}