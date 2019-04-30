package com.example.pokedexv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexv2.models.Pokemon
import kotlinx.android.synthetic.main.list_pokemon.view.*

class PokemonAdapter(var items: List<Pokemon>, var clickListener: (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }


    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Pokemon, clickListener: (Pokemon) -> Unit) =
            with(view) {
                tv_name_pokemon.text = item.name
                setOnClickListener { clickListener(item) }
                Glide
                    .with(view)
                    .load(item.sprites.front_default)
                    .centerCrop().into(iv_pokemon)
            }
    }

}