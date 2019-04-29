package com.example.pokedexv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexv2.models.Pokemon
import kotlinx.android.synthetic.main.list_pokemon.view.*

class PokemonAdapter (val items:List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount()= items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
     }


    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: Pokemon) =
                with(itemView){
                    tv_name_pokemon.text = item.name
        }
    }

}