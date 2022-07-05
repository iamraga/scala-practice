package lectures.part3fp

object HOFsAndCurries extends App {

  //Function that gets executed 'n' times
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n <= 0) x
    else {
      println(s"n $n, $x")
      nTimes(f, n-1, f(x))
    }
  }
  val plusOne: Int => Int = _ + 1
  println(nTimes(plusOne, 10, 2))

  //nTimesBetter - Instead of applying the function to x and returning value, we return a final lambda to be used.
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne,...,(x))
  //val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if(n <= 0) (x: Int) => x
    else {
      (x: Int) => nTimesBetter(f, n-1)(f(x)) //nTimesBetter applied to f(x) to return the function
    }
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(12))

  //Curried function
  //Super adder written earlier
  val superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
}

//HOFs and curries exercises
/*
  1. Expand myList
    - foreach method (A => Unit)
      [1,2,3[.foreach(x => println(x))
    - sort function ((A, A) => Int) => MyList
      [1,2,3].sort((x,y) => y - x) => [3,2,1]
    - zipWith (list, (A,A) => B) => MyList[B]
      [1,2,3].zipwith([4,5,6], x * y) => [1*4, 2*5, 3*6] => [4,10,18]
    - fold (startValue)(function)=> a value
      [1,2,3].fold(0)(x + y) => 6

   2. toCurry (f: (Int, Int) => Int) => (Int => Int => Int)
      fromCurry (g: (Int => Int => Int) => (Int, Int) => Int

   3. compose(f,g) => (x => f(g(x))
      andThen(f,g) => (x => g(f(x))

 */