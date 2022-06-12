package lectures.part2oop

object AnonymousClass {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("Funny")
  }
}
