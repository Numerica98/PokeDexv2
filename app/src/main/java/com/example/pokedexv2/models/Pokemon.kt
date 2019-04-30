package com.example.pokedexv2.models

import android.os.Parcelable
import com.example.pokedexv2.models.API.PokemonSprites
import com.example.pokedexv2.models.API.PokemonStat
import kotlinx.android.parcel.Parcelize

/**
 * @property id The identifier for this resource.
 * @property name The name for this resource.
 * @property height The height of this Pokémon in decimetres.
 * @property weight The weight of this Pokémon in hectograms.
 * @property sprites A set of sprites used to depict this Pokémon in the game.
 * @property stats A list of base stat values for this Pokémon.
 * */

@Parcelize
data class Pokemon (val id:Int,
                    val name:String,
                    val height:Int,
                    val weight:Int,
                    val sprites:PokemonSprites,
                    val stats:List<PokemonStat>): Parcelable