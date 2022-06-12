package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favMovie: String) {
    def likes(movie: String): Boolean = movie == favMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"${this.name}, negative"
    def apply() : String = s"$name this is applied"
  }

  val mary = new Person("Mary", "Inception")

  val tom = new Person("Tom", "Fight club")
  println(mary hangoutWith tom)
  println(!mary)

  println(mary())
}
