package com.awaddell.demo.domain.animal

import play.api.libs.json.Json


/**
  * Represents a Zoo
  */
object Zoo {

  val BrianTheLion = Lion("Brian", 10)

  val PeterTheCheetah = Cheetah("Peter", 8)
  val RitaTheCheetah  = Cheetah("Rita", 9)
  val AnitaTheCheetah = Cheetah("Anita", 9)

  val MrSheppardTheLeopard = Leopard("Mr Shepard", 15)

  val TimTheCapuchin   = Capuchin("Tim", 35)
  val FlynnTheCapuchin = Capuchin("Flynn", 33)

  val PhilTheMandrill = Mandrill("Phil", 15)

  val LynetteTheMarmoset = Marmoset("Lynette", 10)

  val TammyLynnTheTamarin = Tamarin("Tammy Lynn", 7)

  val MeghanThePenguin = EmperorPenguin("Meghan", 8)
  val KevinThePenguin  = GentooPenguin("Kevin", 17)
  val KeeganThePenguin = RockhopperPenguin("Keegan", 9)

  val RossTheRhino = BlackRhinoceros("Ross", 45)
  val DaveTheRhino = IndianRhinoceros("Dave", 40)
  val BobTheRhino  = JavanRhinoceros("Bob", 30)
  val RickTheRhino = WhiteRhinoceros("Rick", 48)

  val myZoo = Zoo(Seq(
    BrianTheLion,
    PeterTheCheetah,
    RitaTheCheetah,
    AnitaTheCheetah,
    MrSheppardTheLeopard,
    TimTheCapuchin,
    FlynnTheCapuchin,
    PhilTheMandrill,
    LynetteTheMarmoset,
    TammyLynnTheTamarin,
    MeghanThePenguin,
    KevinThePenguin,
    KeeganThePenguin,
    RossTheRhino,
    DaveTheRhino,
    BobTheRhino,
    RickTheRhino
  ))

  implicit val toJson = Json.format[Zoo]

}

case class Zoo(animals: Seq[Animal])
