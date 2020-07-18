package com.example.myfuntion

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var beforeNumber = 0.0
    var currentNumber = 0.0
//    add -> 1 / sub -> 2 / multiply -> 3 / divide -> 4
    var operationType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnList = listOf(btnDivide, btnMultiply, btnSub, btnAdd)

        val btnListener = View.OnClickListener {

            when (it.id) {

                btn0.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 0)
                }
                btn1.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 1)
                }
                btn2.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 2)
                }
                btn3.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 3)
                }
                btn4.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 4)
                }
                btn5.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 5)
                }
                btn6.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 6)
                }
                btn7.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 7)
                }
                btn8.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 8)
                }
                btn9.id -> {
                    clearClickedOperator(btnList)
                    currentNumber = setNumber(currentNumber, 9)
                }
                btnDivide.id -> {
                    setClickedOperator(btnList, btnDivide)
                    val resultMap = operate(beforeNumber, currentNumber, operationType)
                    currentNumber = resultMap["currentNum"] ?: error("")
                    beforeNumber = resultMap["beforeNum"] ?: error("")
                    operationType = 4
                    textView.text = beforeNumber.toString()

                }
                btnMultiply.id -> {
                    setClickedOperator(btnList, btnMultiply)
                    val resultMap = operate(beforeNumber, currentNumber, operationType)
                    currentNumber = resultMap["currentNum"] ?: error("")
                    beforeNumber = resultMap["beforeNum"] ?: error("")
                    operationType = 3
                    textView.text = beforeNumber.toString()
                }
                btnSub.id -> {
                    setClickedOperator(btnList, btnSub)
                    val resultMap = operate(beforeNumber, currentNumber, operationType)
                    currentNumber = resultMap["currentNum"] ?: error("")
                    beforeNumber = resultMap["beforeNum"] ?: error("")
                    operationType = 2
                    textView.text = beforeNumber.toString()
                }
                btnAdd.id -> {
                    setClickedOperator(btnList, btnAdd)
                    val resultMap = operate(beforeNumber, currentNumber, operationType)
                    currentNumber = resultMap["currentNum"] ?: error("")
                    beforeNumber = resultMap["beforeNum"] ?: error("")
                    operationType = 1
                    textView.text = beforeNumber.toString()
                }

                btnResult.id -> {
                    clearClickedOperator(btnList)
                    beforeNumber = getResult(operationType, beforeNumber, currentNumber)
                    currentNumber = 0.0
                    textView.text = beforeNumber.toString()
                }

                btnAC.id -> {

                    clearClickedOperator(btnList)
                    currentNumber = 0.0
                    beforeNumber = 0.0
                    operationType = 0
                    textView.text = "0"
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
        btnAC.setOnClickListener(btnListener)
        btnResult.setOnClickListener(btnListener)
    }

    private fun setNumber(currentNum: Double, input: Int): Double {
        if (currentNum == 0.0) {
            textView.text = input.toString()
        } else {
            textView.text = textView.text.toString() + input
        }
        return textView.text.toString().toDouble()
    }

    private fun operate(beforeNum: Double, currentNum: Double, beforeOperation: Int): MutableMap<String, Double> {

        if (beforeOperation == 0) {
            return mutableMapOf(Pair("beforeNum", currentNum), "currentNum" to 0.0)
        } else {
            when (beforeOperation) {
                1 -> { // +
                    return mutableMapOf(Pair("beforeNum", (beforeNum + currentNum)), "currentNum" to 0.0)
                }
                2 -> { // -
                    return mutableMapOf(Pair("beforeNum", (beforeNum - currentNum)), "currentNum" to 0.0)
                }
                3 -> { // *
                    return mutableMapOf(Pair("beforeNum", (beforeNum * currentNum)), "currentNum" to 0.0)
                }
                4-> { // /
                    return mutableMapOf(Pair("beforeNum", (beforeNum / currentNum)), "currentNum" to 0.0)
                }
                else -> {
                    return mutableMapOf(Pair("beforeNum", currentNum), "currentNum" to 0.0)
                }
            }
        }
    }

    private fun getResult(currentOperation: Int, beforeNum: Double, currentNum: Double): Double {

        when (currentOperation) {
            1 -> { // +
                return beforeNum + currentNum
            }
            2 -> { // -
                return beforeNum - currentNum
            }
            3 -> { // *
                return beforeNum * currentNum
            }
            4-> { // /
                return beforeNum / currentNum
            }
            else -> {
                return currentNum
            }
        }

    }

    private fun setClickedOperator(btnList: List<Button>, targetBtn: Button) {

        for (btn in btnList) {
            if (btn.id == targetBtn.id) {
                btn.setTextColor(Color.BLACK)
                DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(Color.WHITE))
                btn.isEnabled = true
            } else {
                btn.setTextColor(Color.WHITE)
                DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.operateClicked)))
                btn.isEnabled = false
            }
        }
    }

    private fun clearClickedOperator(btnList: List<Button>) {
        for (btn in btnList) {
            btn.setTextColor(Color.WHITE)
            DrawableCompat.setTintList(btn.background, ColorStateList.valueOf(ContextCompat.getColor(this, R.color.operateClicked)))
            btn.isEnabled = true
        }
    }
}