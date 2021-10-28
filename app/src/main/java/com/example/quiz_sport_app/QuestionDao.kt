package com.example.quiz_sport_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {

    @Insert
    fun insert(question: MutableList<Question>)

    @Delete
    fun delete(question: Question)

    @Query("SELECT * FROM question_table")
    fun getAll(): List<Question>
}