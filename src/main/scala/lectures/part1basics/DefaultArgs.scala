package lectures.part1basics

object DefaultArgs extends App {

  def tailRecFactorial(n: Int, accumulator: Int = 1): Int = {
    if(n <= 1) accumulator
    else tailRecFactorial(n - 1, n * accumulator)
  }

  tailRecFactorial(10)
}
