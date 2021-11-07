package com.kwame

class Trade1 {

  var id: String = ""
  var symbol: String = ""
  var quantity: Int = 0
  private var _price: Double = 0

  def price = _price

  def price_= (newVal: Double) = _price = if (newVal>0) newVal else _price

  override def toString: String = s"id=${id} symbol=${symbol} quantity=${quantity} price=${price}"

  def value() = price * quantity


}

object Trade1 {
  def apply(id: String, symbol: String, quantity: Int, price: Double): Trade1 = {
    val t = new Trade1
    t._price = price
    t.quantity = quantity
    t.symbol = symbol
    t.id = id
    t
  }
}


