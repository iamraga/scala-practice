package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  //Seq
  val aSeq = Seq(1,2,3,4)
  println(aSeq)
  println(aSeq.reverse)
  println(aSeq(2)) //Prints 3 - value at index 2
  println(aSeq ++ Seq(5,6)) //List(1,2,3,4,5,6)

  //Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange foreach println

  //List
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  println(prepended)

  //Array
  val arr = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements foreach println

  //Vector
  val vector: Vector[Int] = Vector(1,2,3)

  //Vectors vs list performance test
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      i <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numberList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //Adv: keeps reference to null
  //disadv; Updating middle takes time
  println(getWriteTime(numberList))

  //Adv: Depth of tree is small
  //Disave: needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))




}
