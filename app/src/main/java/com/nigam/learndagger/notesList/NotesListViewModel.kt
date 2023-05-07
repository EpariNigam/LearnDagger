package com.nigam.learndagger.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nigam.learndagger.base.BaseViewModel
import com.nigam.learndagger.database.Note
import com.nigam.learndagger.database.NotesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NotesListViewModel @Inject constructor(
    private val notesDao: NotesDao
) : BaseViewModel() {

    val liveData: LiveData<List<Note>> = MutableLiveData()

    fun fetchNotes() {
        scope.launch(Dispatchers.IO) {
            (liveData as MutableLiveData).postValue(notesDao.getAllNotes())
        }
    }
}
