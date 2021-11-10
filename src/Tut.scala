package com.kwame

import java.io.File
import java.text.SimpleDateFormat

object Tut extends App {

  def toFahrenheit(celcius: Double) = (celcius * 9 / 5) + 32

  def toFormattedDate(dateStr: String) = {
    val date = new SimpleDateFormat("dd/MM/yy").parse(dateStr)

    val formattedDate = new SimpleDateFormat("d MMMM yyyy").format(date)

    val items = formattedDate.split(" ")

    s"${items(0)}${suffix(items(0).toInt)}  ${items(1)} ${items(2)}"
  }


  def suffix(n: Int): String = {
    if (n >= 11 && n <= 13) "th"
    else {
      n % 10 match {
        case 1 => "st"
        case 2 => "nd"
        case 3 => "rd"
        case _ => "th"
      }
    }
  }


  println(toFormattedDate("13/12/15"))

  println(toFahrenheit(35))


  val data = """root:x:0:0:root:/root:/bin/bash
               |bin:x:1:1:bin:/bin:/sbin/nologin
               |daemon:x:2:2:daemon:/sbin:/sbin/nologin
               |adm:x:3:4:adm:/var/adm:/sbin/nologin
               |lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin
               |sync:x:5:0:sync:/sbin:/bin/sync
               |""".stripMargin.split("\\n")

  val pattern = raw"(root|bin|daemon|adm|lp|sync):(x):(0|1|2|3|4|5):(0|1|2|3|4|7):(root|bin|daemon|adm|lp|sync):/(sbin|root|var/adm|var/spool/lpd|bin):/(bin/bash|sbin/nologin|bin/sync)".r


  for (line <- data) {

      val pattern(username, password, userid, groupId, description, homeDirectory, shell) = line.strip()

      println(username,password, userid, groupId, description, homeDirectory, shell)
  }


  val files = new File(".").listFiles

  files.filter(_.isFile).sortWith(_.length() > _.length()).take(10).foreach(println)

  println("***************")

  files.filter(_.isFile).sortWith(_.length() < _.length()).take(10).foreach(println)

  val equity = new EquityTrade("1", 10.0, null, "aa", 20)
  val fx = new FxTrade("1", 20.00, null)

  println(equity)
  println(fx)

  val transaction = new Transaction("1", 20.0, null,"aa", 5)
  println(transaction.amount())

  val client = new Client("aa", "bb")

  val trade = new EquityTrade("1", 1.00, client, "aa",2)

  client.addTrade(trade)

  println(s"current membership ${client.getMembershipType.getType}")
  client.addTrade(trade)
  client.addTrade(trade)

  println(s"can trade => ${client.canTrade}")

  client.addTrade(trade)
  client.addTrade(trade)

  println(s"can trade => ${client.canTrade}")









}


