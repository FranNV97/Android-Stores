package com.example.stores2xd

import android.util.Log



import android.app.Application
import androidx.room.Room

private const val TAG = "StoreApp"
class StoreApp : Application() {
    companion object{
         lateinit var database: StoreDatabase
    }

    override fun onCreate(){
        super.onCreate()
        Log.d(TAG,"entro aqui")
        database = Room.databaseBuilder(this,StoreDatabase::class.java,"StoreDatabase").build()
    }
}