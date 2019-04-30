package com.example.pokedexv2.models.API

/**
 * @property stat The stat the Pokémon has.
 * @property effort The effort points (EV) the Pokémon has in the stat.
 * @property base_stat The base value of the stat.
 * */

data class PokemonStat (val stat:NamedAPIResource,
                        val effort: Int,
                        val base_stat: Int)