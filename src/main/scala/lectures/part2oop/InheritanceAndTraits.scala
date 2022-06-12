package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    def eat = println("nomnom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  //Constructors
  class Person(name: String, age: Int)

  //This will throw error.
  //class Adult(name: String, age: Int, idCard: String) extends Person
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
}
