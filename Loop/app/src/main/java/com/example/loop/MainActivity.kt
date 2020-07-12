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
         * 1. 텍스트 입력
         * 2. 버튼을 누른다
         * 3. 버튼을 누르면 editText의 입력값과 반복문을 이용하여 구구단을 생성한다
         * 4. 반복문으로 생성한 문자열을 textView에 입력한다
         *
         * String 을 Int로 변경하는 법
         *
         * val text = editText.text.toString()
         * val convertedNumber = Integer.parseInt(text)
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