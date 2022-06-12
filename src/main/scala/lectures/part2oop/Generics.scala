package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
  }

  val listInt = new MyList[Int]
  val listString = new MyList[String]

  //Generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  //VARIANCE
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //Is a list of Cat == List of Animal?
  //This problem has 3 solutions
  //1. Yes, List[Cat] extends List [Animal]
  class CovariantList[+A]
  val animal: Animal = new Cat
  val covariantList: CovariantList[Animal] = new CovariantList[Cat]

  //2. No Variant list
  class InvariantList[A]
  val inVarList: InvariantList[Animal] = new InvariantList[Animal]

  //3. ContraVariant list
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
}
