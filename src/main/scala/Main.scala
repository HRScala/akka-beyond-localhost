package org.hrscala

import akka.actor._
import akka.pattern._
import scala.concurrent.duration._

object Main extends App {
  val system = ActorSystem("abl")

  val mainActor = system.actorOf(Props[MainActor], "main")
  mainActor ! "run"
}

class MainActor extends Actor {
  import context.dispatcher

  def receive = {
    case "run" =>
      val local = context.actorOf(Props[Echoer], "echoer")
      local ! Echo("Ja sam lokalan: " + local)

      val localSelection = context.actorSelection("akka.tcp://abl@marko-node:11111/user/main/echoer")
      localSelection ! Echo("Ja sam localSelection: " + localSelection)

      val remote = context.actorSelection("akka.tcp://abl@ivan-node:8080/user/local-echoer")
      remote ! Echo("Ja sam remote: " + remote)
      remote.resolveOne(10 seconds) pipeTo self

      val remoteInstantiated = context.actorOf(Props[Echoer], "ivan")
      remoteInstantiated ! Echo("Ja sam remoteInstantiated: " + remoteInstantiated)

    case a: ActorRef =>
      context.watch(a)

    case msg =>
      println("Got response: " + msg)
  }
}
