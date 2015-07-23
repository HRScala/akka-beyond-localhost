package soundplayer

import java.io.{InputStream, File}
import javax.sound.sampled.AudioSystem

object SoundPlayer {

  def playWave(inputStream: InputStream): Unit = {
    val audioIn = AudioSystem.getAudioInputStream(inputStream)
    val clip = AudioSystem.getClip()
    clip.open(audioIn)
    clip.start()
  }

  def playWave(resource: String): Unit = {
    val stream = getClass.getClassLoader.getResourceAsStream(resource)
    playWave(stream)
  }

  def playBeep: Unit = {
    playWave("beep.wav")
  }

  def playBoop: Unit = {
    playWave("boop.wav")
  }

}
