package com.nigam.learndagger.di

import android.content.Context
import androidx.room.Room
import com.nigam.learndagger.database.NotesDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    @Synchronized
    fun database(context: Context): NotesDatabase {
        return Room.databaseBuilder(context, NotesDatabase::class.java, "notes_database")
            .setQueryExecutor(Dispatchers.IO.asExecutor())
            .setTransactionExecutor(Dispatchers.IO.asExecutor())
            .build()
    }

    @Singleton
    @Provides
    fun notesDao(database: NotesDatabase) = database.getNotesDao()
}
