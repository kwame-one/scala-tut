package com.kwame

import scala.collection.mutable.ArrayBuffer

class ListOfInt {

  val list = ArrayBuffer[Int]()

  def count = list.size

  def contains(e: Int) = list.contains(e)

  def sum = list.sum

  def add(e: Int) = list += e

  override def toString: String = list.toString()





}
