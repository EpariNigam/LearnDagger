package com.nigam.learndagger.di

import android.content.Context
import com.nigam.learndagger.addEditNote.AddEditNoteActivity
import com.nigam.learndagger.notesList.NotesListActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DatabaseModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(activity: NotesListActivity)

    fun inject(activity: AddEditNoteActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
