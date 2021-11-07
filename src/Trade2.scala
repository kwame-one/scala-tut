package com.kwame

case class Trade2 (id: String, symbol: String, var quantity: Int,  private var _price: Double) {

  def price = _price

  def price_= (newVal: Double) = _price = if (newVal>0) newVal else _price

}




