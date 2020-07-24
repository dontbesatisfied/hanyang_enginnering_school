package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class Holder: RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    fun setItem(item: Item) {
        itemView.idx.text = item.idx
        itemView.content.text = item.content
    }

}


class ItemAdapter(): RecyclerView.Adapter<Holder>() {

    var items = mutableListOf<Item>()

    /**
     * layout manager가 호출하여 뷰 홀더가 콘텐츠를 표시하기 위해 사용하는 뷰를 설정
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        Inflater는 특정 XML 파일을 클래스로 변환할수 있도록해준다
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return Holder(view)
    }

    /**
     * 보여줄 아이템 개수
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * layout manager가 호출하여 recycler view에 뷰홀더의 위치를 전달하여 생성된 아이템 레이아웃에 값 입력 후 목록에 출력. 즉, 데이터와 레이아웃을 연결
     */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

}