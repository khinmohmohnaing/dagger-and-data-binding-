package com.example.databinding

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.databinding.databinding.WeatherItemBinding

class MyAdapter(context: Context): RecyclerView.Adapter<BaseVH>() {
   /* override fun onBindViewHolder(p0: ItemViewHolder, p1: Int) {
        p0.bind(rootInfo.list.get(p1))
    }*/

    lateinit var rootInfo:root
    lateinit var onClickItem : BaseVH.onclick
    fun addList(rootInfo:root){
        this.rootInfo=rootInfo
        Log.i("size",rootInfo.list.size.toString())
    }
    fun getList(position: Int): InfoList {
        return rootInfo.list.get(position)
    }
    fun setOnClick(onClickItem :BaseVH.onclick){
        this.onClickItem=onClickItem
    }
   /* class ItemViewHolder(private val binding: WeatherItemBinding  )
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InfoList) {
            binding.info = item
            binding.executePendingBindings()
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BaseVH {
       /* val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.weather_item, parent,false)
        return WeatherViewHolder(itemBinding)*/
        return WeatherViewHolder(
             LayoutInflater.from(parent.context).inflate(
                R.layout.weather_item, parent,
                false))
    }

    override fun getItemCount(): Int {
        return rootInfo.list.size
    }

    override fun onBindViewHolder(holder: BaseVH, position: Int) {
        holder.bind(rootInfo.list.get(position), onClickItem, position)
    }
}

