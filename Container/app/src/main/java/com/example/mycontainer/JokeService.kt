package com.example.mycontainer

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * 인터페이스를 이용하여 호출방식, 주소 그리고 데이터 등을 정의한다.
 * 레트로핏은 인터페이스 해석하여 통신을 처리한다.
 * 반환타입은 retrofit의 인터페이스 Call을 선택해야한다.
 * 다른 클래스의 Call을 선택하지 않도록 주의해야한다.
 */
interface JokeService {
    @GET("jokes/{id}")
    fun getData(
        @Path("id") jokeId: String
    ): Call<JokeResponse>


}

/**
 * 응답 받을 데이터 구조와 같은 구조이어야 하며 변수 명도 같아야한다.
 */
data class JokeResponse(
    @SerializedName("value") val data: JokeValue
)

data class JokeValue(
    @SerializedName("id") val id: String,
    @SerializedName("joke") val joke: String
)