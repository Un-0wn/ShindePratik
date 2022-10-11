package com.example.shindepratik.ui.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shindepratik.databinding.Rv2ItemBinding
import com.example.shindepratik.ends.UnkDto

class UnkPagingAdapter :
    PagingDataAdapter<UnkDto, UnkPagingAdapter.LatestViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding =
            Rv2ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class LatestViewHolder(private val binding: Rv2ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UnkDto) {

            Log.wtf("UserAdapter", user.color)

            binding.apply {

                txt1.text = user.name
                txt2.text = user.year.toString()
            }
        }

    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UnkDto>() {
            override fun areItemsTheSame(oldItem: UnkDto, newItem: UnkDto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UnkDto, newItem: UnkDto): Boolean {
                return oldItem == newItem
            }

        }
    }

}