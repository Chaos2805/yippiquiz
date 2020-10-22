package com.example.yippiquiz.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yippiquiz.R
import com.example.yippiquiz.model.Item
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(val items: ArrayList<Item>, val context: Context?) :
    RecyclerView.Adapter<ViewHolder>() {
    var count = 0

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, p0, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemName?.text = items[p1].productName
        Glide.with(context!!).load(items[p1].imageUrl).into(p0.itemImage)
        p0.itemDesc?.text = items[p1].productDesc
        p0.itemRating?.text = items[p1].star.toDouble().toString()
        p0.itemDistance?.text = items[p1].distance
        p0.itemDiscount?.text = items[p1].promoDesc
        if (items[p1].isClose) {
            p0.itemClose?.text = items[p1].closeLabel
            p0.closeCover.visibility = View.VISIBLE
        } else {
            p0.itemClose?.visibility = View.GONE
            p0.closeCover.visibility = View.GONE
        }
        Log.d("wanevnwaev",items[p1].outletAround.isNullOrBlank().toString())
        if (!items[p1].outletAround.isNullOrBlank()) {
            p0.itemNearby?.text = items[p1].outletAround + " 家商家在您附近"
        }
        else {
            p0.itemNearby?.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val itemName = view.item_title
    val itemDesc = view.item_desc
    val itemRating = view.item_rating
    val itemDistance = view.item_distance
    val itemDiscount = view.item_discount
    val itemNearby = view.nearby_count
    val itemImage = view.item_image
    val itemClose = view.item_close
    val closeCover = view.close_cover
}