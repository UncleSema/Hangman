package console

object CLI {
  val START_COMMAND: String               = "Starting Hangman game..."
  val ERROR_COMMAND: String               = "No such command founded"
  val WORD_COMMAND: String                = "The word: "
  val LETTER_COMMAND: String              = "Guess a letter: "
  val FINISH_COMMAND: String              = "Game is finished!"
  val RIGHT_COMMAND: String               = "Hit!"
  val ASKED_COMMAND: String               = "This letter has been already asked..."
  val WRONG_COMMAND: (Int, Int) => String = (a: Int, b: Int) => "Missed, mistake " + a + " out of " + b

  def start(): Unit                                 = println(START_COMMAND)
  def error(): Unit                                 = println(ERROR_COMMAND)
  def currentWord(word: String): Unit               = println(WORD_COMMAND + word)
  def guessLetter(): Unit                           = println(LETTER_COMMAND)
  def finish(): Unit                                = println(FINISH_COMMAND)
  def wrong(mistakes: Int, max_mistakes: Int): Unit = println(WRONG_COMMAND(mistakes, max_mistakes))
  def right(): Unit                                 = println(RIGHT_COMMAND)
  def asked(): Unit                                 = println(ASKED_COMMAND)
}
