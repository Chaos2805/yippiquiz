package com.example.yippiquiz.contract

import com.example.yippiquiz.model.Item

class MainContract {

    interface View: BaseContract.View{

        fun onDomainSuccess(movie: List<Item>)
        fun onDomainError(msg: String)

    }

    interface Presenter:BaseContract.Presenter<View>{
        fun getList()
    }
}