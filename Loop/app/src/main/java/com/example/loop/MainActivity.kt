package com.example.loop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 선행학습 요소
         *
         * 텍스트뷰 이해하기
         * 텍스트뷰의 텍스트 가져오기
         * 형변환 하기
         */

        startBtn.setOnClickListener {

            if (editText.text.isNotEmpty()) {

                val num = editText.text.toString()
                for (i in 1..9) {
                    resultTextView.text = "${resultTextView.text}${num} x $i = ${Integer.parseInt(num)}\n"
                }
            }

        }
    }
}