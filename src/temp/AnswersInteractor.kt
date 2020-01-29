package com.nurlandroid.temp


import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken

class AnswersInteractor {
    private val answersProcessor = Processor()
    private val gson = GsonBuilder().setLenient().create()

    fun processAnswers(json: String): String {
        val totalResult = TotalResult(0, null, null, null, null, null)


        val jsonCode = getDataFromJson(json, "code")
        val code: String = gson.fromJson(jsonCode, object : TypeToken<String>() {}.type)
        totalResult.codeId = 11

        val jsonName = getDataFromJson(json, "name")
        val name: Username = gson.fromJson(jsonName, object : TypeToken<Username>() {}.type)
        totalResult.name = name

        val jsonTestAnswers = getDataFromJson(json, "answers")
//        val answers: List<IncomingAnswers> =
//            gson.fromJson(jsonName, object : TypeToken<List<IncomingAnswers>>() {}.type)
//

        val incomingAnswers: List<IncomingAnswers> = processToList(jsonTestAnswers)
        answersProcessor.processAnswers(incomingAnswers)

        return ""
    }



    private fun getDataFromJson(json: String, type: String): String {
        val jsonTree = JsonParser().parse(json)
        val jsonObject = jsonTree.asJsonObject
        return jsonObject.get(type).toString()
    }

    companion object{

        fun <T> processToList(jsonToProcess: String): List<T> =
            gson.fromJson(jsonToProcess, object : TypeToken<List<T>>() {}.type)
    }
}