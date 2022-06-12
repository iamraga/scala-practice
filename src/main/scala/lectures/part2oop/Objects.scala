package lectures.part2oop

object Objects extends App {

  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(name: String) {

  }
  //Both are companions
  val mary = new Person("Mary")
  val john = new Person("John")

  val bobbie = Person(mary, john) //Calls the apply method to create object. Factory method.
}
