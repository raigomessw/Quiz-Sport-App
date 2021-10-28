package com.example.quiz_sport_app

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "question_table")
data class Question(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "optionOne") val optionOne: String,
    @ColumnInfo(name = "optionTwo") val optionTwo: String,
    @ColumnInfo(name = "optionThree") val optionThree: String,
    @ColumnInfo(name = "optionFour") val optionFour: String,
    @ColumnInfo(name = "correctAnswer") val correctAnswer: Int,

)







