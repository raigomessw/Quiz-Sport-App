package com.example.quiz_sport_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Question::class], version = 1)

abstract class AppDataBase : RoomDatabase() {

    abstract fun questionDao() : QuestionDao


}

