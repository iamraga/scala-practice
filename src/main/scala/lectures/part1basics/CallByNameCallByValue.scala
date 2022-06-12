package lectures.part1basics

object CallByNameCallByValue extends App {
  def calledByValue(x: Long): Unit = {
    println(x + ": print")
    println(x + ": print")
  }

  def calledByName(x: => Long): Unit = {
    println(x + ": print")
    println(x + ": print")
  }

  calledByName(System.nanoTime())
  calledByValue(System.nanoTime())
}
