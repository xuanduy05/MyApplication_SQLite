package com.yellowcode.roomsample.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yellowcode.roomsample.R
import com.yellowcode.roomsample.database.NoteRoomDatabase
import com.yellowcode.roomsample.model.Note
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewNoteActivity : AppCompatActivity(), CoroutineScope {

    private var noteDB: NoteRoomDatabase ?= null

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        mJob = Job()

        noteDB = NoteRoomDatabase.getDatabase(this)

        button_save.setOnClickListener {
            launch {
                val strTen: String = txtName.text.toString()
                val strEmail: String = txtEmail.text.toString()
                val strContact : String = txtContact.text.toString()
                val strAddress : String = txtAddress.text.toString()
                noteDB?.noteDao()?.insert(Note(ten = strTen, email = strEmail, contact = strContact, address = strAddress))


                finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mJob.cancel()
    }
}
