package com.wonjoon.data.model

import com.google.gson.annotations.SerializedName
import com.wonjoon.domain.model.CountryModel

data class Country (
    @SerializedName("name")
    val _name: String,
    @SerializedName("imageUrl")
    val _imageUrl: String,
    @SerializedName("currency")
    val _currency: String,
) : CountryModel{
    override val name: String
        get() = _name
    override val imageUrl: String
        get() = _imageUrl
    override val currency: String
        get() = _currency
}