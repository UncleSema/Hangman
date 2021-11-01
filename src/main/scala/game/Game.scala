package game

import game.Answers.Answer

import scala.annotation.tailrec

class Game(private val word: String, val guessed: String, val mistakes: Int) {
  val MAX_MISTAKES        = 5
  val isWin: Boolean      = word == guessed
  val isLose: Boolean     = mistakes >= MAX_MISTAKES
  val isFinished: Boolean = isWin || isLose

  def check(c: Char): Answer =
    if (isFinished) Answers.Forbidden
    else if (!word.contains(c)) Answers.Wrong
    else if (!guessed.contains(c)) Answers.Right
    else Answers.Asked

  def guess(c: Char): Game = check(c) match {
    case Answers.Forbidden             => this
    case Answers.Wrong | Answers.Asked => new Game(word, guessed, mistakes + 1)
    case Answers.Right =>
      @tailrec
      def go(word: String, guessed: String, answer: String): String =
        if (word.isEmpty) answer
        else if (word.head == c) go(word.tail, guessed.tail, answer + word.head)
        else go(word.tail, guessed.tail, answer + guessed.head)

      new Game(word, go(word, guessed, ""), mistakes)
  }

}

object Game {
  def newGame(word: String) = new Game(word, "*" * word.length, 0)
}
