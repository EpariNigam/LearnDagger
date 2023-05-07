package com.nigam.learndagger.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class NotesDao {
    @Insert
    abstract suspend fun insert(note: Note)

    @Query("SELECT * FROM $TABLE_NOTES")
    abstract suspend fun getAllNotes(): List<Note>
}