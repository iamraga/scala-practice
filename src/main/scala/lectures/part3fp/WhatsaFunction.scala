package lectures.part3fp

object WhatsaFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) //Can be called like a function

  //Fucntion type in scala
  val stringToIntConverter: (String => Int) = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("3") + 2)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(2, 5))

  //Curried function
  //Function1[Int, Function1[Int, Int]]
  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  //Calling curried function
  println(superAdder(4)(5))
}
trait MyFunction[A,B] {
  def apply(element: A): B //Special meaning
}
