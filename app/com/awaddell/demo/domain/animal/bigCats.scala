package com.awaddell.demo.domain.animal

import play.api.libs.json.{OFormat, Json}
import julienrf.json.derived


sealed trait BigCat extends Animal {
  val topSpeedMph: Double
}


object Lion {
  implicit val jsonFormat = Json.format[Lion]
}

case class Lion(name: String, age: Int, topSpeedMph: Double = 50.00) extends BigCat


object Leopard {
  implicit val jsonFormat = Json.format[Leopard]
}

case class Leopard(name: String, age: Int, topSpeedMph: Double = 36.00) extends BigCat


object Cheetah {
  implicit val jsonFormat = Json.format[Cheetah]
}

case class Cheetah(name: String, age: Int, topSpeedMph: Double = 70.00) extends BigCat

/**
  * This needs to live down here, a small price to pay!
  * We are using a scala macro to handle the complex polymorphic json stuff.
  */
object BigCat {
  implicit val jsonFormat:OFormat[BigCat] = derived.oformat[BigCat]
}