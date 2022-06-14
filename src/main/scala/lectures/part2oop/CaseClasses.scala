package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 20)
  println(jim)

  val jim2 = new Person("Jim", 20)
  println(jim.equals(jim2))
}
