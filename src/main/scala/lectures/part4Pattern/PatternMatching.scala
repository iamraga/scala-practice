package lectures.part4Pattern

import scala.util.Random

object PatternMatching extends App {

  //Switch on steroids
  val random = new Random
  val number = random.nextInt(10)

  val desc = number match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "TRERER"
    case _ => "Wild yoyo"
  }

  println(number, desc)

  //Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) => s"Hi, I'm $n and I'm $a" //Decomposed values and used them
    case _ => "Who am I?"
  }

}
