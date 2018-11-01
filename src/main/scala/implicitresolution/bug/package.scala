package implicitresolution

package object bug {
  case class Person(name: String, age: Int)

  implicit class QuicklensEach[F[_], T](t: F[T])(implicit f: QuicklensFunctor[F, T]) {
    def each: T = sys.error("each")
  }
  trait QuicklensFunctor[F[_], A] {
    def map(fa: F[A])(f: A => A): F[A]
    def each(fa: F[A])(f: A => A): F[A] = map(fa)(f)
  }
}
