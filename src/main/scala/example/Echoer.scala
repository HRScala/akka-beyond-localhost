package org.hrscala

import akka.actor._

class Echoer extends Actor {
  def receive = {
    case e @ Echo(message) =>
      println(message)
      sender ! e
  }
}
