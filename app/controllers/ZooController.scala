package controllers

import com.awaddell.demo.domain.animal._
import com.awaddell.demo.domain.animal.Animal._
import play.api.libs.json.Json
import play.api.mvc._

import scala.util.Try


/**
  * In this controller we will implement some functions to return information about a fictional zoo.
  * Complete tests for each of the functions below can be found in 'ZooControllerTest'.
  *
  * Stuck? Take a look through this project's tests for inspiration.
  */
class ZooController extends Controller {

  private val myZoo = Zoo.myZoo


  /**
    * Example - Return all of the animals as Json objects
    */
  def allOfTheAnimals = Action {
    Ok(Json.toJson(myZoo.animals))
  }

  /**
    * Task 1 - Return only the animals who are 20 and over
    */
  def animals20AndOver = Action {
    NotImplemented("Remember the 90's?")
  }

  /**
    * Task 2 - Return all the big cats from myZoo
    */
  def bigCats = Action {
    NotImplemented("Here kitty kitty!")
  }

  /**
    * Task 3 - Return all of the big cats, but this time order them from fastest to slowest
    */
  def bigCatsOrderedByTopSpeed = Action {
    NotImplemented("Ready, set... go!")
  }

  /**
    * Task 4 - Populate and return a sequence of 'AnimalSummary' objects populated from each animal
    *
    *  Hint - Get a classes type as a string like so: someClass.getClass.getSimpleName
    */
  def animalsSummary = Action {
    NotImplemented("Just sum it up for me!")
  }

  /**
    * Task 5 - Taking a rhino's temperature can be difficult. In fact, when a rhino doesn't want their
    *   temperature taken they throw an Exception! Implement this function to return a sequence of only
    *   the rhino's gracious enough to let their temperature be taken using the type 'RhinoWithTemp'
    *
    *   Hint - Each rhino already has the method 'takeTemperatureInDegC: Try[Double]'
    */
  def rhinoTemp = Action {
    NotImplemented("Good luck!")
  }

}
