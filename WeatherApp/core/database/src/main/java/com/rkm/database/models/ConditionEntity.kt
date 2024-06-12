package com.rkm.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ConditionEntity(
    val text: String,
    val icon: String,
    val code: Int
)