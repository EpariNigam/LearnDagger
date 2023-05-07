package com.nigam.learndagger.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DataDiffer<T : DifferDataInterface> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.getAreItemsTheSameKey() == newItem.getAreItemsTheSameKey()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem.getAreContentsTheSameKey() == newItem.getAreContentsTheSameKey()
}