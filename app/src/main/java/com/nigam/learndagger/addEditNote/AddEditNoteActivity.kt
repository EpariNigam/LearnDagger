package com.nigam.learndagger.addEditNote

import com.nigam.learndagger.App
import com.nigam.learndagger.base.BaseActivity
import com.nigam.learndagger.databinding.ActivityAddEditNoteBinding
import javax.inject.Inject

class AddEditNoteActivity : BaseActivity<ActivityAddEditNoteBinding>() {

    @Inject
    internal lateinit var viewModel: AddEditNoteViewModel

    override fun initializeBinding(): ActivityAddEditNoteBinding =
        ActivityAddEditNoteBinding.inflate(layoutInflater)

    override fun bindListeners() {
        binding.btnSave.setOnClickListener {
            val note = binding.etNote.text?.toString()
            if (!note.isNullOrBlank()) {
                viewModel.insertNote(note)
            }
        }
    }

    override fun doInjection() {
        (applicationContext as App)
            .component
            .inject(this)
    }

    override fun observeLiveData() {

    }

    override fun initView() {

    }
}
