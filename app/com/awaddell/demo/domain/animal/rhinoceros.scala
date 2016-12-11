package com.awaddell.demo.domain.animal

import julienrf.json.derived
import play.api.libs.json.{OFormat, Json}

import scala.util.{Random, Try}


/**
  * Let's hope it never gets to this :O
  *
  * @param msg
  */
class AngryRhinoException(msg: String) extends RuntimeException(msg)


sealed trait Rhinoceros extends Animal {
  val numberOfHorns: Int

  def takeTemperatureInDegC: Try[Double] = Try {
    def randomTemp = {
      val randomness = Random.nextInt(5)
      if (Random.nextBoolean()) 37d + randomness
      else 37d - randomness
    }

    if ((Random.nextInt(10) + 1) <= 3) randomTemp
    else throw new AngryRhinoException("Not today pal!")
  }
}


object JavanRhinoceros {
  implicit val jsonFormat = Json.format[JavanRhinoceros]
}

case class JavanRhinoceros(name: String, age: Int, numberOfHorns: Int = 1) extends Rhinoceros {
}


object BlackRhinoceros {
  implicit val jsonFormat = Json.format[BlackRhinoceros]
}

case class BlackRhinoceros(name: String, age: Int, numberOfHorns: Int = 2) extends Rhinoceros


object WhiteRhinoceros {
  implicit val jsonFormat = Json.format[WhiteRhinoceros]
}

case class WhiteRhinoceros(name: String, age: Int, numberOfHorns: Int = 2) extends Rhinoceros


object IndianRhinoceros {
  implicit val jsonFormat = Json.format[IndianRhinoceros]
}

case class IndianRhinoceros(name: String, age: Int, numberOfHorns: Int = 1) extends Rhinoceros

object Rhinoceros {
  implicit val jsonFormat: OFormat[Rhinoceros] = derived.oformat[Rhinoceros]
}
