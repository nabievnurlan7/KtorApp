package com.nurlandroid

import java.util.*

class DummyDataInteractor {

    data class Data(val text: String)

    data class PostData(val data: Text) {
        data class Text(val text: String)
    }

    private val dataList: MutableList<Data> = Collections.synchronizedList(
        mutableListOf(
            Data("my data"),
            Data("your data")
        )
    )


    fun getDataList(): MutableList<Data> = dataList

    fun putData(text: String) {
        dataList += Data(text)
    }
}