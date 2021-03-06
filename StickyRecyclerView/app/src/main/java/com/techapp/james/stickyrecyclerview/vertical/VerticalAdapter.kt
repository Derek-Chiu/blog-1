package com.techapp.james.stickyrecyclerview.vertical

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techapp.james.stickyrecyclerview.dataStructure.Data
import com.techapp.james.stickyrecyclerview.R
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.title_item.view.*

class VerticalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    val TITLE = 1
    val ITEM = 0
    val concreteData: Data
    var sendTitleDecoration: ((title: String, width: Int) -> Unit)? = null

    constructor(concreteData: Data) {
        this.concreteData = concreteData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TITLE -> {
                var itemView = LayoutInflater.from(parent.context).inflate(R.layout.title_item, parent, false)
                return TitleHolder(itemView)
            }
            else -> {
                var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

                return ItemHolder(itemView)
            }
        }
    }

    override fun getItemCount(): Int {
        return concreteData.count();
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleHolder) {
            holder.textView.text = concreteData.getItem(position)
            sendTitleDecoration?.invoke(concreteData.getItem(position), holder.itemView.height)
        } else {
            (holder as ItemHolder).textView.text = concreteData.getItem(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (concreteData.isTitle(concreteData.getItem(position))) {
            return TITLE
        } else {
            return ITEM
        }

    }

    class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.titleTextView
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView.textView
    }
}