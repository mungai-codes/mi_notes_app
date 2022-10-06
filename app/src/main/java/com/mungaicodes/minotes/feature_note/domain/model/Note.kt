package com.mungaicodes.minotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mungaicodes.minotes.ui.theme.*

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
