package game

class Game(private val word: String, private val guessed: String) {
  def currentWord(): String = guessed
}

object Game {
  def newGame(word: String) = new Game(word, "*" * word.length)
}
