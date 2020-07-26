package com.example.mycontainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        /**
         * 1.리사이클러뷰를 추가
         * 2.아이템뷰를 생성
         * 3. 데이터 정의
         * 4. 뷰홀더
         * 5. 어댑터
         * 6. 리사이클러뷰에 어댑터 & 레이아웃매니저 정의 및 할당
         */

        val adapter = ItemAdapter()
        adapter.items = setData()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun setData(): MutableList<Item> {
        var data = mutableListOf<Item>()

        for (i in 1..100) {
            val item = Item("$i", "This is my content $i", View.OnClickListener {
                Toast.makeText(this, "Button $i", Toast.LENGTH_SHORT).show()
            })
            data.add(item)
        }

        return data

    }
}