package com.dmytrod.newxeltestapp.screens.profile

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dmytrod.newxeltestapp.R
import com.dmytrod.newxeltestapp.model.Card

class CardsAdapter : ListAdapter<Card, CardsAdapter.CardViewHolder>(diffUtil) {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: CardViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Card?) {
            item?.let {
                Glide.with(itemView)
                        .load(item.imageUrl)
                        .into(itemView as ImageView)
            }
        }

    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Card>() {
            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
                    oldItem == newItem

            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
                    oldItem.imageUrl == newItem.imageUrl
        }
    }
}
