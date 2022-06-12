package lectures.part2oop

abstract class MyList[+A] {

  //Head - return first ele
  //tail - return remainder of list
  //isEmpty - if list is empty
  //add - add element
  //toString

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  //Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, EmptyList)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](headVal: A, tailVal: MyList[A]) extends MyList[A] {
  def head: A = headVal
  def tail: MyList[A] = tailVal
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if(tailVal.isEmpty) "" + headVal
    else headVal + " " + tailVal.printElements

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(headVal)) new Cons(headVal, tailVal.filter(predicate))
    else tailVal.filter(predicate)
  }

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(headVal), tailVal.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(headVal, tailVal ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(headVal) ++ tailVal.flatMap(transformer)
}

//EXercise
/*
generic trait predicate[T] (tests for type T)
generic trait transformerp[A, B] (transforms A to B)
map method takes transformer and returns list
filter takes predicate and returns list
flatmap takes transformer
 */

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object MyListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
  val anotherListOfIntegers = new Cons(2, new Cons(3, new Cons(4, EmptyList)))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }))

  println(anotherListOfIntegers ++ listOfIntegers)
  println(anotherListOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, EmptyList))
  }))
}
