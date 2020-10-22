package com.example.yippiquiz.model

data class Item(var id: Int,
                var imageUrl: String,
                var isClose: Boolean,
                var closeLabel: String,
                var productName: String,
                var productDesc: String,
                var star: String,
                var distance: String,
                var promoDesc: String,
                var outletAround: String,
                var outletDesc: String)