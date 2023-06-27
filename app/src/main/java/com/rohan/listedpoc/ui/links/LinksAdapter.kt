package com.rohan.listedpoc.ui.links

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rohan.listedpoc.R
import com.rohan.listedpoc.data.response.Links
import com.rohan.listedpoc.utils.DateUtils

class LinksAdapter(var context: Context): RecyclerView.Adapter<LinksAdapter.ViewHolder>() {

    var list = arrayListOf<Links?>();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_links, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = list[position]
        holder.textLinkName.text = data?.app
        holder.textLinkDate.text = DateUtils.convertDateFormat(data?.createdAt)
        holder.textLink.text = data?.webLink
        holder.imageLink.let {
            Glide.with(context).load(data?.originalImage).into(it)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var textLinkName: TextView
        lateinit var textLinkDate: TextView
        lateinit var textLink: TextView
        lateinit var textLinkClick: TextView
        lateinit var imageLink: ImageView
        init {
            textLinkName = itemView.findViewById(R.id.text_linkname)
            textLinkDate = itemView.findViewById(R.id.text_linkdate)
            textLink = itemView.findViewById(R.id.text_link)
            textLinkClick = itemView.findViewById(R.id.text_linkclick)
            imageLink = itemView.findViewById(R.id.image_link)
        }
    }

    fun addData(links: List<Links?>){
        list.clear()
        list.addAll(links)
        notifyDataSetChanged()
    }

}