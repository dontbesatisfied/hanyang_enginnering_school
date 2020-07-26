package com.example.recipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    var recipes: MutableList<SimpleRecipe> = mutableListOf()
    var startIdx = 0
    var isFetching = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        var adapter = RecycleAdapter()
        adapter.items = recipes

        main_recyclerView.adapter = adapter

        main_recyclerView.layoutManager = GridLayoutManager(this, 3)

        main_recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                스크롤이 바닥을 찍을때
                if (!recyclerView.canScrollVertically(1) && !isFetching) {
                    Toast.makeText(baseContext, "BOTTOM", Toast.LENGTH_SHORT).show()
//                    isFetching = true
//                    getData((startIdx+1).toString(), (startIdx+15).toString()) {
//                        adapter.notifyDataSetChanged()
//                        startIdx += 15
//                        isFetching = false
//                    }
                } else if (!recyclerView.canScrollVertically(-1)) {
//                    Toast.makeText(baseContext, "TOP", Toast.LENGTH_SHORT).show()
                }
            }
        })

        isFetching = true
        getData(startIdx.toString(), (startIdx+15).toString()) {
//            데이터를 다 받아오면 업데이트해서 보여주기 위함
            adapter.notifyDataSetChanged()
            startIdx += 15
            isFetching = false
        }


    }


    /**
     * retrofit 설명
     * https://github.com/HwangEunmi/Retrofit-Sample
     */
    private fun getData(startIdx: String, endIdx: String, callback: () -> Unit) {
        Log.d("Request :: ", "$startIdx / $endIdx")
        /**
         * retrofit 객체생성
         * 서버에서 데이터를 JSON으로 돌려주기 때문에 GsonConverterFactory.create()를 통하여 JSON을 변환해주는 컨버터도 추가해주고 build()를 통해 생성
         */
        val retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.foodsafetykorea.go.kr/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        /**
         * retrofit 객체를 통해 인터페이스 생성
         * 인터페이스에 정의된 API 엔드포인트들의 구현체를 만든다
         */
        val service = retrofit.create(OpenApiService::class.java)

        service.getSimpleData("8f8163a74abf48a9a2e3", "json", startIdx, endIdx).enqueue(object: Callback<OpenApiSimpleResponse> {
            override fun onFailure(call: Call<OpenApiSimpleResponse>, t: Throwable) {
                Log.d("Response Error ::", "Failed API call with call: " + call +
                        " + exception: " + t)
            }

            override fun onResponse(
                call: Call<OpenApiSimpleResponse>,
                response: Response<OpenApiSimpleResponse>
            ) {
//                Log.d("Response :: ", "$startIdx , $endIdx ${response.body()}")
                if (response.isSuccessful) {
                    for ((idx, ele) in response.body()?.data?.rows!!.withIndex()) {
                        val item = SimpleRecipe(ele.thumbnailUrl, ele.title, View.OnClickListener {
                            val intent = Intent(baseContext, DetailActivity::class.java)
                            intent.putExtra("dataIdx", Integer.parseInt(startIdx) + idx)
                            startActivity(intent)
                        })
                        recipes.add(item)

                    }
                    callback()
                }
            }
        })
    }



}