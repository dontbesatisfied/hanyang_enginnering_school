package com.example.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("LifeCycle", "onCreate : 액티비티의 생성, 최초에 딱 한번만 호출됨")

        clickBtn.setOnClickListener {

//            Intent(Context packageContext, Class<?> cls) 컨텍스트와 호출할 클래스
            val intent = Intent(this, SubActivity::class.java) // ::class.java는 작성 규칙
            startActivity(intent)

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart : 액티비티의 시작, 이때 화면이 그려지기 시작")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume : 액티비티가 실행되고있는 상태")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause : 액티비티가 일시중지 (안드로이드는 포커스를 하나만 가질 수 있으므로 화면의 일부가 다른 액티비티에 가려져도 발생) 이 단계에서 데이터를 저장하거나 네트워크를 호출하는것은 옳지 못함")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop : 액티비티가 사용자에게 더 이상 표시되지 않으면 발생 (앱이 사용자에게 보이지 않는 동안 앱은 필요하지 않은 리소스를 해제하거나 조정해야 함)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestory : 액티비티가 사라지기전에 발생")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart")
    }
}