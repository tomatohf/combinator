package combinator

// Y = λf. (λx. f (x x)) (λx. f (x x))
// Y g = g (Y g)

object Y {
  type Fun[T, R] = T => R

  def apply[T, R](λf: Fun[T, R] => Fun[T, R]): Fun[T, R] = {
    type ΛX = X => Fun[T, R]
    case class X(λx: ΛX) extends ΛX {
      def apply(x: X) = λx(x)
    }

    val λx: ΛX = x => λf(x(x))(_)
    λx(X(λx))
  }
}
