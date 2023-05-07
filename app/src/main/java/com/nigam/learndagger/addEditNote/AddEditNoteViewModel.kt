package com.nigam.learndagger.addEditNote

import com.nigam.learndagger.base.BaseViewModel
import com.nigam.learndagger.database.Note
import com.nigam.learndagger.database.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddEditNoteViewModel @Inject constructor(
    private val notesDao: NotesDao
) : BaseViewModel() {
    fun insertNote(data: String) {
        val note = Note(note = data)
        scope.launch(Dispatchers.IO) {
            notesDao.insert(note)
        }
    }
}
