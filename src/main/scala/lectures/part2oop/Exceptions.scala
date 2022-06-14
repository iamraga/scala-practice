package lectures.part2oop

object Exceptions extends App {

//  val x: String = null
//  println(x.length)

  def getInt(withException: Boolean): Int =
    if(withException) throw new RuntimeException("No Int")
    else 40

  try {
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("Runtime")
  }
  finally {
    println("Final")
  }
}
