package com.awaddell.demo

import org.scalatest.FunSuite

import scala.util.Try


/**
  * Examples of the Scala programming language
  *
  * To run the tests in just this class:
  * sbt test-only "com.awaddell.demo.A_Scala101Test"
  */
class A_Scala101Test extends FunSuite {

  /**
    * The Basics
    *
    * The 'def' keyword specifies a function
    * The 'val' keyword specifies an immutable variable
    * The 'var' keyword specified a mutable variable
    *
    * Oh, and no need for semi colons!
    *
    */
  test("Variables and functions") {

    val greeting = "Hello" // Once a val is set it can never change!

    var subject = "Badger" // vars can be changed, but always try and use vals!
    subject = "World"

    def makeText(theGreeting: String, theSubject: String): String = {
      s"${theGreeting} ${theSubject}!" // Nice and easy String interpolation, right here!
      // Note that there's no "return" -- the last thing in the function is returned by default
    }

    println(makeText(greeting, subject))
  }


  /**
    * Some common Scala types
    *
    * Note that the type declaration isn't really required but is included here for clarity
    */
  test("Some basic types") {

    val anInt: Int = 123 // With type declaration
    println("Int: " + anInt)

    val anotherInt = 123 // Without type declaration -- this is better!
    println("Another Int: " + anotherInt)

    val aLong: Long = 1234567891011121314L
    println("Long: " + aLong)

    val aDouble: Double = 3.14159
    println("Double: " + aDouble)

    val aString: String = "Hey! I'm a String!"
    println("String: " + aString)
  }


  /**
    * Scala is a pure OO language -- everything is an object!
    *
    * There's no concept of primitives, as in Java, so even basic numbers are objects!
    */
  test("Everything is an object!") {

    val answerOne = 5 + 10 * 15 // Ok this looks pretty straightforward
    val answerTwo = 5.+(10.*(15)) // This means the same as the line above but proves the operators are actually functions!

    println(s"Answer one is '$answerOne'")
    println(s"Answer two is '$answerTwo'")
  }


  /**
    * Some Scala collection types
    */
  test("Some collection types") {

    val aTuple: (String, String) = ("hey", "ho")
    println("Tuple: " + aTuple)

    val anArrayInt: Array[Int] = Array(1, 2, 3, 4, 5, 6)
    println("Array[Int]: " + anArrayInt.mkString(", ")) // Checkout mkString here to join elements into a String - easy!

    val anArrayString: Array[String] = Array("a", "b", "c", "d")
    println("Array[String]: " + anArrayString.mkString(", "))

    val aSequence: Seq[String] = Seq("Apple", "Orange", "Banana") // Like a Java List
    println("Seq[String]: " + aSequence.mkString(", "))

    val aListString: List[String] = List("a", "b", "c", "d", "e") // Like a Java LinkedList
    println("List[String]: " + aListString.mkString(", "))

    val aMapStringString: Map[String, String] = Map(("hey", "ho"), ("let's", "go")) // Note that a map is basically a list of Tuples
    println("Map[String, String]: " + aMapStringString.mkString(", "))
  }


  /**
    * Making new classes in Scala is just SO EASY
    */
  test("Making plain old scala classes like a baws") {
    case class Animal(name: String, age: Int) // Boom! A proper class with a constructor, getters/setters, toString, equals and hashCode.
    val rabbitA = Animal.apply("Roger", 5) // A constructed Animal! Noted we don't use the 'new' keyword we call the 'apply' function instead
    val rabbitB = Animal("Thumper", 4) // rabbitA is constructed in the same way as rabbitB, however rabbitB uses the shorthand way.

    val rabbitName = rabbitA.name // Note that Scala getters/setters aren't prefixed with get/set but can still be overridden

    println("Rabbit A: " + rabbitA.toString + "\nRabbit B: " + rabbitB.toString)
  }


  /**
    * Scala has a nice functional way of handling null pointers
    * An Option[T] is either an instance of T or a None
    *
    * Option[T] is an example of a functional concept called a "monad". Now, you don't need to know all about monads
    * in order to use them, but if you want to: http://learnyouahaskell.com/a-fistful-of-monads#monad-laws
    *
    * Options are super-handy when used in collections
    */
  test("The Option type") {
    val maybeString: Option[String] = Some("Yeah, I'm a String")
    println(maybeString.getOrElse("Nothing here!")) // The safe way of dealing with an option
    println(maybeString.get) // The un-safe way -- throws a RuntimeException if the option is None


    val maybeNotString: Option[String] = None
    println(maybeNotString.getOrElse("Nothing here!"))
  }


  /**
    * Pattern Matching
    *
    * There's a big argument for pattern matching. Scala's pattern matching is an awesome way of really making use of
    * Scala's type system.
    *
    */
  test("Pattern matching is cool") {

    // We can't inherit from a case class so let's make a normal class
    class Animal(theName: String) {
      def name: String = this.theName
    }

    case class Zebra(override val name: String, stripes: Int) extends Animal(name)
    case class Moose(override val name: String, canSing: Boolean) extends Animal(name)
    case class Penguin(override val name: String, knownAlias: Option[String]) extends Animal(name)
    case class Duck(override val name: String) extends Animal(name)

    val theBestZooEver = Seq(
      Zebra("Zoe", 22),
      Zebra("Zack", 20),
      Moose("Marshall", canSing = true),
      Moose("Marcy", canSing = false),
      Penguin("Peter", Some("the funny one")),
      Penguin("Percy", Some("the smart one")),
      Penguin("Rodney", None),
      Duck("Tim")
    )

    def describeMyZoo(animal: Animal): String = {
      animal match {
        case Penguin(name: String, Some(alias: String)) => s"a penguin called $name who we call $alias"
        case Penguin(name: String, None)                => s"a penguin called $name"
        case Moose(name: String, canSing: Boolean)      => s"we have a moose called $name".concat(if (canSing) " who can sing" else "")
        case Zebra(name: String, stripes: Int)          => s"we got a zebra called $name with $stripes stripes"
        case animal: Animal                             => s"then there's ${animal.name}"
      }
    }

    println("My zoo's great! " + theBestZooEver.map(describeMyZoo).mkString(", ")) // Don't worry too much about .map, we'll cover that later
  }


  /**
    * Exceptions
    *
    * Exceptions work just like Java, with one exception (hah!); there are no checked Exceptions in Scala!
    *
    * In Java a checked exception is one of those that you explicitly declare as being thrown e.g (throws SomeWackyException)
    * and then have to catch. But there are other ways of handling that behavior so we only have unchecked Exceptions in Scala
    * for when everything is burning down D:
    */
  test("I Exception like a Java, sort of") {

    case class CustomException(msg: String) extends RuntimeException(msg)

    def doADangerousThing() = {
      throw new CustomException("Haha, nope!")
    }

    try {
      doADangerousThing()

    } catch {
      // Note that we use pattern matching for
      case ex: CustomException  => println("We got a custom exception with message " + ex.getMessage)
      case ex: RuntimeException => println("We got a runtime exception with message " + ex.getMessage)
    }
  }


  /**
    * Exceptions - Try, try and Try again
    *
    * There's a few ways of dealing with Exceptions in Scala. One new way is by using the Try (big "T") construct.
    * If you think something is going to throw an Exception then try wrapping it in a Try. You can then
    * deal with the Try[T] in a very similar way to an Option[T].
    */
  test("Exception's new tricks") {

    def doAnotherDangerousThing(): Try[String] = Try {
      throw new RuntimeException("Haha, double nope!")
    }

    val result = doAnotherDangerousThing()

    result.getOrElse("An exception was thrown, I'm afraid :/")
  }


  /**
    * Converting between types
    *
    * We don't use casts in Scala but instead use functions (see the pattern yet?) to convert between types.
    * If your class doesn't know how to convert to another type, teach it with a function!
    *
    * It's quite common for a type converter function to return an Option[T] or Try[T] to cover cases when a type
    * conversion could go wrong!
    */
  test("Converting between types with functions") {
    val someNumberString = "500"
    val someNumber = someNumberString.toInt // Note that we can drop the parenths for function calls with no args

    println("My number was: " + someNumber)
  }


  /**
    * Java class != Scala Class
    *
    * Statics in Java, you either love them or hate them. In Scala you can still do statics
    * but they don't live in a class... they live in an object! An object is like an all static singleton class
    * that doesn't have to be constructed.
    *
    * I think of it like splitting a Java class's responsibilities down the middle:
    *
    * _________________         __________________
    * | Java Class     |        | Scala Object   |
    * | ==========     |        | ==========     |
    * | Static stuff   |        | Static stuff   |
    * | Instance stuff |        |________________|
    * |                |   =~   __________________
    * |                |        | Scala Class    |
    * |                |        | ==========     |
    * |                |        | Instance stuff |
    * |________________|        |________________|
    *
    *
    * So each class in Scala has a "companion object" even if you don't specify one. It's
    * actually where a class's apply function(s) lives.
    *
    */
  test("A Class vs an Object") {
    object FighterPilot {
      // "All the args" constructor is invisible!

      // Secondary constructor
      def apply(callSign: String) = {
        new FighterPilot(callSign = callSign, wingman = None, egoWritingChecksBodyCantCash = false)
      }

    }
    case class FighterPilot(callSign: String, wingman: Option[FighterPilot], egoWritingChecksBodyCantCash: Boolean)

    val goose = FighterPilot("Goose")
    val maverick = FighterPilot("Maverick", wingman = Some(goose), egoWritingChecksBodyCantCash = true)
    val iceMan = FighterPilot("Ice Man")

    println(goose.toString)
    println(maverick.toString)
    println(iceMan)
  }


  /**
    * Traits
    *
    * Think of a Scala trait like a Java interface, except you can have concrete implementations of things in a Scala
    * trait.
    *
    * In fact, in Scala you can inherit from multiple traits in one go! Yeah, that's right, multiple inheritance!
    *
    * Both classes and objects can inherit from traits.
    */
  test("Show me your traits") {

    trait Wiggly {
      def wiggle: String = "I'm wiggling!"
    }

    trait Venomous {
      def bite: String
    }

    class Worm extends Wiggly // A wiggly worm!
    class Snake extends Wiggly with Venomous {
      // A wiggle AND venomous snake
      def bite: String = "I'm gonna bite you!"

      override def wiggle: String = "I'm wiggling...venomoussssly...."
    }
  }

}
