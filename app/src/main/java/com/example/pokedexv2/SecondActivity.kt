package com.example.pokedexv2

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pokedexv2.models.Pokemon
import kotlinx.android.synthetic.main.view_pokemon.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_pokemon)

        if (intent!= null){
            var pokemon: Pokemon = intent.getParcelableExtra("pokemon")
            Glide.with(this).load(pokemon.sprites.front_default).into(iv_foto_pokemon)
            tv_name_complete_pokemon.text = pokemon.name
            tv_height.text = pokemon.height.toString()
            tv_weight.text = pokemon.weight.toString()
        }



    }
}