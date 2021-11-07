package com.kwame

abstract class TradeAb(val id: String, private var _price: Double) {

  require(_price >= 1)

  def price_= (newVal: Double): Unit = _price = if (newVal > 0) newVal else _price

  def price = _price

  def isExecutable(): Boolean


}


