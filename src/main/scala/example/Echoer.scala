package org.hrscala

import akka.actor._
import soundplayer.SoundPlayer

class Echoer extends Actor {
  def receive = {
    case e @ Echo(message) =>
      println(message)
      sender ! e

    case "boop" =>
      SoundPlayer.playBoop
      sender ! "beep"

    case "beep" =>
      SoundPlayer.playBeep

  }
}
