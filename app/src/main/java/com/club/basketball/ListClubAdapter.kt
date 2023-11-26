package com.club.basketball

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListClubAdapter(
    private val listClub: List<Club>
) : RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }



    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_club, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val club = listClub[position]
        holder.tvName.text = club.name
        holder.tvDescription.text = club.description
        holder.imgPhoto.setImageResource(club.photo)


        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_CLUB, listClub[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Club)
    }

}










