package com.nurlandroid.temp

data class IncomingAnswers(
    val testName: String,
    val answers: String
)


open class TestAnswers

data class FirstTestAnswers(
    val id: Int,
    val answer: Int
) : TestAnswers()

data class SecondTestAnswers(
    val id: Int,
    val answerVar1: Int,
    val answerVar2: Int,
    val answerVar3: Int
) : TestAnswers()

data class ThirdTestAnswers(
    val id: Int,
    val answer: Int
) : TestAnswers()

data class FourthTestAnswers(
    val id: Int,
    val answer: Int
) : TestAnswers()