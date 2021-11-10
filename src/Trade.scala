package com.kwame

class Trade (val id: String, val symbol: String, var quantity: Int,  private var _price: Double) {


  def this(id: String) {
    this(id, null, 0, 0.0)
  }

  def this(id: String, symbol: String) {
    this(id, symbol, 0, 0.0)
  }

  def price_= (newVal: Double): Unit = _price = if (newVal > 0) newVal else _price

  def price = _price

  override def toString: String = s"id=${id} symbol=${symbol} quantity=${quantity} price=${price}"

  def value() = price * quantity


}


