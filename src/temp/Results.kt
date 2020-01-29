package com.nurlandroid.temp

data class TotalResult(
    var codeId: Int,
    var name: Username?,
    var firstTestResult: FirstTestResult?,
    var secondTestResult: SecondTestResult?,
    var thirdTestResult: ThirdTestResult?,
    var fourthTestResult: FourthTestResult?
)

data class Username(
    val firstname: String,
    val lastname: String
)

open class TestResult

data class FirstTestResult(
    val id: Int = 0,
    val result1: Int,
    val result2: Int
) : TestResult()

data class SecondTestResult(
    val id: Int = 0,
    val maxResult: Int,
    val minResult: Int
) : TestResult()

data class ThirdTestResult(
    val id: Int = 0,
    val result: Int
) : TestResult()

data class FourthTestResult(
    val id: Int = 0,
    val result: Int
) : TestResult()