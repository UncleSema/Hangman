package console

import game.Game

object CLI {
  val START_COMMAND: String = "Starting Hangman game..."
  val ERROR_COMMAND: String = "No such command founded"
  val WORD_COMMAND: String = "The word: "
  val LETTER_COMMAND: String = "Guess a letter: "
  val FINISH_COMMAND: String = "Game is finished!"
  val WRONG_COMMAND: String = "Mistake!"
  val RIGHT_COMMAND: String = "Right!"
  val ASKED_COMMAND: String = "This letter has been already asked..."

  def start(): Unit = println(START_COMMAND)
  def error(): Unit = println(ERROR_COMMAND)
  def currentWord(game: Game): Unit = println(WORD_COMMAND + game.currentWord())
  def guessLetter(): Unit = println(LETTER_COMMAND)
  def finish(): Unit = println(FINISH_COMMAND)
  def wrong(): Unit = println(WRONG_COMMAND)
  def right(): Unit = println(RIGHT_COMMAND)
  def asked(): Unit = println(ASKED_COMMAND)
}
