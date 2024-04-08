package com.rishika.fireapp.ui.screens.notes

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.rishika.fireapp.data.CNote

class NoteViewModel(
    private val auth: FirebaseAuth = Firebase.auth,
    private val db: FirebaseFirestore = Firebase.firestore
) {

    private fun loadAllNotes(){}

    private fun saveNewNote(){
        val note = CNote(
            uid = "",
            title = "",
            content = "",
            importance = "1"
        )
        db.collection(COLL_NOTES)
            .add(note)
            .addOnFailureListener {
                //handle and display error
            }
            .addOnSuccessListener {
                //update the state
            }
    }


    companion object{
        const val COLL_NOTES = "notes"
        const val COLL_UPLOADS = "uploads"
    }
}