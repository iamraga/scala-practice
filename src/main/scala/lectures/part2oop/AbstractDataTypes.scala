package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    val creatureType: String = "Canine"
    def eat: Unit = println("Nomnom")
  }

  //Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  class Crocodile extends Animal with Carnivore { //Gets fields and methods from both class and trait
    override val creatureType: String = "croc"

    override def eat: Unit = println("Eating normal")

    override def eat(animal: Animal): Unit = println(s"eating animal ${animal.creatureType}")
  }
}
