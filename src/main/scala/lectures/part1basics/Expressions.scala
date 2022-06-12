package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //Expressions
  println(x)

  val aCondition = true;
  val valueFromCondition = if(aCondition) //If is always an Expression and evaluates to a value
    5
    else
    3
  println(valueFromCondition);

  //Don't write loops. Refer notion notes

  //Unit
  var aValue = 4;
  val aWeirdValue = (aValue = 3)
  //Now the type of aWeirdValue would be Unit
  //Unit is === Void in Java.
  println(aWeirdValue) //The value of Unit is ()

  //This is a codeblock
  val codeBlock = {
    val y = 1
    val z = y + 3

    if(z > 3) "hello" else "lesser"
  }

}
