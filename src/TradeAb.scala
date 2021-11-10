package com.kwame

abstract class TradeAb(val id: String, private var _price: Double, val client: Client) {

  def price_= (newVal: Double): Unit = _price = if (newVal > 0) newVal else _price

  def price = _price

  def isExecutable(): Boolean

//  override def toString: String = if (isExecutable())
//    s"${this.getClass}(id=$id,price=$price})"
//  else
//    s"FXTrade (id=${id},price=${price})"

  override def toString: String = s"${this.getClass.getSimpleName}(id=$id,price=$price})"

}


