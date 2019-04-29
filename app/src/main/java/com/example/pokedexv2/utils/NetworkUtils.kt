package com.example.pokedexv2.utils

import android.net.Uri
import java.net.URL

const val BASE_URL:String= "https://pokeapi.co/api/v2/"
const val POKEMON:String= "pokemon"

class NetworkUtil {
    companion object {
        fun buildURL(): URL {
            val buildUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath(POKEMON)
                .build()

            val url= URL(buildUri.toString())

            return  url
        }

        fun getResponseFRomHttpUrl(url: URL) : String{
            return  url.readText()
        }
    }
}