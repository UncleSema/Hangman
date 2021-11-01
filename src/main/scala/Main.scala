import console.CLI
import game.{Answers, Game}

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    CLI.start()
    var game = Game.newGame(args.head)
    while (true) {
      CLI.currentWord(game.guessed)
      CLI.guessLetter()
      val str = StdIn.readLine()
      if (str equals "exit") {
        CLI.finish()
        return
      }
      if (str matches "\\? \\w") {
        val c = str.last
        if (game.check(c) == Answers.Wrong) CLI.wrong(game.mistakes + 1, game.MAX_MISTAKES)
        else if (game.check(c) == Answers.Right) CLI.right()
        else CLI.asked(game.mistakes + 1, game.MAX_MISTAKES)
        game = game.guess(str.last)
        if (game.isFinished) {
          if (game.isWin) CLI.win()
          else if (game.isLose) CLI.lose()
          return
        }
      } else {
        CLI.error()
      }
    }
  }
}
