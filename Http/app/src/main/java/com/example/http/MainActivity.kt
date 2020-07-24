package com.example.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 1. manifiests 파일에 권한 추가 (추가후에도 안된다면 에뮬레이터에서 앱을 삭제 후 다시 실행)
         * 2. 메인 스레드에서 통신 및 UI 작업을 하면 안되므로 새로운 스레드로 작업
        * 3. retrofit을 사용하기 위해서 자바 버전 변석
         * 4. gradle에 retrofit, gson 추가
         */

        editText.setText("https://api.icndb.com/jokes/random")
        
        libFlag.setOnCheckedChangeListener { compoundButton, b ->  libFlag.isChecked = b}

        button.setOnClickListener {
            try {
                var textUrl = editText.text.toString()
//            URL객체로 변환
                var url = URL(textUrl)

                if (libFlag.isChecked) {
                    getDataByRetrofit()
                } else {
                    getDataByURLConnection(url)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

    private fun getDataByRetrofit() {
        try {
            /**
             * retrofit 객체생성
             * 서버에서 데이터를 JSON으로 돌려주기 때문에 GsonConverterFactory.create()를 통하여 JSON을 변환해주는 컨버터도 추가해주고 build()를 통해 생성
             */
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            /**
             * retrofit 객체를 통해 인터페이스를 실행가능한 서비스객체 생성
             * 인터페이스에 정의된 API 엔드포인트들의 구현체를 만든다
             */
            val jokeService = retrofit.create(JokeService::class.java)

            jokeService.getData("random").enqueue(object: Callback<JokeResponse> {
                override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                    Log.d("Response Error ::", "Failed API call with call: " + call +
                            " + exception: " + t)
                }

                override fun onResponse(
                    call: Call<JokeResponse>,
                    response: Response<JokeResponse>
                ) {
                    Log.d("Response :: ", "${response.body()}")
                    if (response.isSuccessful) {
                        textView.append(response.body()?.data.toString())
                    }
                }
            })

        } catch (e: Exception) {
            throw e
        }
    }

    private fun getDataByURLConnection(url: URL) {
        try {
            thread {
//                서버와 연결 생성 openConnection의 반환값이 URLConnection 클래스인데 추상클래스이므로 실제 구현 클래스로 형변환
                val httpsConn = url.openConnection() as HttpsURLConnection
                httpsConn.requestMethod = "GET"
//                응답 코드가 200으로 정상일때
                if (httpsConn.responseCode == HttpsURLConnection.HTTP_OK) {
//                    데이터를 읽어오는 스트림을 연결하여 버퍼에 담는것
                    val streamReader = InputStreamReader(httpsConn.inputStream)
                    val resBuffer = BufferedReader(streamReader)


                    while (true) {
                        val resLine = resBuffer.readLine() ?: break
                        Log.d("RESULT :: ", resLine)
                        runOnUiThread {
                            textView.append(resLine)
                        }
                    }
//                        스트림과 커넥션 해제
                    resBuffer.close()
                    httpsConn.disconnect()

                }

            }
        } catch (e: Exception) {
            throw e
        }
    }
}