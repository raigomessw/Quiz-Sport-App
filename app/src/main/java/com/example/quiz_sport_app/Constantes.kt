package com.example.quiz_sport_app

object Constants { // Skapa en constante till ala frågor!

//Variabel till final program
    const val USER_NAME: String ="user_name"
    const val TOTAL_QUESTIONS: String= "total_question"
    const val CORRECT_ANSWERS: String= "correct_answers"

    fun getQuestions(): MutableList<Question> { //Cria uma lista de perguntas
        val questionsList = mutableListOf<Question>()

        val ques1 = Question(1,
            "What country does Archery belong to?",
            R.drawable.archery,
            "Argentina",
            "Brazil",
            "Australia",
            "Portugal",
            2)
        questionsList.add(ques1)

        val ques2 = Question(2,
            "Who is/are Bulgaria's most distinguished lifter/lifters in weightlifting?",
            R.drawable.weightlifter,
            "Stefan Botev",
            " Nikolay Peshalo",
            "Demir Demirev",
            "All are correct",
            4)
        questionsList.add(ques2)

        val ques3 = Question(3,
            "How many Olympic medals does Hungary have in water polo?",
            R.drawable.walter_polo,
            "3",
            " 10",
            "15",
            "6",
            3)
        questionsList.add(ques3)

        val ques4 = Question(4,
            "Capoeira is an ____martial art?",
            R.drawable.capoeira,
            "Brazilian",
            "African",
            "Asian",
            "Afro-Brazilian",
            4)
        questionsList.add(ques4)

        val ques5 = Question(5,
            "How many players are there at the same time on the field in a basketball game?",
            R.drawable.basquete,
            "13",
            "12",
            "10",
            "11",
            3)
        questionsList.add(ques5)

        return questionsList

    }

}