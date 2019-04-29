package com.example.pokedexv2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexv2.models.Pokemon

class MainActivity : AppCompatActivity() {

    lateinit var viewAdapter: PokemonAdapter
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /*class FetchPokemonTask : AsyncTask<String, Unit, String>(){
        override fun doInBackground(vararg params: String?): String {

        }

    }*/

}
