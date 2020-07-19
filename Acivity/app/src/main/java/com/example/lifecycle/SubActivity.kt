package com.example.lifecycle

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        Log.d("LifeCycle", "onCreate : SubActivity")

        goToBtn.setOnClickListener {
//            인텐트에 값을입력할때는 키와 값을 조합으로 넣고, 꺼낼때는 키로 꺼냅니다
            val intent = Intent(this, SubActivity2::class.java)
            intent.putExtra("Message", "From SubActivity")
//            startActivity(intent)
            startActivityForResult(intent, 0)
        }

        goBackBtn.setOnClickListener {
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> {
                    val returnMessage = data?.getStringExtra("ReturnMessage")
                    Toast.makeText(this, returnMessage, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

}