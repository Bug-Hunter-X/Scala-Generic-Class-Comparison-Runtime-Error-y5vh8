```scala
import scala.math.Ordering

class MyClass[T](val value: T)(implicit ordering: Ordering[T]) {
  def compare(other: MyClass[T]): Int = {
    ordering.compare(value, other.value)
  }
}

val myInt = new MyClass(10)
val myDouble = new MyClass(10.0)

println(myInt.compare(myDouble)) //This will now work correctly

//Alternative solution with explicit type handling:
class MyClass2[T](val value: T) {
  def compare(other: MyClass2[T]): Int = value match {
    case i: Int => other.value match {
        case j: Int => i.compareTo(j)
        case _ => throw new IllegalArgumentException("Type mismatch")
      }
    case d: Double => other.value match {
        case e: Double => d.compareTo(e)
        case _ => throw new IllegalArgumentException("Type mismatch")
      }
    case _ => throw new IllegalArgumentException("Unsupported type")
  }
}

val myInt2 = new MyClass2(10)
val myDouble2 = new MyClass2(10.0)

println(myInt2.compare(myDouble2))
```