package com.mungaicodes.minotes.feature_note.domain.repository

import com.mungaicodes.minotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//fake version of our repo mainly used for testing
//this definitions should be in the domain layer while instantiation should occur in the data layer
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)


}