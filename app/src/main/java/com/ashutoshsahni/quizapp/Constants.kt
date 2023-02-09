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
            2,
            q,
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Australia",
            "India",
            "Kuwait",
            3
        )

        val ques3 = Question(
            3,
            q,
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Denmark",
            "Kuwait",
            2
        )

        val ques4 = Question(
            4,
            q,
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "New Zealand",
            "Australia",
            "Kuwait",
            3
        )

        val ques5 = Question(
            5,
            q,
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Belgium",
            "Denmark",
            "Kuwait",
            2
        )

        val ques6 = Question(
            6,
            q,
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "New Zealand",
            "Denmark",
            "Kuwait",
            1
        )

        val ques7 = Question(
            7,
            q,
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "New Zealand",
            "Denmark",
            "Kuwait",
            3
        )

        val ques8 = Question(
            8,
            q,
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "New Zealand",
            "Denmark",
            "Fiji",
            4
        )

        val ques9 = Question(
            9,
            q,
            R.drawable.ic_flag_of_germany,
            "Germany",
            "New Zealand",
            "Denmark",
            "Kuwait",
            1
        )

        questionList.add(ques1)
        questionList.add(ques2)
        questionList.add(ques3)
        questionList.add(ques4)
        questionList.add(ques5)
        questionList.add(ques6)
        questionList.add(ques7)
        questionList.add(ques8)
        questionList.add(ques9)

        return questionList
    }
}