package com.kwame

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

  val fx = new FxTrade("1", 10.0)
  println(s"fx trade: id=${fx.id} price=${fx.price}")

  val equity = new EquityTrade("2", 20.00, "aa", 10)
  println(s"equity trade: id=${equity.id} price=${equity.price} symbol=${equity.symbol} quantity=${equity.quantity}")

  val transaction = new Transaction("2", 20.00, "aa", 5)
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

  val subtract = operate("subtract")
  println(subtract(1, 2));

  println(operate("add")(1,2))

  println(operate("power")(2,3))

  val files = (new java.io.File(".")).listFiles

  //exclude hidden files
  val filesNotHidden = files.filter(file => !file.isHidden)

  val filesNotHidden2 = files.filter(file => !file.getName.head.equals('.'))

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


}
