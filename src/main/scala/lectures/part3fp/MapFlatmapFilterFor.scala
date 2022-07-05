package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list)

  //Map
  println(list.map(_ + 1))

  //filter
  println(list.filter(_ <= 2))

  //flatmap
  val twoPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(twoPair))

  //Print all combinations of numbers and characters. Two lists.
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "White")

  //rewritten below with for comprehensions
  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  //for comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)
}
