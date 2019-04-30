package com.example.pokedexv2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexv2.models.API.NamedAPIResource
import com.example.pokedexv2.models.API.PokemonSprites
import com.example.pokedexv2.models.API.PokemonStat
import com.example.pokedexv2.models.Pokemon
import com.example.pokedexv2.utils.NetworkUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    //declarando variables
    lateinit var viewAdapter: PokemonAdapter
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewAdapter =  PokemonAdapter(mutableListOf<Pokemon>()) {

        }

        viewManager = LinearLayoutManager(this) //maneja la visual

        //solo para configurar al recyclerview que linear y adaptador a usar
        rv_pokemon.apply {
            adapter =  viewAdapter
            layoutManager = viewManager
        }
        FetchPokemonTask().execute()

    }

    inner class FetchPokemonTask : AsyncTask<String, Unit, List<Pokemon>>() { //inner = clase interna para ver los valores de la instancia
        override fun doInBackground(vararg params: String?): List<Pokemon> {
            // URL a consultar

            val url= NetworkUtil.buildURL()

            // Result in TEXT
            val result= NetworkUtil.getResponseFRomHttpUrl(url)

            val resultJSON = JSONObject(result)

            // Obtener lista de Pokemons

            val resultsPokemonsJSONNArray = resultJSON.getJSONArray("results")


            var listPokemon: List<Pokemon> = MutableList(resultsPokemonsJSONNArray.length() - 1) {
                val pokemonString = resultsPokemonsJSONNArray[it].toString()
                val pokemonJSON = JSONObject(pokemonString)

                // obtener detalles de pokemon

                val pokemonDetailResultString =  NetworkUtil.getResponseFRomHttpUrl(URL(pokemonJSON.getString("url")))
                val pokemonDetailJSON = JSONObject(pokemonDetailResultString)
                // Creando un pokemon
                with(pokemonDetailJSON){
                    Pokemon(
                        getInt("id"),
                        getString("name"),
                        getInt("height"),
                        getInt("weight"),
                        // Crear un objeto sprites
                        with(getJSONObject("sprites")){
                            PokemonSprites(
                                getString("front_default"),
                                getString("front_shiny"),
                                getString("front_female"),
                                getString("front_shiny_female"),
                                getString("back_default"),
                                getString("back_shiny"),
                                getString("back_female"),
                                getString("back_shiny_female")
                            )
                        },
                        //Creando el arreglo stats
                        with(getJSONArray("stats")){
                            MutableList(length() -1 ){
                                with(JSONObject(this[it].toString())){
                                    PokemonStat(
                                        // stat
                                        with(getJSONObject("stat")){
                                            NamedAPIResource(
                                                getString("name"),
                                                getString("url"))
                                        },
                                        getInt("effort"), //effort
                                        getInt("base_stat") //base_stat
                                    )
                                }
                            }
                        }
                        )
                }
            }
            return listPokemon
        }

        override fun onPostExecute(result: List<Pokemon>?) {
            super.onPostExecute(result)
            viewAdapter.items = result!!
            viewAdapter.notifyDataSetChanged()
        }

    }

}
