package combinator

import scala.util.Try

object Factorial {
  val factorial = Y[Int, Int] { f => n =>
    if (n > 0) n * f(n - 1)
    else 1
  }

  def main(args: Array[String]) {
    for {
      arg <- args
      n <- Try(arg.toInt)
    } println(s"$n! = ${ factorial(n) }")
  }
}
