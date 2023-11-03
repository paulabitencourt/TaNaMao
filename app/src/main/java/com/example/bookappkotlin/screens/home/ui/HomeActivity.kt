package com.example.bookappkotlin.screens.home.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookappkotlin.R
import com.example.bookappkotlin.databinding.ActivityHomeBinding
import com.example.bookappkotlin.repositories.database.ViewModelUser
import com.example.bookappkotlin.repositories.network.api.model.Meme
import com.example.bookappkotlin.screens.home.ui.adapters.PhotoAdapter
import com.example.bookappkotlin.screens.home.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

//    private val recyclerView: RecyclerView by lazy {
//        findViewById(R.id.recyclerView)
//    }

    private val photoAdapter by inject<PhotoAdapter> {
        parametersOf(applicationContext)
    }

    private val viewModelHome by inject<HomeViewModel>()

    private val viewModelUser by inject<ViewModelUser>() {
        parametersOf(this)
    }


    // Mock data class with sample data for MemeValue
    val test = listOf<Meme>(
        Meme(1, 100, "1", "Cama de casal", "https://picsum.photos/300/300", 150),
        Meme(2, 120, "2", "Cama de casal", "https://picsum.photos/300/300", 180),
        Meme(3, 120, "3", "Cama de casal", "https://picsum.photos/300/300", 180),
        Meme(4, 120, "4", "Cama de casal", "https://picsum.photos/300/300", 180),
        Meme(3, 120, "3", "Cama de casal", "https://picsum.photos/300/300", 180),
        Meme(4, 120, "4", "Cama de casal", "https://picsum.photos/300/300", 180),

        // Add more sample memes if needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        actionBar?.hide()

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = photoAdapter
            recyclerView3.layoutManager = GridLayoutManager(applicationContext, 2)
            recyclerView3.adapter = photoAdapter
        }
        listMemeAtPhotoAdapter()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun listMemeAtPhotoAdapter() {
        photoAdapter.setDataList(test)
        photoAdapter.notifyDataSetChanged()
    }
}