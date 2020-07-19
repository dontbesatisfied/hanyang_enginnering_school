package com.example.lifecycle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub2.*

class SubActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub2)

        Log.d("LifeCycle", "onCreate : SubActivity")

        textView.text = intent.getStringExtra("Message")

        goBackBtn.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("ReturnMessage", "From subAcitivity2")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart : SubActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume : SubActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause : SubActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop : SubActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestory : SubActivity")
    }

}