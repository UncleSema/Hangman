package console

object CLI {
  val START_COMMAND: String = "Starting Hangman game..."
  val ERROR_COMMAND: String = "No such command founded"

  def initialize(): Unit = println(START_COMMAND)
  def noSuchCommand(): Unit = println(ERROR_COMMAND)
}
