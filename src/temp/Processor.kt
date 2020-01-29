package com.nurlandroid.temp

import com.nurlandroid.temp.AnswersInteractor.Companion.processToList


class Processor {

    fun processAnswers(answersList: List<IncomingAnswers>): TestResult {
        for (answer in answersList) {
            when (answer.testName) {
                "test1" -> processFirstTestAnswers(processToList<FirstTestAnswers>(answer.answers))
                "test2" -> processSecondTestAnswers(processToList<SecondTestAnswers>(answer.answers))
                "test3" -> processThirdTestAnswers(processToList<ThirdTestAnswers>(answer.answers))
                "test4" -> processFourthTestAnswers(processToList<FourthTestAnswers>(answer.answers))
                else -> TestResult()
            }
        }
    }


    private fun processFirstTestAnswers(firstTestAnswerList: List<FirstTestAnswers>): FirstTestResult {

        // Counting for first result of test 1

        var count1: Int = 0

        val correctAnswers1 = listOf(1, 4, 5, 7, 8)
        val correctAnswers2 = listOf(2, 3, 6, 9, 10)

        for (i in 0..9) {
            if (firstTestAnswerList[i].id in correctAnswers1 && firstTestAnswerList[i].answer == 1) count1++
            if (firstTestAnswerList[i].id in correctAnswers2 && firstTestAnswerList[i].answer == 0) count1++
        }

        var result1: Int = 0
        if (count1 == 10 || count1 == 9) {
            result1 = 1
        } else if (count1 == 8 || count1 == 7) {
            result1 = 2
        } else if (count1 == 6 || count1 == 5) {
            result1 = 3
        } else if (count1 == 4 || count1 == 3) {
            result1 = 4
        } else if (count1 == 2 || count1 == 1 || count1 == 0) {
            result1 = 5
        }

        // Counting for second result of test 1

        var count2: Int = 0

        val correctAnswers3 = listOf(12, 14, 15, 18, 19)
        val correctAnswers4 = listOf(11, 13, 16, 17, 20)

        for (i in 10..19) {
            if (firstTestAnswerList[i].id in correctAnswers3 && firstTestAnswerList[i].answer == 1) count2++
            if (firstTestAnswerList[i].id in correctAnswers4 && firstTestAnswerList[i].answer == 0) count2++
        }

        var result2: Int = 0
        if (count2 == 10 || count2 == 9) {
            result2 = 1
        } else if (count2 == 8 || count2 == 7) {
            result2 = 2
        } else if (count2 == 6 || count2 == 5) {
            result2 = 3
        } else if (count2 == 4 || count2 == 3) {
            result2 = 4
        } else if (count2 == 2 || count2 == 1 || count2 == 0) {
            result2 = 5
        }

        return FirstTestResult(result1 = result1, result2 = result2)
    }

    private fun processSecondTestAnswers(secondTestAnswerList: List<SecondTestAnswers>): SecondTestResult {

        val positionsYa = listOf(1, 2, 1, 3, 2, 3, 3, 1, 2, 1, 2, 2, 3, 1, 2, 1, 1, 1, 1, 3, 2, 2, 3, 2, 1, 3, 2)
        val positionsO = listOf(3, 3, 3, 2, 1, 1, 2, 2, 1, 3, 1, 1, 1, 2, 3, 3, 3, 2, 2, 2, 1, 1, 1, 3, 3, 1, 1)
        val positionsD = listOf(2, 1, 2, 1, 3, 2, 1, 3, 3, 2, 3, 3, 2, 3, 1, 2, 2, 3, 3, 1, 3, 3, 2, 1, 2, 2, 3)

        fun countSum(positions: List<Int>): Int {
            var sumYa: Int = 0
            for (i in 0..26) {
                sumYa += when {
                    positions[i] == 1 -> secondTestAnswerList[i].answerVar1
                    positions[i] == 2 -> secondTestAnswerList[i].answerVar2
                    else -> secondTestAnswerList[i].answerVar3
                }
            }
            return sumYa
        }

        val resultsMap = hashMapOf(1 to 0, 2 to 0, 3 to 0)
        resultsMap[1] = countSum(positionsYa)
        resultsMap[2] = countSum(positionsO)
        resultsMap[3] = countSum(positionsD)

        val max = resultsMap.maxBy { it.value }?.key ?: 0
        val min = resultsMap.minBy { it.value }?.key ?: 0

        return SecondTestResult(maxResult = max, minResult = min)
    }

    private fun processThirdTestAnswers(thirdTestAnswerList: List<ThirdTestAnswers>): ThirdTestResult {

        var countFakeAnswers: Int = 0
        val fakeAnswers = listOf(6, 16, 26, 36, 45, 46)
        var countAnswers: Int = 0

        thirdTestAnswerList.forEach {
            if (it.id in fakeAnswers && it.answer == 1) countFakeAnswers++
            if (it.answer == 1) countAnswers++
        }

        if (countFakeAnswers >= 4) {
            return ThirdTestResult(result = 6)
        }

        val countedResult: Int = ((countAnswers / 49.0) * 100.0).toInt()

        var finalResult: Int = 0
        when (countedResult) {
            in (80..100) -> finalResult = 1
            in (60..79) -> finalResult = 2
            in (40..59) -> finalResult = 3
            in (20..39) -> finalResult = 4
            in (0..19) -> finalResult = 5
        }

        return ThirdTestResult(result = finalResult)
    }

    private fun processFourthTestAnswers(thirdTestAnswerList: List<FourthTestAnswers>): FourthTestResult {
        var countAnswers: Int = 0
        val answersList1 = listOf(3, 4, 6, 11, 12, 13, 14, 16, 27, 29, 31)
        val answersList2 = listOf(2, 5, 7, 8, 10, 17, 18, 19, 20, 22, 23, 24, 25, 28, 32)

        thirdTestAnswerList.forEach {
            if (it.id in answersList1 && it.answer == 1) countAnswers++
            if (it.id in answersList2 && it.answer == 2) countAnswers++
        }

        var finalResult: Int = 0

        when (countAnswers) {
            in (21..26) -> finalResult = 1
            in (17..20) -> finalResult = 2
            in (13..16) -> finalResult = 3
            in (8..12) -> finalResult = 4
            in (0..7) -> finalResult = 5
        }

        return FourthTestResult(result = finalResult)
    }
}