package com.example.stores2xd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores2xd.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var madapter: StoreAdapter
    private lateinit var mgridLayout: GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener {
            val store = StoreEntity(name = binding.edittextName.text.toString().trim())
            Thread {
                StoreApp.database.storeDao().addStore(store)
            }.start()

            madapter.add(store)
        }

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        madapter = StoreAdapter(mutableListOf(), this)
        mgridLayout = GridLayoutManager(this, 2)
        getStores()
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = mgridLayout
            adapter = madapter
        }
    }

    private fun getStores(){
        doAsync {
            val stores = StoreApp.database.storeDao().getAllStores()
            uiThread {
                madapter.setStores(stores)
            }

        }

    }

    //INTERFAZ ONCLICKLISTENER
    override fun onClick(storeEntity: StoreEntity) {
        TODO("Not yet implemented")
    }
}