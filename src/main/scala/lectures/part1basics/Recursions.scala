package lectures.part1basics

import scala.annotation.tailrec

object Recursions extends App {

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
//      println("Factorial of " + n + ". Need " + (n-1))
      val result = n * factorial(n - 1)
//      println("Computed factorial: " + n)

      result
    }
  }
  println(factorial(6))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if(x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n, 1)
  }

  anotherFactorial(6)

  //Concatenate string with tail recursion
  def concatenateStr(str: String, n: Int): String = {
    def concatHelper(x: Int, accumulator: String): String = {
      if(x == n) accumulator
      else concatHelper(x + 1, accumulator + str)
    }
    concatHelper(0, "")
  }
  println(concatenateStr("Hello", 5));
}