package com.awaddell.demo.domain.animal

import julienrf.json.derived
import play.api.libs.json.{OFormat, Json}


sealed trait Monkey extends Animal {
  val treeDwelling: Boolean
}


object Mandrill {
  implicit val jsonFormat = Json.format[Mandrill]
}
case class Mandrill(name: String, age: Int, treeDwelling: Boolean = false) extends Monkey


object Capuchin {
  implicit val jsonFormat = Json.format[Capuchin]
}
case class Capuchin(name: String, age: Int, treeDwelling: Boolean = true) extends Monkey


object Marmoset {
  implicit val jsonFormat = Json.format[Marmoset]
}
case class Marmoset(name: String, age: Int, treeDwelling: Boolean = true) extends Monkey


object Tamarin {
  implicit val jsonFormat = Json.format[Tamarin]
}
case class Tamarin(name: String, age: Int, treeDwelling: Boolean = true) extends Monkey


object Monkey {
  implicit val jsonFormat:OFormat[Monkey] = derived.oformat[Monkey]
}

