package game

import java.io.File
import scala.io.Source
import scala.util.{Random, Using}

class Pool(rand: Random) {

  private val words: Vector[String] = {
    val file = new File("src/main/scala/game/words.txt")
    if (file.exists()) Using.resource(Source.fromFile(file)) { reader => reader.getLines().toVector }
    else Vector("Hello")
  }

  def getRandomWord: String = words(rand.nextInt(words.length))
}

object Pool {
  val pool                  = new Pool(new Random())
  def getRandomWord: String = pool.getRandomWord
}
