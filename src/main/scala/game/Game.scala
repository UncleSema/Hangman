package game

import game.Answers.Answer

import scala.annotation.tailrec

class Game(private val word: String, private val guessed: String, val mistakes: Int) {
  val MAX_MISTAKES = 5

  def currentWord(): String = guessed

  def check(c: Char): Answer =
    if (!word.contains(c)) Answers.Wrong
    else if (!guessed.contains(c)) Answers.Right
    else Answers.Asked

  def guess(c: Char): Game = {
    if (!word.contains(c)) new Game(word, guessed, mistakes + 1)
    else {
      @tailrec
      def go(word: String, guessed: String, answer: String): String =
        if (word.isEmpty) answer
        else if (word.head == c) go(word.tail, guessed.tail, answer + word.head)
        else go(word.tail, guessed.tail, answer + guessed.head)

      new Game(word, go(word, guessed, ""), mistakes)
    }
  }
}

object Game {
  def newGame(word: String) = new Game(word, "*" * word.length, 0)
}
