package lectures.part3fp

import scala.util.{Failure, Success, Try}

object Exceptions extends App {

  //Create success
  val success = Success(3);
  val failure = Failure(new RuntimeException("Failure"))

  println(success)
  println(failure)

  def unsafe(): String = throw new RuntimeException("Failure super")

  val potentialFailure = Try {
    unsafe()
  }
  println(potentialFailure.isSuccess)

  //OrElse
  def successMethod(): String = "Hello"
  val chainingOrElse = Try(unsafe()).orElse(Try(successMethod()))
  println(chainingOrElse)
}
