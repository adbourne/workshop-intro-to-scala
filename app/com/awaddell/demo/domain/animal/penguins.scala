package com.awaddell.demo.domain.animal

import julienrf.json.derived
import play.api.libs.json.{OFormat, Json}


sealed trait Penguin extends Animal {
  val heightInMeters: Double
}


object EmperorPenguin {
  implicit val jsonFormat = Json.format[EmperorPenguin]
}
case class EmperorPenguin(name: String, age: Int, heightInMeters: Double = 1.1) extends Penguin


object GentooPenguin {
  implicit val jsonFormat = Json.format[GentooPenguin]

}
case class GentooPenguin(name: String, age: Int, heightInMeters: Double = 0.70) extends Penguin


object RockhopperPenguin {
  implicit val jsonFormat = Json.format[RockhopperPenguin]
}
case class RockhopperPenguin(name: String, age: Int, heightInMeters: Double = 0.5) extends Penguin

object Penguin {
    implicit val jsonFormat:OFormat[Penguin] = derived.oformat[Penguin]
}
