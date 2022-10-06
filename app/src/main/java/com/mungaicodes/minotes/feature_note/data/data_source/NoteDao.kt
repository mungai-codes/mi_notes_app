package com.mungaicodes.minotes.feature_note.data.data_source

import androidx.room.*
import com.mungaicodes.minotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("Select * from notes_table")
    fun getAll(): Flow<List<Note>>

    @Query("Select * from notes_table where id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}