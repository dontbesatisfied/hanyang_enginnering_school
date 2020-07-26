package com.example.recipe

import android.view.View


data class SimpleRecipe(val thumbnail: String, val title: String, val onClickListener: View.OnClickListener)
data class DetailRecipe(val thumbnail: String, val title: String, val descText: List<Pair<Int, String>>, val descImg: List<Pair<Int, String>>)