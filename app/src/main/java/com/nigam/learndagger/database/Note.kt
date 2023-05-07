package com.nigam.learndagger.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nigam.learndagger.utils.DifferDataInterface

@Entity(tableName = TABLE_NOTES)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val entityId: Int? = null,
    val note: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
) : DifferDataInterface {
    override fun getAreItemsTheSameKey(): Any = entityId ?: 0

    override fun getAreContentsTheSameKey(): Any = note
}
