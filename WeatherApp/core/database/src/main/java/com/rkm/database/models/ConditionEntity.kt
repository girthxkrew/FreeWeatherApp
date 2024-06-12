package com.rkm.database.models

import androidx.room.Entity

@Entity(tableName = "condition")
data class ConditionEntity(
    val text: String,
    val icon: String,
    val code: Int
)