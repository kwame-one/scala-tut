package com.kwame

class EquityTrade(id: String, _price: Double, client: Client, val symbol: String, val quantity: Int)
  extends TradeAb(id, _price, client)  {

  override def isExecutable(): Boolean = client.canTrade

  def value() = price * quantity


}
