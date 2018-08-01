//NEW SYSTEM

abstract class Any2(init: Any) {
  def assign(param: Any)
  def value()
}

class AnyVal(init: Any) extends Any2(init){
  override def assign(param: Any) = {
    throw new Exception("Object inmutable. You cannot change it's value.")
  }
   def value() = {
    println(" value: " + init)
  }
}

class AnyVar(var init: Any) extends Any2(init){
  override def assign(param: Any) = {
    init = param
  }
   def value() = {
    println(" value: " + init)
  }
}

//TEST WITH INT
var x = new AnyVar(0)
x.value()
x.assign(20)
x.value()
//TEST WITH STRING
x.assign("Hellow World")
x.value()
//TEST WITH BOOLEAN
x.assign(true)
x.value()

//TEXT WITH INT
var y = new AnyVal(96)
y.value()

//TEXT WITH STRING
var w = new AnyVal("Hellow World 2")
w.value()

//TEST WITH BOOLEAN
var z = new AnyVal(true)
z.value()

//Trying to reassign
y.assign(10)
y.value()

w.assign("Lorem Ipsum")
w.value()

z.assign(false)
z.value()





