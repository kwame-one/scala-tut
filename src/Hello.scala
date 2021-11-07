package com.kwame

import scala.io.StdIn.readLine;

class Person(var firstName: String, var lastName: String)

object Hello extends App {

  print("Enter your first name: ")

  val firstName = readLine()

  print("Enter your last name: ")
  val lastName = readLine();

  println(s"your name is ${firstName} ${lastName}")

  val person=  new Person("Kwame", "Gyimah")
  println(person.lastName)

}