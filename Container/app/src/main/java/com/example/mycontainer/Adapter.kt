package com.example.mycontainer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItem(item: Item) {
        itemView.idxTV.text = item.idx
        itemView.contentTV.text = item.content
        itemView.btn.setOnClickListener(item.listener)
    }

}

class ItemAdapter(): RecyclerView.Adapter<Holder>() {

    var items = mutableListOf<Item>()



    /**
     * 레이아웃 매니저가 호출하여 뷰홀더가 컨텐츠를 표시하기 위해 사용하는 뷰홀더를 생성
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        Inflater - 특정 XML을 클래스로 변활할 수 있도록 해준다.
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return Holder(itemView)
    }

    /**
     * 보여줄 아이템 갯수를 반환
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * 레이아웃 매니저가 호출하여 리사이클러뷰에 뷰홀더의 위치를 전달하여 생성된 아이템을 레이아웃에 바인딩하는것.
     * 데이터와 레이아웃을 연결
     */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "view ${item.idx}", Toast.LENGTH_SHORT).show()
        }

    }
}




