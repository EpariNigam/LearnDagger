package com.nigam.learndagger.notesList

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nigam.learndagger.customViews.NotesView
import com.nigam.learndagger.database.Note
import com.nigam.learndagger.utils.DataDiffer
import com.nigam.learndagger.utils.dpToPx
import javax.inject.Inject

class NotesAdapter @Inject constructor() :
    ListAdapter<Note, NotesAdapter.NotesViewHolder>(DataDiffer<Note>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            NotesView(parent.context)
                .apply {
                    layoutParams = ViewGroup.MarginLayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply {
                        bottomMargin = 10.dpToPx
                    }
                }
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class NotesViewHolder(private val view: NotesView) : RecyclerView.ViewHolder(view) {
        fun bindData(note: Note) {
            view.setData(note)
        }
    }
}
