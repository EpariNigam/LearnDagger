package com.nigam.learndagger.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nigam.learndagger.database.Note
import com.nigam.learndagger.databinding.ItemContentBinding
import com.nigam.learndagger.utils.toDisplayFormat

class NotesView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ConstraintLayout(context, attrs) {
    private val binding: ItemContentBinding

    init {
        binding = ItemContentBinding.inflate(LayoutInflater.from(context), this)
    }

    fun setData(note: Note) {
        binding.tvContent.text = note.note
        binding.tvUpdatedAt.text = note.updatedAt.toDisplayFormat()
    }
}
