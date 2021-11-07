package com.kwame

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Tut extends App {

  def toFahrenheit(celcius: Double) = (celcius * 9 / 5) + 32

  println(toFahrenheit(30))

  val dateStr = "01/02/15"
  val formatter = DateTimeFormatter.ofPattern("dd/M/y")
  val localDate = LocalDate.parse(dateStr, formatter)


  val data = """root:x:0:0:root:/root:/bin/bash
               |bin:x:1:1:bin:/bin:/sbin/nologin
               |daemon:x:2:2:daemon:/sbin:/sbin/nologin
               |adm:x:3:4:adm:/var/adm:/sbin/nologin
               |lp:x:4:7:lp:/var/spool/lpd:/sbin/nologin
               |sync:x:5:0:sync:/sbin:/bin/sync
               |""".stripMargin


  println(data)

}


