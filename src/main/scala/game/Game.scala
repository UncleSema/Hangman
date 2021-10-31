package game

import scala.annotation.tailrec

class Game(private val word: String, private val guessed: String) {
  def currentWord(): String = guessed
  def guess(c: Char): Game = {
    @tailrec
    def go(word: String, guessed: String, answer: String): String =
      if (word.isEmpty) answer
      else if (word.head == c) go(word.tail, guessed.tail, word.head + answer)
      else go(word.tail, guessed.tail, guessed.head + answer)

    new Game(word, go(word, guessed, ""))
  }

}

object Game {
  def newGame(word: String) = new Game(word, "*" * word.length)
}
