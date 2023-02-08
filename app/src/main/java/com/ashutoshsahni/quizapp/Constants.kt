package com.ashutoshsahni.quizapp

object Constants {
    fun getQuestion() : ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val q = "What country does this flag belongs to?"

        val ques1 = Question(
            1,
            q,
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Denmark",
            "Kuwait",
            1
        )

        val ques2 = Question(
            1,
            q,
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Australia",
            "India",
            "Kuwait",
            1
        )

        val ques3 = Question(
            1,
            q,
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Denmark",
            "Kuwait",
            1
        )

        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)

        return questionList
    }
}