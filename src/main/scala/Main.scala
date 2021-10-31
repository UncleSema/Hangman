import console.CLI
import game.Game

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    CLI.start()
    val game = Game.newGame("Hello")
    while (true) {
      CLI.currentWord(game)
      CLI.guessLetter()
      val str = StdIn.readLine()
      if (str == "exit") {
        CLI.finish()
        return
      }
      CLI.error()
    }
  }
}
