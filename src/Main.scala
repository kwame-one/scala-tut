package com.kwame

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

}
