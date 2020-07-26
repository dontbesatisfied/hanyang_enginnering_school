package com.example.recipe

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.simple_recipe.view.*
import java.net.URL

/**
 * 뷰홀더는 화면에 표시될 아이템 뷰를 저장하는 객체
 * 어댑터에 의해 관리가된다. 필요에따라 생성하거나 재활용을한다.
 */
class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun setItem(item: SimpleRecipe) {

        Glide.with(itemView).load(item.thumbnail).into(itemView.thumbnail)
        itemView.title.text = item.title
        itemView.setOnClickListener(item.onClickListener)
    }
}

/**
 * 리사이클러뷰에 표시될 아이템 뷰를 생성하는 역할
 */
class RecycleAdapter: RecyclerView.Adapter<Holder>() {

    var items = mutableListOf<SimpleRecipe>()

//        화면에 보여지는 아이템 개수만큼 레이아웃 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        특정 xml 파일을 클래스로 변환
        val view = LayoutInflater.from(parent.context).inflate(R.layout.simple_recipe, parent, false)
//        변환한 클래스를 바로 사용할수 없으므로 Holder에 저장
        return Holder(view)

    }

//        목록에 보여줄 아이템 갯수
    override fun getItemCount(): Int {
        return items.size
    }

//    생성된 아이템 레이아웃에 값 입력 후 목록에 출력. 즉, 데이터와 레이아웃 연결
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }


}