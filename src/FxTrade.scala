package com.kwame

class FxTrade(id: String, _price: Double, client: Client)
  extends TradeAb(id,_price, client) {

  override def isExecutable(): Boolean = false

}
