```scala
class MyClass[T](val value: T) {
  def compare[U >: T](other: MyClass[U]): Int = {
    if (value == other.value) 0
    else if (value < other.value) -1
    else 1
  }
}

val myInt = new MyClass(10)
val myDouble = new MyClass(10.0)

println(myInt.compare(myDouble)) //This will throw a runtime error in some cases 
```