package com.kwame

import scala.collection.mutable.ArrayBuffer

class ListOfIntG[A] {

  private val list = ArrayBuffer[A]()

  def count = list.size

  def contains(e: A) = list.contains(e)


  def add(e: A) = list += e

  override def toString: String = list.toString()





}
