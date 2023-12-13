package com.example.practicafinal

import android.os.Parcel
import android.os.Parcelable

data class University(
    val web_pages: List<String>,
    val name: String,
    val country: String,
    val domains: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(web_pages)
        parcel.writeString(name)
        parcel.writeString(country)
        parcel.writeStringList(domains)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(parcel)
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }
    }
}
