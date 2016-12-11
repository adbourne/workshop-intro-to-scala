package controllers

import com.awaddell.demo.domain.animal.{RhinoWithTemp, AnimalSummary, Zoo, Animal}
import org.scalatest._
import play.api.test._
import play.api.test.Helpers._


class ZooControllerTest extends FlatSpec with BeforeAndAfterEach with Matchers {

  var zooController: ZooController = _


  override def beforeEach(testData: TestData) = {
    zooController = new ZooController
  }


  "allOfTheAnimals" should "return all of the animals" in {
    val result = contentAsJson(zooController.allOfTheAnimals.apply(FakeRequest()))
    val animals = result.as[Seq[Animal]]
    assert(Zoo.myZoo.animals === animals)
  }

  "animals20AndOver" should "return all of the animals who are 20 and over" in {
    val result = contentAsJson(zooController.animals20AndOver.apply(FakeRequest()))
    val animals = result.as[Seq[Animal]]
    val expected = Seq(
      Zoo.TimTheCapuchin,
      Zoo.FlynnTheCapuchin,
      Zoo.RossTheRhino,
      Zoo.DaveTheRhino,
      Zoo.BobTheRhino,
      Zoo.RickTheRhino
    )

    assert(expected === animals)
  }

  "bigCats" should "return just the big cats" in {
    val result = contentAsJson(zooController.bigCats.apply(FakeRequest()))
    val animals = result.as[Seq[Animal]]
    val expected = Seq(
      Zoo.BrianTheLion,
      Zoo.PeterTheCheetah,
      Zoo.RitaTheCheetah,
      Zoo.AnitaTheCheetah,
      Zoo.MrSheppardTheLeopard
    )

    assert(expected === animals)
  }

  "bigCatsOrderedByTopSpeed" should "return just the big cats ordered by top speed ascending" in {
    val result = contentAsJson(zooController.bigCatsOrderedByTopSpeed.apply(FakeRequest()))
    val animals = result.as[Seq[Animal]]
    val expected = Seq(
      Zoo.MrSheppardTheLeopard,
      Zoo.BrianTheLion,
      Zoo.PeterTheCheetah,
      Zoo.RitaTheCheetah,
      Zoo.AnitaTheCheetah
    )

    assert(expected === animals)
  }

  "animalsSummary" should "return a summary of all of the animals" in {
    val result = contentAsJson(zooController.animalsSummary.apply(FakeRequest()))
    val animals = result.as[Seq[AnimalSummary]]
    val expected = Seq(
      AnimalSummary("Lion", "Brian", 10),
      AnimalSummary("Cheetah", "Peter", 8),
      AnimalSummary("Cheetah", "Rita", 9),
      AnimalSummary("Cheetah", "Anita", 9),
      AnimalSummary("Leopard", "Mr Shepard", 15),
      AnimalSummary("Capuchin", "Tim", 35),
      AnimalSummary("Capuchin", "Flynn", 33),
      AnimalSummary("Mandrill", "Phil", 15),
      AnimalSummary("Marmoset", "Lynette", 10),
      AnimalSummary("Tamarin", "Tammy Lynn", 7),
      AnimalSummary("EmperorPenguin", "Meghan", 8),
      AnimalSummary("GentooPenguin", "Kevin", 17),
      AnimalSummary("RockhopperPenguin", "Keegan", 9),
      AnimalSummary("BlackRhinoceros", "Ross", 45),
      AnimalSummary("IndianRhinoceros", "Dave", 40),
      AnimalSummary("JavanRhinoceros", "Bob", 30),
      AnimalSummary("WhiteRhinoceros", "Rick", 48)
    )

    assert(expected === animals)
  }

  "rhinoTemp" should "return a sequence of 'RhinoWithTemp' populated with rhinos who gave their temperature" in {
    val result = contentAsJson(zooController.rhinoTemp.apply(FakeRequest()))
    result.as[Seq[RhinoWithTemp]]
  }

}
