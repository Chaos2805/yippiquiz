package com.example.yippiquiz.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yippiquiz.R
import com.example.yippiquiz.RecyclerTouchListener
import com.example.yippiquiz.adapter.RecyclerAdapter
import com.example.yippiquiz.contract.MainContract
import com.example.yippiquiz.di.component.DaggerActivityComponent
import com.example.yippiquiz.di.module.ActivityModule
import com.example.yippiquiz.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onDomainSuccess(item: List<Item>) {
        val list = ArrayList<Item>()
        var count = 0
        item.forEachIndexed { index, item ->
            if (item.id > count) {
                list.add(item)
            }
            count = item.id
        }
        val testRecyclerAdapter = RecyclerAdapter(list, this)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
        recyclerView.adapter = testRecyclerAdapter

        recyclerView.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                recyclerView,
                object : RecyclerTouchListener.ClickListener {
                    override fun onLongClick(view: View?, position: Int) {
                    }

                    override fun onClick(view: View, position: Int) {
                        val intent = Intent(baseContext, ActivityItemDetails::class.java)
                        intent.putExtra("name", list[position].productName)
                        intent.putExtra("rating", list[position].star)
                        intent.putExtra("distance", list[position].distance)
                        intent.putExtra("discount", list[position].promoDesc)
                        intent.putExtra("around", list[position].outletAround)
                        intent.putExtra("image", list[position].imageUrl)
                        intent.putExtra("desc", list[position].productDesc)
                        startActivity(intent)
                    }
                })
        )
    }

    override fun onDomainError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun initView() {
        presenter.getList()

    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}