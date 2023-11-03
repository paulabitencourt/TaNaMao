package com.example.bookappkotlin.screens.item.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookappkotlin.R
import com.example.bookappkotlin.databinding.ActivityItemBinding
import com.example.bookappkotlin.screens.home.ui.HomeActivity

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_item)
    }

    override fun onStart() {
        super.onStart()

        binding.itemBtn.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }


}