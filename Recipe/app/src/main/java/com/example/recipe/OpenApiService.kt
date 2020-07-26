package com.example.recipe

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenApiService {
    @GET("{keyId}/COOKRCP01/{dataType}/{startIdx}/{endIdx}")
    fun getSimpleData(@Path("keyId") apiKey: String,
                @Path("dataType") dataType: String = "json",
                @Path("startIdx") startIdx: String = "0",
                @Path("endIdx") endIdx: String = "10"): Call<OpenApiSimpleResponse>

    @GET("{keyId}/COOKRCP01/{dataType}/{startIdx}/{endIdx}")
    fun getDetailData(@Path("keyId") apiKey: String,
                @Path("dataType") dataType: String = "json",
                @Path("startIdx") startIdx: String = "0",
                @Path("endIdx") endIdx: String = "10"): Call<OpenApiDetailResponse>

}


/**
 * 중요한 점은 응답 받을 데이터 구조와 같은 구조이어야 하며 변수 명도 같아야함.
 */
data class OpenApiSimpleResponse(
    @SerializedName("COOKRCP01") val data: SimpleRows
)

data class SimpleRows(
    @SerializedName("row") val rows: Array<Row>
)

data class Row(
    @SerializedName("RCP_NM") val title: String,
    @SerializedName("ATT_FILE_NO_MAIN") val thumbnailUrl: String
)

data class OpenApiDetailResponse(
    @SerializedName("COOKRCP01") val data: DetailRows
)

data class DetailRows(
    @SerializedName("row") val rows: Array<Map<String, String>>
)

