package com.example.pokedexv2.models.API

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @property front_default The default depiction of this Pokémon from the front in battle.
 * @property front_shiny The shiny depiction of this Pokémon from the front in battle.
 * @property front_female The female depiction of this Pokémon from the front in battle.
 * @property front_shiny_female The shiny female depiction of this Pokémon from the front in battle.
 * @property back_default The default depiction of this Pokémon from the back in battle.
 * @property back_female The female depiction of this Pokémon from the back in battle.
 * @property back_shiny_female The shiny female depiction of this Pokémon from the back in battle.
 * */

@Parcelize
data class PokemonSprites (val front_default:String,
                           val front_shiny:String,
                           val front_female:String,
                           val front_shiny_female:String,
                           val back_default:String,
                           val back_shiny:String,
                           val back_female:String,
                           val back_shiny_female:String) : Parcelable