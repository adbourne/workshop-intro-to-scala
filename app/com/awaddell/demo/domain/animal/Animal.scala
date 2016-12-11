package com.awaddell.demo.domain.animal

import play.api.libs.json._


/**
  * An Animal
  */
object Animal {

  // Polymorphic json declarations are always a bit of a pain wherever you go
  implicit val JsonFormat: Format[Animal] = new Format[Animal] {
    def reads(json: JsValue): JsResult[Animal] = json match {
      case jsObject: JsObject => {
        val entry = jsObject.value.head
        entry._1 match {
          case "BigCat" => Json.fromJson[BigCat](entry._2)(BigCat.jsonFormat)
          case "Monkey" => Json.fromJson[Monkey](entry._2)(Monkey.jsonFormat)
          case "Penguin" => Json.fromJson[Penguin](entry._2)(Penguin.jsonFormat)
          case "Rhinoceros" => Json.fromJson[Rhinoceros](entry._2)(Rhinoceros.jsonFormat)
          case _ => JsError(s"Unknown class '${entry._1}'")
        }
      }

      case _ =>
        JsError(s"Unexpected JSON value $json")
    }

    def writes(animal: Animal): JsValue = {
      val (prod: Product, key: String, sub) = animal match {
        case bigCat: BigCat           => (bigCat, "BigCat", Json.toJson(bigCat)(BigCat.jsonFormat))
        case monkey: Monkey           => (monkey, "Monkey", Json.toJson(monkey)(Monkey.jsonFormat))
        case penguin: Penguin         => (penguin, "Penguin", Json.toJson(penguin)(Penguin.jsonFormat))
        case rhinoceros: Rhinoceros   => (rhinoceros, "Rhinoceros", Json.toJson(rhinoceros)(Rhinoceros.jsonFormat))
      }
      JsObject(Seq(key -> sub))
    }
  }
}
trait Animal {
  def name: String
  def age: Int
}
