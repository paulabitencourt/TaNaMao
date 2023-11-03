package com.example.bookappkotlin.screens.home.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookappkotlin.R
import com.example.bookappkotlin.repositories.network.api.model.Meme
import com.example.bookappkotlin.screens.item.ui.ItemActivity
import com.example.bookappkotlin.screens.register.ui.RegisterActivity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PhotoAdapter(var context: Context) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>(),
    KoinComponent {

    private val glide by inject<ImageLoader>()
    private var dataList = emptyList<Meme>()

    internal fun setDataList(userImageList: List<Meme>) {
        this.dataList = userImageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.title.text = data.name

        holder.image.setImageResource(R.drawable.cama)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ItemActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.findViewById(R.id.image)
        var title: TextView = itemView.findViewById(R.id.textTitle)
    }
}