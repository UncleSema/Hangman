import console.CLI
import game.Game

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    CLI.start()
    var game = Game.newGame("Hello")
    while (true) {
      CLI.currentWord(game)
      CLI.guessLetter()
      val str = StdIn.readLine()
      if (str == "exit") {
        CLI.finish()
        return
      }
      if (str.matches("\\? \\w")) {
        val c = str.last
        if (!game.wordContains(c)) CLI.wrong()
        else if (!game.guessedContains(c)) CLI.right()
        else CLI.asked()
        game = game.guess(str.last)

      } else {
        CLI.error()
      }
    }
  }
}
