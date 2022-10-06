package com.mungaicodes.minotes.feature_note.data.repository

import com.mungaicodes.minotes.feature_note.data.data_source.NoteDao
import com.mungaicodes.minotes.feature_note.domain.model.Note
import com.mungaicodes.minotes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> = noteDao.getAll()

    override suspend fun getNoteById(id: Int): Note? = noteDao.getNoteById(id)

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

}