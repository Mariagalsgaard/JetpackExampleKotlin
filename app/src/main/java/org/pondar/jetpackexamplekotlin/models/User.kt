package org.pondar.jetpackexamplekotlin.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: String = "",
    var fullName: String = "",
    var email: String = "",
    var postalAdress: String = "",
    var zipCode: Long = 0,
    var age: Long = 0,
    var city: String = "",
    var gender: Gender = Gender.No_Gender
) : Parcelable