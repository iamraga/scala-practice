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

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  //foreach
  def foreach(f: A => Unit): Unit
  //sort
  def sort(compare: (A,A) => Int): MyList[A]
}

object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, EmptyList)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = EmptyList
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = EmptyList
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = EmptyList
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //HOFs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = EmptyList
}

class Cons[+A](headVal: A, tailVal: MyList[A]) extends MyList[A] {
  def head: A = headVal
  def tail: MyList[A] = tailVal
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if(tailVal.isEmpty) "" + headVal
    else headVal + " " + tailVal.printElements

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(headVal)) new Cons(headVal, tailVal.filter(predicate))
    else tailVal.filter(predicate)
  }

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(headVal), tailVal.map(transformer))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(headVal, tailVal ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(headVal) ++ tailVal.flatMap(transformer)

  //HOFs
  def foreach(f: A => Unit): Unit = {
    f(headVal)
    tailVal.foreach(f)
  }

  //sort
  def sort(compare: (A,A) => Int): MyList[A] = {
    def insert(x: A, sortedTailList: MyList[A]): MyList[A] = {
      if(sortedTailList.isEmpty) new Cons(x, EmptyList)
      else if(compare(x, sortedTailList.head) <= 0) new Cons(x, sortedTailList)
      else new Cons(sortedTailList.head, insert(x, sortedTailList.tail))
    }
    val sortedTailList = tailVal.sort(compare)
    insert(headVal, sortedTailList)
  }
}

//EXercise
/*
generic trait predicate[T] (tests for type T)
generic trait transformerp[A, B] (transforms A to B)
map method takes tansformer and returns list
filter takes predicate and returns list
flatmap takes transformer
 */

object MyListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
  val anotherListOfIntegers = new Cons(2, new Cons(3, new Cons(4, EmptyList)))

  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }))

  println(anotherListOfIntegers ++ listOfIntegers)
  println(anotherListOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, EmptyList))
  }))

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => y - x))
}
