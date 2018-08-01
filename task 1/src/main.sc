abstract class any2(x: Any) {
  def assign(y: Any)
  def show()
}

class anyVar(var x: Any) extends any2(x){
  override def assign(y: Any) = x = y
  def show() = {
    println(x)
    println(" <- is the current value\n ")
  }
}

class anyVal(x: Any) extends any2(x){
  override def assign(y: Any) = println("ERROR - Cannot assign: " + y
    + " to a val ")
  def show() = {
    println(x)
    println(" <- is the current value\n ")
  }
}

var x = new anyVar(12)
x.show()
x assign 6
x.show()


var y = new anyVal(23)
y.show()
y assign 999

