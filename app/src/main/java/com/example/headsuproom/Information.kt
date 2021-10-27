package com.example.headsuproom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Celebrities")
data class Information(
    @PrimaryKey(autoGenerate = true) val pk: Int,
    val name: String?,
    val taboo1: String?,
    val taboo2: String?,
    val taboo3: String?

)