package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("Ra", 2))

  def noParamFunc() : Int = 42
  println(noParamFunc())
  println(noParamFunc)

  //Fucntions inside functions
  def aBigFunc(a: Int): Int = {
    def smallFunc(b: Int): Int = b * 2

    smallFunc(a * 2)
  }

  println(aBigFunc(3))

  //Factorial function
  def factorial(num: Int): Int = {
    if(num <= 0) 1
    else if(num == 1) num
    else num * factorial(num - 1)
  }
  println(factorial(5))

  //Prime number
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else (n % t != 0 && isPrimeUntil(t-1))

    isPrimeUntil(n/2)

  }
}
