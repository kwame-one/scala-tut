package com.kwame

class Account(val id: Int, var name: String, balance: Double) {

  override def toString: String = s"id=${id} name=${name} balance=${balance}"
}