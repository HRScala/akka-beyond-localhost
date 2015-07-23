package org.hrscala

import akka.actor.{ ActorSystem, Props }

object Main extends App {
  val system = ActorSystem("abl")

  system.actorOf(Props[Echoer], "local-echoer")
}
