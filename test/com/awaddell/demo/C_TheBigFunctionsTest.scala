package com.awaddell.demo

import org.scalatest.FunSuite

import scala.annotation.tailrec
import scala.util.Try


/**
  * The big functions!
  *
  * This is where things get interesting! The following functions represent concepts used to construct programs.
  * You're likely to find several classes that implement these functions, especially in the standard libraries.
  *
  * This list is by no means exhaustive!
  *
  */
class C_TheBigFunctionsTest extends FunSuite {

  /**
    * map
    *
    * The concept here is to 'map' an input into an output using a function
    */
  test("Demonstrate map") {

    // Calling map on an Option[T] will let you get at the containing object
    // Essentially you are applying a function to the containing object
    val optionalInt = Some(123)
    val optionalString = optionalInt.map(x => "The number was " + x)
    println(optionalString.getOrElse("The object was empty"))


    // Calling map on a collection will let you apply a function to each element in the collection
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val doubledNumbers = numbers.map(n => n * 2)
    println(doubledNumbers.mkString(", "))
  }

  /**
    * foreach
    *
    * Just like map but doesn't return anything (so has the return type Unit)
    */
  test("Demonstrate foreach") {

    val numbers = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numbers.foreach(n => println(n * 2))
  }

  /**
    * Flatten
    *
    * Flatten allows you to take the type, containing another type, and flatten it the inner type
    */
  test("Demonstrate flatten") {

    // Flattening a Seq[Option[T]] gives you a Seq[T]
    val listOfOptions: Seq[Option[String]] = Seq(
      Some("A"),
      None, // Get's excluded
      Some("B"),
      None, // Get's excluded
      Some("C")
    )

    val listOfStrings: Seq[String] = listOfOptions.flatten
    listOfStrings.mkString(", ")
  }

  /**
    * Flatmap
    *
    * Flatmap is like map and flatten combined. Apply a function and then flatten the output
    */
  test("Demonstrate flatMap") {

    // Lets try converting a list of Strings to Ints, ignoring those that do not represent numbers
    val numberStrings = Seq("1", "2", "pumpkin", "4", "coconut")
    val justTheInts: Seq[Int] = numberStrings.flatMap(n => Try(n.toInt).toOption)
    println(justTheInts.mkString(", "))
  }


  /**
    * The following functions usually only apply to collections
    */


  /**
    * Filter allows you to filter a collection based on a predicate
    */
  test("Demonstrate filter") {

    trait Profession

    case object Butcher extends Profession
    case object Baker extends Profession
    case object CandlestickMaker extends Profession
    case object Spartan extends Profession

    case class Person(name: String, profession: Profession)

    val people = Seq(
      Person("Betty", Butcher),
      Person("Stelios", Spartan),
      Person("Barry", Baker),
      Person("Leonidas", Spartan),
      Person("Catherine", CandlestickMaker)
    )

    val spartans = people.filter { person => person.profession == Spartan }
    println(spartans.mkString(", "))
  }

  /**
    * Head and Tail
    *
    * Any collection can be thought of as having a "head", the first element in the collection, and a tail, the rest of the
    * collection. Corresponding functions exist on most collections in order to return these elements. These functions
    * are super handy when recursively iterating through a collection.
    *
    *  ()()()()()()()()()()()()()
    * |_||_______________________|
    * H             T
    */
  test("Demonstrate Head and Tail") {

    val numbers = Seq(4, 8, 15, 16, 23, 42)

    @tailrec // Ensures a compile-time error if tail recursion not present
    def calculateTotal(numbers: Seq[Int], total: Int = 0): Int = {
      if(numbers.isEmpty){
        total
      }else{
        val newTotal = total + numbers.head
        calculateTotal(numbers.tail, newTotal)
      }
    }

    println("Total: " + calculateTotal(numbers))
  }

  /**
    * foldLeft and foldRight
    *
    * The foldX functions accept an initial value AND a function, accepting a type of the initial value and the type
    * contained in the collection. The function should return the type of the initial value. The function is applied to
    * each element in the collection passing the result forward to a function call on the next element in the collection.
    *
    * Essentially the foldX functions are the equivalent to having a variable updated outside of a for loop.
    *
    * foldLeft applies the function to the elements in the collection from left to right, while foldRight applies the
    * function from right to left.
    *
    */
  test("Demonstrate foldLeft and foldRight") {

    val numbers = Seq(4, 8, 15, 16, 23, 42)

    // Starts with a initial value '0', afterwards known as 'accumulator' and then adds each element in the sequence,
    // starting with the LEFT most, to it.
    // N.B: This is actually the equivalent to .sum
    val foldLeftTotal = numbers.foldLeft(0)( (current, accumulator) =>  { // A curried function - a function with two sets of parenthesis
      accumulator + current
    })
    println("Fold left total: " + foldLeftTotal)


    // Starts with a initial value '0', afterwards known as 'accumulator' and then adds each element in the sequence,
    // starting with the RIGHT most, to it.
    // N.B: Still the equivalent to .sum
    val foldRightTotal = numbers.foldRight(0)( (current, accumulator) =>  { // A curried function - a function with two sets of parenthesis
      accumulator + current
    })

    println("Fold right total: " + foldRightTotal)

  }

}
