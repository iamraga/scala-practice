package lectures.part3fp

object AnonynousFunction extends App {

//  val doubler = new Function[Int, Int] {
//    override def apply(v1: Int): Int = v1 * 2
//  }
  val doubler: Int => Int = x => x * 2
  val adder: (Int, Int) => Int = (a, b) => a + b
  val doSomething: () => Int = () => 3

  println(doSomething) //Prints the function itself.
  println(doSomething()) //Executes the function, Unlike other scala methods.

  //More syntactic sugar
  val incrementer: Int => Int = _ + 1 //Equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //Equivalent to (a,b) => a + b)

}
