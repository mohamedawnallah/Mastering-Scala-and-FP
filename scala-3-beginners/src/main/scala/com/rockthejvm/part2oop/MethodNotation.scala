package com.rockthejvm.part2oop

import scala.annotation.targetName
import scala.language.postfixOps

/**
 * 1) Infix notation in scala allow the method (with only one argument) to sit between object and argument of that method
 * 2) Infix notation is useful when you wanna create user-defined operators in scala
 * 3) Infix notation vs Dot notation
 * 4) Prefix notation (unary operators)
 * 5) Postfix notation (heavily discouraged) -> stick with dot notation with methods takes no arguments
 * 6) Unary operators supported by the scala: -, +, ~(1st compliment bitwise negation), !
 * 7) Apply function has a special meaning in function you could call invocation the object like as a function
 */
object MethodNotation {

  class Person(val name: String, val age: Int, favoriteMovie: String) {
    infix def likes(movie: String): Boolean =
      movie == favoriteMovie

    infix def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    infix def +(nickname: String): Person =
      new Person(s"${this.name} $nickname", this.age, this.favoriteMovie)

    // prefix notation
    def unary_- : String =
      s"$name's alter ego"

    def unary_+ : Person =
      new Person(this.name, this.age + 1, this.favoriteMovie)

    // postfix notation
    def isAlive: Boolean = true

    def apply(): String =
      s"Hi, my name is $name and I really enjoy my $favoriteMovie"

    def apply(times: Int): String =
      s"$name watched $favoriteMovie $times times"
  }
  def main(args: Array[String]): Unit = {
    val khaled = Person("Khaled", 225, "N/A")
    val ahmed = Person("Ahmed", 40, "N/A")
    val greet = "Hello"
    val name = "John"
    val message = greet.concat(" ").concat(name) // using dot notation
    val greeting = greet concat " " concat name // using infix notation
    val khaledAwesome = khaled + "Awesome"
    assert(message == greeting)
    assert(!(khaled likes "Film1"))
    assert(khaled + ahmed == "Khaled is hanging out with Ahmed")
    assert(khaled + ahmed == khaled.+(ahmed))
    assert(2.+(3) == 2 + 3)
    assert(-khaled == "Khaled's alter ego")
    assert(khaled.isAlive)
    assert(khaled isAlive)
    assert(khaled.apply() == khaled())
    assert(khaledAwesome.name == "Khaled Awesome")
    assert((+khaledAwesome).age == 226)
    assert(khaled.apply(3) == "Khaled watched N/A 3 times")

  }
}
