package com.nurlandroid

import com.google.gson.Gson
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import java.util.*

class DummyDataInteractor {

    data class Data(val text: String)

    data class PostData(val data: Text) {
        data class Text(val text: String)
    }

    private val dataList: MutableList<Data> = Collections.synchronizedList(
        mutableListOf(
            Data("my data"),
            Data("your data")
        )
    )


    fun getDataList(): MutableList<Data> = dataList

    fun putData(text: String) {
        dataList += Data(text)
    }


    fun getHtml(): String {
        data class Fruit(val id: Int, val name: String, val value: Int)

        val fruits = ArrayList<Fruit>()

        fruits.add(Fruit(id = 1, name = "apple", value = 10))
        fruits.add(Fruit(id = 2, name = "orange", value = 15))
        fruits.add(Fruit(id = 3, name = "peach", value = 21))
        fruits.add(Fruit(id = 4, name = "banana", value = 5))

        val s = Gson().toJson(fruits)

        return StringBuilder().appendHTML().html {
            lang = "en"
            head {
                meta { charset = "UTF-8" }
                meta { name = "viewport" }
                meta { content = "width=device-width, initial-scale=1" }
                title { +"AnyChart Kotlin Ktor MySQL template" }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/vendor/bootstrap/css/bootstrap.min.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/fonts/font-awesome-4.7.0/css/font-awesome.min.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/vendor/animate/animate.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/vendor/select2/select2.min.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/vendor/perfect-scrollbar/perfect-scrollbar.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/css/util.css"
                }

                link {
                    rel = "stylesheet"
                    type = "text/css"
                    href = "http://www.futuris.kz/site/css/main.css"
                }

//                style {
//                    +"""html, body, #container {
//                        width: 400px;
//                        height: 400px;
//                        margin: 0;
//                        padding: 0;
//                    }""".trimIndent()
//                }
            }
            body {
                div {
                    classes = setOf("limiter")

                    div {
                        classes = setOf("container-table100")

                        div {
                            classes = setOf("wrap-table100")

                            div {
                                classes = setOf("table100", "ver2", "m-b-110")

                                div {
                                    classes = setOf("table100-head")

                                    table {
                                        thead {
                                            tr {
                                                classes = setOf("row100", "head")

                                                th {
                                                    classes = setOf("cell100", "column1")
                                                    +"Class name"
                                                }
                                                th {
                                                    classes = setOf("cell100", "column2")
                                                    +"Type"
                                                }
                                                th {
                                                    classes = setOf("cell100", "column3")
                                                    +"Hours"
                                                }
                                                th {
                                                    classes = setOf("cell100", "column4")
                                                    +"Trainer"
                                                }
                                                th {
                                                    classes = setOf("cell100", "column5")
                                                    +"Spots"
                                                }
                                            }
                                        }
                                    }

                                }

                                div {
                                    classes = setOf("table100-body", "js-pscroll")

                                    table {
                                        tbody {
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                            tr {
                                                classes = setOf("row100", "body")

                                                td {
                                                    classes = setOf("cell100", "column1")
                                                    +"Like a butterfly"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column2")
                                                    +"Boxing"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column3")
                                                    +"9:00 AM - 11:00 AM"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column4")
                                                    +"Aaron Chapman"
                                                }
                                                td {
                                                    classes = setOf("cell100", "column5")
                                                    +"10"
                                                }
                                            }
                                        }
                                    }

                                }

                            }
                        }
                    }

                }

                script { src = "http://www.futuris.kz/site/vendor/jquery/jquery-3.2.1.min.js" }
                script { src = "http://www.futuris.kz/site/vendor/bootstrap/js/popper.js" }
                script { src = "http://www.futuris.kz/site/vendor/bootstrap/js/bootstrap.min.js" }
                script { src = "http://www.futuris.kz/site/vendor/select2/select2.min.js" }
                script { src = "http://www.futuris.kz/site/vendor/perfect-scrollbar/perfect-scrollbar.min.js" }
                script { src = "http://www.futuris.kz/site/js/main.js" }

                script {
                    unsafe {
                        +"""${'$'}('.js-pscroll').each(function(){
			                var ps = new PerfectScrollbar(this);
			                ${'$'}(window).on('resize', function(){
				            ps.update();
			                })
		                    });			
                        """
                    }
                }
            }
        }.toString()
    }
}