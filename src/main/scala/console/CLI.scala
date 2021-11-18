package console

object CLI {
  val ERROR  = "No such command founded"
  val FINISH = "Game is finished!"
  val LETTER = "Guess a letter: "
  val LOSE   = "You lost!"
  val RIGHT  = "Hit!"
  val START  = "Starting Hangman game..."
  val WIN    = "You won!"
  val WORD   = "The word: "

  val ASKED: (Int, Int) => String = (a: Int, b: Int) => s"This letter has been already asked... Mistake $a out of $b"
  val WRONG: (Int, Int) => String = (a: Int, b: Int) => s"Missed, mistake $a out of $b"

  def currentWord(word: String): Unit = println(WORD + word)
  def error(): Unit                   = println(ERROR)
  def finish(): Unit                  = println(FINISH)
  def guessLetter(): Unit             = println(LETTER)
  def lose(): Unit                    = println(LOSE)
  def right(): Unit                   = println(RIGHT)
  def start(): Unit                   = println(START)
  def win(): Unit                     = println(WIN)

  def asked(mistakes: Int, maxMistakes: Int): Unit = println(ASKED(mistakes, maxMistakes))
  def wrong(mistakes: Int, maxMistakes: Int): Unit = println(WRONG(mistakes, maxMistakes))
}
