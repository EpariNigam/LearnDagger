package com.nigam.learndagger.notesList

import android.content.Intent
import com.nigam.learndagger.App
import com.nigam.learndagger.addEditNote.AddEditNoteActivity
import com.nigam.learndagger.base.BaseActivity
import com.nigam.learndagger.database.Note
import com.nigam.learndagger.databinding.ActivityNotesListBinding
import javax.inject.Inject

class NotesListActivity : BaseActivity<ActivityNotesListBinding>() {

    @Inject
    internal lateinit var viewModel: NotesListViewModel

    @Inject
    internal lateinit var adapter: NotesAdapter


    override fun initializeBinding(): ActivityNotesListBinding =
        ActivityNotesListBinding.inflate(layoutInflater)

    override fun bindListeners() {
        binding.fabAddNote.setOnClickListener {
            val intent = Intent(this, AddEditNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun doInjection() {
        (applicationContext as App)
            .component
            .inject(this)
    }

    override fun observeLiveData() {
        viewModel.liveData.observe(this, ::bindNotes)
    }

    override fun initView() {
        binding.rvContent.adapter = adapter
    }

    private fun bindNotes(notes: List<Note>) {
        adapter.submitList(notes)
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchNotes()
    }
}
