package com.kwame

class EquityTrade(id: String, _price: Double, val symbol: String, val quantity: Int)
  extends TradeAb(id, _price) with Taxable with FeePayable {

  override def isExecutable(): Boolean = true

  override def tax(): Double = 12.5/100

  override def fee(): Double = 10

  def value() = price * quantity

  override def toString: String = s"Equity trade(id=${id},price=${price},symbol=${symbol},quantity=${quantity})"

}
