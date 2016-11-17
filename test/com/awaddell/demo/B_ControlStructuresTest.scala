package com.awaddell.demo

import org.scalatest.FunSuite


/**
  * Demonstrated Scala control structures
  */
class B_ControlStructuresTest extends FunSuite {

  /**
    * If statements
    *
    * The only differences in Scala is that an if is a function so it returns a value
    */
  test("Demonstrate if") {
    val result = if (true) {
      "I'm true!"
    } else {
      "I'm false!"
    }

    println(result)
  }


  /**
    * While loops
    *
    * The same as Java!
    */
  test("Demonstrate while") {

    var count = 0
    val max = 10

    while (count <= max) {
      println(count)
      count += 1
    }
  }


  /**
    * For is a bit different in Scala
    *
    * In Java you might see this:
    *
    * for(int i = 0; i <= 10; i++){
    *     System.out.println(i);
    * }
    *
    * Yeah, there's no equivalent to that in Scala. Instead you
    * pass a Range into the for loop.
    */
  test("Demonstrate for") {

    for (n <- 1.to(10)) {
      println(n)
    }
  }

}
