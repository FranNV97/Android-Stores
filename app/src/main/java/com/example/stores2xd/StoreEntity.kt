package com.example.stores2xd
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Store Entity")
data class StoreEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                       var name: String, var tlf: String = "", var website: String = "", var isFav: Boolean = false)
