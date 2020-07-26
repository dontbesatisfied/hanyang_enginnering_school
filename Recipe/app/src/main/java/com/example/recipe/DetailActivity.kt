package com.example.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.simple_recipe.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val idx = intent.getIntExtra("dataIdx", 0)

        getDetailData("${idx+1}") {
            println(it)
            titleView.text = it.title.toString()
            Glide.with(this).load(it.thumbnail).into(thumbnailView)

            for (i in it.descText) {
                textView.append("${i.second} \n\n")
            }

        }

    }

    private fun getDetailData(index: String, callback: (data: DetailRecipe) -> Unit) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://openapi.foodsafetykorea.go.kr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(OpenApiService::class.java)

            service.getDetailData("8f8163a74abf48a9a2e3", "json", index, index).enqueue(object: Callback<OpenApiDetailResponse> {
                override fun onFailure(call: Call<OpenApiDetailResponse>, t: Throwable) {
                    Log.d("Response Error ::", "Failed API call with call: " + call +
                            " + exception: " + t)
                }

                override fun onResponse(
                    call: Call<OpenApiDetailResponse>,
                    response: Response<OpenApiDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        for ((idx, ele) in response.body()?.data?.rows!!.withIndex()) {

                            var descText = mutableListOf<Pair<Int, String>>()
                            var descImg = mutableListOf<Pair<Int, String>>()
                            var title = ""
                            var thumbnail = ""

                            for ((key, value) in ele) {
                                /**
                                 * 데이터 분류
                                 */
                                if (value.isNotEmpty()) {
                                    if (key.contains("MANUAL_IMG")) {
                                        descImg.add(Integer.parseInt(key.split("MANUAL_IMG")[1]) to value)
                                    } else if (key.contains("MANUAL")) {
                                        descText.add(Integer.parseInt(key.split("MANUAL")[1]) to value)
                                    } else if (key.contains("ATT_FILE_NO_MK")) {
                                        thumbnail = value
                                    } else if (key.contains("RCP_NM")) {
                                        title = value
                                    }
                                }
                            }

                            /**
                             * 데이터 순서 정렬
                             */
                            descText.sortBy { it.first }
                            descImg.sortBy { it.first }

                            callback(DetailRecipe(thumbnail, title, descText, descImg))
                        }

                    }
                }
            })
        } catch (e: Exception) {
            throw e
        }
    }
}

