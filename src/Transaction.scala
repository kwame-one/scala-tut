package com.kwame

class Transaction(id: String, _price: Double, symbol: String, quantity: Int)
  extends EquityTrade(id, _price,  symbol, quantity) {

  def amount() = {
    val total = value() + fee()
    total + tax() * total
  }


}
