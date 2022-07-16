package lectures.part4Pattern

import lectures.part2oop.{EmptyList, MyList}

object AllThePatterns extends App {

  val x: Any = "Scala"

  //Constants
  val matching = x match {
    case 1 => "One"
    case "Scala" => "scala"
    case true => "Truth"
    case AllThePatterns => "SingleClass" //Singleton object
  }
  //Match anything
  val matchAnything = x match {
    case _ => ""
  }
  //Match variable
  val matching1 = x match {
    case something => s"hello this is $something"
  }
  //Tuple match
  val aTuple = (2,2)
  val matchTuple = aTuple match {
    case (1,1) => "Ones"
    case (something, 2) => s"Use the variable here $something"
  }

  val nestedTuple = (1,(2,3))
  val nestedMatch = nestedTuple match {
    case (_, (2, x)) => s"First ${_} and $x"
  }

  //Case classes
  val aList: MyList[Int] = Cons(1, Cons(2, EmptyList))
  val matchList = aList match {
    case EmptyList => "Empty"
    case Cons(head, tail) => s"using variables"
    case Cons(head, Cons(subHead, subTail)) => s"decompose everything"
  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,_) :+ 42 => "lala"// infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  val anything: Any = ???
  anything match {
    case _: RuntimeException | _:NullPointerException => ""
  }


}
