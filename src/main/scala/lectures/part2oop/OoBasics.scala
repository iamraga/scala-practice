package lectures.part2oop

object OoBasics extends App{
  val person = new Person("Bruce", 20)
  println(person.name)
  println(person.greet("Raga"))
}

class Person(val name: String, age: Int) {
  val x = 2;
  println("Ran when instantiated.")

  def greet(name: String): Unit = println(s"Hi $name, How are you?")

  val author = new Writer("Bruce", "Wayne", 1989)
  val novel = new Novel("Batman", 2010, author)

  println(novel.authAge)
  println(novel.isWrittenBy(author))
}

//OO Exercises
//Novel and writers

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}