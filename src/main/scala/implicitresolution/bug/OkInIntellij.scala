package implicitresolution.bug

object OkInIntellij {

  implicit def listQuicklensFunctor[A] =
    new QuicklensFunctor[List, A] {
      override def map(fa: List[A])(f: A => A): List[A] = fa.map(f)
    }

  def main(args: Array[String]): Unit = {
    val persons = List(Person("John Doe", 28), Person("Jane Doe", 30))

    val x = persons.each.name
  }
}
