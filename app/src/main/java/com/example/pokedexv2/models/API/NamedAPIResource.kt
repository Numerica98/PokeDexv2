package com.example.pokedexv2.models.API

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NamedAPIResource (val name:String,
                             val url:String) : Parcelable