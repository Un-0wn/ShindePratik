package com.example.shindepratik.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shindepratik.databinding.RvItemBinding
import com.example.shindepratik.ends.Dto
import com.example.shindepratik.ends.UserDto

class UserPagingAdapter :
    PagingDataAdapter<UserDto, UserPagingAdapter.LatestViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding =
            RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class LatestViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserDto) {

            Log.wtf("UserAdapter", user.email)

            binding.apply {

                txt1.text = user.first_name
                txt2.text = user.last_name
                Glide.with(itemView)
                    .asBitmap()
                    .load(user.avatar)
                    .centerCrop()
                    .into(userImg)
            }
        }

    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<UserDto>() {
            override fun areItemsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
                return oldItem == newItem
            }

        }
    }

}