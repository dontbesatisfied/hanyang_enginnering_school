package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 1. 리사이클러뷰 추가
         * 2. 아이템뷰 생성
         * 3. 데이터 가져오기
         * 4. 뷰홀더
         * 5. 어댑터
         * 6. 리사이클러뷰 어댑터, 레이아웃 매니저 정의
         */
        val adapter = ItemAdapter()
        adapter.items = setData()
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)


    }

    fun setData(): MutableList<Item> {
        var data = mutableListOf<Item>()

        for (i in 1..50) {
            data.add(Item("$i", "This is content $i"))
        }
        return data
    }
}