package com.example.yippiquiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.yippiquiz.R
import com.example.yippiquiz.contract.MainContract
import com.example.yippiquiz.di.component.DaggerActivityComponent
import com.example.yippiquiz.di.module.ActivityModule
import com.example.yippiquiz.model.Item
import kotlinx.android.synthetic.main.activity_item_details2.*

class ActivityItemDetails : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details2)
        injectDependency()

        initView()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    private fun initView() {
        text_title.text = intent.getStringExtra("name")
        text_rating.text = intent.getStringExtra("rating")
        text_distance.text = intent.getStringExtra("distance")
        if (!intent.getStringExtra("around").isNullOrBlank())
            text_nearby.text = intent.getStringExtra("around") + " 家商家在您附近"
        else
            text_nearby?.visibility = View.GONE
        Glide.with(this).load(intent.getStringExtra("image")).into(imageView2)
        text_discount.text = intent.getStringExtra("discount")
        text_desc.text = intent.getStringExtra("desc")

        imageView.setOnClickListener { super.onBackPressed() }
    }

}