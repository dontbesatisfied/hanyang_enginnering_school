package com.example.function

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.truncate

class MainActivity : AppCompatActivity() {
    var beforeNum = 0.0
    var currentNum = 0.0
    var operation = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 1. 각 버튼을 연결한다
         * 2. 각 버튼을 누르면 숫자가 화면에 표시된다.
         * 2-1. 화면에 0이 떠있으면 0을 눌러도 반영이되면 안된다.
         * 3. = 을 누르면 전 값과 현재 값을 연산한다.
         * 3-1. = 의 결과를 노출하기 위해 연산자 클릭시 현재값 -> 전값
         * 4. = 을 제외한 연산자가 이미 눌렸을 경우 중간 값을 도출해준다.
         */

        var operateBtnList = listOf(btnDivide, btnAdd, btnSub, btnMultiply)

        val btnListener = View.OnClickListener {
            when (it.id) {
                btn0.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,0)
                    clearClickedColor(operateBtnList)
                }
                btn1.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,1)
                    clearClickedColor(operateBtnList)
                }
                btn2.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,2)
                    clearClickedColor(operateBtnList)
                }
                btn3.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,3)
                    clearClickedColor(operateBtnList)
                }
                btn4.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,4)
                    clearClickedColor(operateBtnList)
                }
                btn5.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,5)
                    clearClickedColor(operateBtnList)
                }
                btn6.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,6)
                    clearClickedColor(operateBtnList)
                }
                btn7.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,7)
                    clearClickedColor(operateBtnList)
                }
                btn8.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,8)
                    clearClickedColor(operateBtnList)
                }
                btn9.id -> {
                    if (operation == 5) operation = 0 // = 누른 후 바로 숫자를 누르면 연산을 초기화
                    currentNum = setNumber(currentNum,9)
                    clearClickedColor(operateBtnList)
                }
                btnDivide.id -> {

                    setClickedColor(operateBtnList, btnDivide)
                    val resultMap = operate(4, beforeNum, currentNum, operation)
                    currentNum = resultMap["currentNum"] ?: error("")
                    beforeNum = resultMap["beforeNum"] ?: error("")
                    operation = 4
                    textView.text = beforeNum.toString()


                }
                btnMultiply.id -> {
                    setClickedColor(operateBtnList, btnMultiply)
                    val resultMap = operate(3, beforeNum, currentNum, operation)
                    currentNum = resultMap["currentNum"] ?: error("")
                    beforeNum = resultMap["beforeNum"] ?: error("")
                    operation = 3
                    textView.text = beforeNum.toString()

                }
                btnSub.id -> {
                    setClickedColor(operateBtnList, btnSub)
                    val resultMap = operate(2, beforeNum, currentNum, operation)
                    currentNum = resultMap["currentNum"] ?: error("")
                    beforeNum = resultMap["beforeNum"] ?: error("")
                    operation = 2
                    textView.text = beforeNum.toString()

                }
                btnAdd.id -> {
                    setClickedColor(operateBtnList, btnAdd)
                    val resultMap = operate(1, beforeNum, currentNum, operation)
                    currentNum = resultMap["currentNum"] ?: error("")
                    beforeNum = resultMap["beforeNum"] ?: error("")
                    operation = 1
                    textView.text = beforeNum.toString()

                }
                btnResult.id -> {

                    clearClickedColor(operateBtnList)
                    beforeNum = getResult(operation, beforeNum, currentNum)
                    currentNum = 0.0
                    operation = 5
                    textView.text = beforeNum.toString()


                }
                btnAC.id -> {

                    clearClickedColor(operateBtnList)
                    currentNum = 0.0
                    beforeNum = 0.0
                    textView.text = "0"
                    operation = 0

                }
            }

        }

        btn0.setOnClickListener(btnListener)
        btn1.setOnClickListener(btnListener)
        btn2.setOnClickListener(btnListener)
        btn3.setOnClickListener(btnListener)
        btn4.setOnClickListener(btnListener)
        btn5.setOnClickListener(btnListener)
        btn6.setOnClickListener(btnListener)
        btn7.setOnClickListener(btnListener)
        btn8.setOnClickListener(btnListener)
        btn9.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnSub.setOnClickListener(btnListener)
        btnAdd.setOnClickListener(btnListener)
        btnResult.setOnClickListener(btnListener)
        btnAC.setOnClickListener(btnListener)

    }

    private fun setNumber(currentNum: Double, input: Int): Double {
        if (currentNum == 0.0) {
            textView.text = input.toString()
        } else {
            textView.text = textView.text.toString() + input
        }
        return textView.text.toString().toDouble()

    }

    private fun operate(currentOperation: Int, beforeNum: Double, currentNum: Double, beforeOperation: Int): MutableMap<String, Double> {

        if (beforeOperation == 0) {
            return mutableMapOf("beforeNum" to currentNum, Pair("currentNum", 0.0))

        } else if (beforeOperation == 5) { // = 클릭 후 이어서 연산하는 경우
            when (currentOperation) {
                1 -> {
                    return mutableMapOf("beforeNum" to (beforeNum + currentNum), Pair("currentNum", 0.0))
                }
                2 -> {
                    return mutableMapOf("beforeNum" to (beforeNum - currentNum), Pair("currentNum", 0.0))
                }
                3 -> {
                    return mutableMapOf("beforeNum" to (beforeNum * currentNum), Pair("currentNum", 0.0))
                }
                4 -> {
                    return mutableMapOf("beforeNum" to (beforeNum / currentNum), Pair("currentNum", 0.0))
                }
                else -> {
                    return mutableMapOf("beforeNum" to 0.0, Pair("currentNum", 0.0))
                }
            }
        } else {
            when (beforeOperation) {
                1 -> {
                    return mutableMapOf("beforeNum" to (beforeNum + currentNum), Pair("currentNum", 0.0))
                }
                2 -> {
                    return mutableMapOf("beforeNum" to (beforeNum - currentNum), Pair("currentNum", 0.0))
                }
                3 -> {
                    return mutableMapOf("beforeNum" to (beforeNum * currentNum), Pair("currentNum", 0.0))
                }
                4 -> {
                    return mutableMapOf("beforeNum" to (beforeNum / currentNum), Pair("currentNum", 0.0))
                }
                else -> {
                    return mutableMapOf("beforeNum" to 0.0, Pair("currentNum", 0.0))
                }
            }
        }

    }

    private fun getResult(type: Int, beforeNum: Double, currentNum: Double): Double {

        when (type) {
            1 -> {
                return beforeNum + currentNum
            }
            2 -> {
                return beforeNum - currentNum
            }
            3 -> {
                return beforeNum * currentNum
            }
            4 -> {
                return beforeNum / currentNum
            }
            else -> {
                return currentNum
            }
        }
    }



    private fun setClickedColor(btnList: List<Button>, targetBtn: Button) {

            for (btn in btnList) {
                if (btn.id !== targetBtn.id) {
                    btn.setTextColor(Color.WHITE)
                    DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.myBtn)))
                    btn.isEnabled = false
                } else {
                    btn.setTextColor(Color.BLACK)
                    DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(Color.WHITE))
                    btn.isEnabled = true
                }

            }

    }

    private fun clearClickedColor(btnList: List<Button>) {
        for (btn in btnList) {
            btn.setTextColor(Color.WHITE)
            DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.myBtn)))
            btn.isEnabled = true
        }
    }

}