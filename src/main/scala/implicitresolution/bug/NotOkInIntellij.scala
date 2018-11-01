package implicitresolution.bug

import scala.collection.TraversableLike
import scala.collection.generic.CanBuildFrom

object NotOkInIntellij {

  implicit def traversableQuicklensFunctor[F[_], A](implicit cbf: CanBuildFrom[F[A], A, F[A]], ev: F[A] => TraversableLike[A, F[A]]) =
    new QuicklensFunctor[F, A] {
      override def map(fa: F[A])(f: A => A): F[A] = fa.map(f)
  }

  def main(args: Array[String]): Unit = {
    val persons = List(Person("John Doe", 28), Person("Jane Doe", 30))

    val x = persons.each.name
  }
}
