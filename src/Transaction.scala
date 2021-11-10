package com.kwame

class Transaction(id: String, _price: Double, client: Client, symbol: String, quantity: Int)
  extends EquityTrade(id, _price, client,  symbol, quantity) with Taxable with FeePayable {

  def amount() = {
    val subtotal = value() + fee()
    subtotal + tax() * subtotal
  }


}
