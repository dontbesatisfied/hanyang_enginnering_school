package com.example.mycontainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)


        var data = mutableListOf(" -- 선택 -- ", "코틀린", "스위프트", "자바", "자바스크립트", "파이썬")

        /**
         * 어댑터를 사용해서 화면에 나타낼 데이터와 화면에 보여주는 스피너를 연결해서 사용합니다.
         *
         * 스피너와 데이터를 연결해주는 중간다리
         */

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                textView.text = data[p2]
            }
        }

        addBtn.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                data.add(editText.text.toString())
                editText.setText("")
            }
        }










    }
}