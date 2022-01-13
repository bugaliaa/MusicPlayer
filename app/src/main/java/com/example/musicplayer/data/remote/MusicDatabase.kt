package com.example.musicplayer.data.remote

import com.example.musicplayer.data.entity.Song
import com.example.musicplayer.others.Constants
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(Constants.SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try{
            songCollection.get().await().toObjects(Song::class.java)
        } catch(e: Exception){
            emptyList()
        }
    }
}