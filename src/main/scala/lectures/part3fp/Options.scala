package lectures.part3fp

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOptionVal: Option[Int] = None

  //unsafe APIs
  def unsafeMethod(): String = null
  //val result = Some(unsafeMethod()) //WRONG //Might return Some(null)
  val result: Option[String] = Option(unsafeMethod()) //Apply method builds Some or None.
  println(result) //prints None

  def backupMethod(): String = "Hello"
  //backup will be called if first returns None.
  val chainedResult: Option[String] = Option(unsafeMethod()).orElse(Option(backupMethod))

  //Design better methods
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("Yoyo")

  val betterChained = betterUnsafeMethod() orElse betterBackupMethod()

  //functions
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x < 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

}
