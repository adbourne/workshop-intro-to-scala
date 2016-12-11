package com.awaddell.demo.domain.animal

import play.api.libs.json.Json

object AnimalSummary { implicit val JsonFormat = Json.format[AnimalSummary] } // Required to transform to/from json
case class AnimalSummary(`type`: String, name: String, age: Int) // N.B - 'type' is a keyword in Scala, wrap in backticks to use as a symbol
