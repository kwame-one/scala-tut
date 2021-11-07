package com.kwame

class FxTrade(id: String, _price: Double)
  extends TradeAb(id,_price) {

  override def isExecutable(): Boolean = false

  override def toString: String = s"Fx trade(id=${id},price=${price})"

}
