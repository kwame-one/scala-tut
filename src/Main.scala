package com.kwame

import java.io.FileNotFoundException
import scala.util.Random

object Main extends App{

  val trade = new Trade("T1", "APPL", 100, 15.25)
  val trade1 = new Trade("T2")

  println(trade.value())

  val account = new Account(1, "kwame", 10.0)


  val trade2 = Trade1.apply("T1", "APPL", 100, 15.2)

  val trade3 = Trade1("T2", "APPL", 100, 15.2)


  println(trade2)

  trade2.price =  20.0

  println(trade2)

  println(trade2.value())

  println(trade3)

  val t = Trade2("T1", "APPL", 100, 15.25)
  val t1 = Trade2("T1", "APPL", 100, 15.25)

  println(t1.equals(t))

  println(t.hashCode())
  println(t1.hashCode())

  println(t.id)
  println(t.symbol)
  println(t.price)


  println(t)

  val fx = new FxTrade("1", 10.0, null)
  println(s"fx trade: id=${fx.id} price=${fx.price}")

  val equity = new EquityTrade("2", 20.00, null,"aa", 10)
  println(s"equity trade: id=${equity.id} price=${equity.price} symbol=${equity.symbol} quantity=${equity.quantity}")

  val transaction = new Transaction("2", 20.00, null, "aa", 5)
  println(transaction.value()) //100
  println(transaction.amount()) //  123.75


  def operate(operation: String) = (x: Int, y: Int) => {
    operation match {
      case "add" => x+y
      case "subtract" => x-y
      case "power" => scala.math.pow(x,y)
      case _ => 0
    }
  }



  def operate1(operation: String): (Int, Int) => Double = {
    operation match {
      case "add" => (x: Int, y: Int) => x+y
      case "subtract" => (x: Int, y: Int) => x-y
      case "power" => (x: Int, y: Int) => Math.pow(x,y)
    }
  }

  val add = operate1("add");
  println(add(1,3))


  val subtract = operate("subtract")
  println(subtract(1, 2))

  println(operate("add")(1,2))

  println(operate("power")(2,3))

  val files = (new java.io.File(".")).listFiles

  //exclude hidden files
  val filesNotHidden = files.filter(file => !file.isHidden)

  val filesNotHidden2 = files.filter(file => !file.getName.head.equals('.')).map(_.getName)

  val normalFiles = files.filter(file => !file.isDirectory)

  val directories = files.filter(file => file.isDirectory)

  // list of 10 largest files
  val largestFiles = files.filter(_.isFile).sortWith(_.length() > _.length()).take(10)

  val smallestFiles = files.filter(_.isFile).sortWith(_.length() < _.length()).take(10)

//  val largestFilesMap = files.filter(_.isFile)
//    .sortWith(_.length() > _.length())
//    .take(10)
//    .groupBy(x => x)
//    .map(x => x.)


//  val groupedFiles = files.sortWith(_.getName.head > _.getName.head)
//    .groupBy(x => x)
//    .values
//
//  groupedFiles.foreach(println)

  def remove(coll: Seq[Int], idx: Int): Seq[Int] =  coll.filter(x => x != coll(idx))

  println(remove(Seq(1,2,3,4,5), 0))

  var mapOfNumbers = Map[Int, Int]()

  var counter = 1

  while (counter <= 6) {
    val num = Random.between(1, 50)

    if(!mapOfNumbers.contains(num)) {
      mapOfNumbers ++= Map(num -> num)
      counter = counter + 1
    }

  }

  println(mapOfNumbers.values.toList.sortWith(_ < _))

  val listOfInt = new ListOfInt

  listOfInt.add(1)
  listOfInt.add(2)
  listOfInt.add(3)

  println(listOfInt)

  println(listOfInt.count)

  println(listOfInt.contains(1))
  println(listOfInt.contains(4))

  println(listOfInt.sum)

  val newList = new ListOfIntG[Int]

  newList.add(20)
  newList.add(30)
  newList.add(40)

  println(newList)

  println(newList.count)

  println(newList.contains(20))
  println(newList.contains(10))

  val newList1 = new ListOfIntG[String]

  newList1.add("kwame")
  newList1.add("alex")
  newList1.add("freeman")

  println(newList1)

  println(newList1.count)

  println(newList1.contains("alex"))
  println(newList1.contains("john"))


  def divide(a: Int, b: Int) = {
    b match {
      case 0 => None
      case _ => Some(a/b)
    }
  }

  val result = divide(0, 0)
  println(result.getOrElse("divide by zero not allowed"))

  def squareRoot(num: Int) = {
    num match {
      case x if x < 0 => None
      case _ => Some(Math.sqrt(num))
    }
  }

  println(squareRoot(-10).getOrElse("sorry, sqrt for negative numbers are not possible"))
  println(squareRoot(16).getOrElse("sorry, sqrt for negative numbers are not possible"))


  def validValues(seq: Seq[Int]) = {
    val s = seq.map(squareRoot)
    println(s)
    val p = s.filter(x => x.isDefined)
    println(p)
    val r = p.map(_.get)
    println(r)
    r
  }

  val seq = Seq(4,9,16,25,-25,-16,-9, -4)

  validValues(seq)

  def timed(expression: => Any): Long = {
    val start = System.nanoTime()
    val result = expression
    val end = System.nanoTime()
//    println(s"Elapsed time: ${end - start} ns")
    end-start
  }

  timed (List.range(1,1000, 1))
  timed (1+1)


  def fib(n: Int): Long = {
    if (n <= 1) n else fib(n-1) + fib(n-2)
  }

  // 0 1 1 2 3 5 8 13 21 34 55, ...

  def fibTailRec(index: Int): Int = {
    @annotation.tailrec
    def getTailRec(index: Int, prev: Int, current: Int): Int = {
      if (index <= 0) {
        current
      } else {
        getTailRec(index - 1, prev = prev + current, current = prev)
      }
    }

    getTailRec(index, prev = 1, current = 0)
  }
  /*

    fibTailRec(5)
    index = 5
    getTailRec(5, 1, 0)
    getTailRec(5-1, 1+0, 1) => getTailRec(4,1,1)
    getTailRec(4,1,1)
    getTailRec(4-1,1+1,1) => getTailRec(3,2,1)
    getTailRec(3,2,1)
    getTailRec(3-1,2+1,2) => getTailRec(2,3,2)
    getTailRec(2,3,2)
    getTailRec(2-1,3+2,3) => getTailRec(1,5,3)
    getTailRec(1,5,3)
    getTailRec(1-1,5+3,5) => getTailRec(0,8,5)
    5

   */

  println(fib(5))
  println(fibTailRec(5))

  println("***********************")

  def generate(n: Int) = for (item <- 0 until n) print(s"${fib(item)} ")

  generate(10)

  println()
  timed(fib(10))
  timed(fibTailRec(10))

  for (item <- 0 until 10) println(s"(${fibTailRec(item)}, ${timed{fibTailRec(item)}})")

  val squareRoot1 = new PartialFunction[Double, Double] {
    def apply(x: Double) = Math.sqrt(x)
    def isDefinedAt(x: Double) = x match {
      case a if a >= 0 => true
      case a if a < 0 => false
    }
  }

//  println(squareRoot1.isDefinedAt(0))
//  println(squareRoot1.apply(-1))

  val double = new PartialFunction[Double, Double] {
    def apply(x: Double) = x * x
    def isDefinedAt(x: Double) = x < 0
  }


  val result1 = squareRoot1.orElse(double)

  println(result1(16)) // 4
  println(result1(-3)) // 9


//  val handler: PartialFunction[Throwable, Unit] = {
//      case e: ArithmeticException =>  println("arithmetic exception handled")
//      case e: FileNotFoundException =>  println("file not found handled")
//      case _ => println("not handled")
//  }

  val fileNotFound: PartialFunction[Throwable, Unit] = {
    case e: FileNotFoundException =>  println("file not found handled")
  }

  val arithmeticError: PartialFunction[Throwable, Unit] = {
    case e: ArithmeticException =>  println("arithmetic exception handled")
  }

  val baseHandler: PartialFunction[Throwable, Unit] = {
    case _ => println("not handled")
  }

  val handler = fileNotFound.orElse(arithmeticError).orElse(baseHandler)


  try {
    throw new ArrayIndexOutOfBoundsException()
  } catch {
    case exception: Throwable => handler(exception)
  }


//  handler(new FileNotFoundException())
//  handler(new ArrayIndexOutOfBoundsException())
//  handler(new ArithmeticException())

}
