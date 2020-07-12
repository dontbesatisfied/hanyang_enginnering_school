package com.example.textview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 반복문 앱 실습을 들어가기전에 실습에서 사용하는 TextView, EditTextView를 먼저 다뤄보겠습니다
         */
        enterBtn.setOnClickListener {
            textView.text = editText.text.toString()
            editText.text.clear()
        }
        
    }
}