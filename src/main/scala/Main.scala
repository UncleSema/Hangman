import console.CLI
import game.{Answers, Game, Pool}

import scala.annotation.tailrec
import scala.io.StdIn

object Main {

  @tailrec
  def play(game: Game): Unit =
    if (game.isFinished) if (game.isWin) CLI.win() else CLI.lose()
    else {
      CLI.currentWord(game.guessed)
      CLI.guessLetter()
      val line = StdIn.readLine()
      if (line == null) CLI.finish()
      else
        line match {
          case exit if exit equals "exit" => CLI.finish()
          case command if command matches "\\? \\w" =>
            game check command.last match {
              case Answers.Right => CLI.right()
              case Answers.Wrong => CLI.wrong(game.mistakes + 1, game.MAX_MISTAKES)
              case Answers.Asked => CLI.asked(game.mistakes + 1, game.MAX_MISTAKES)
            }
            play(game guess command.last)
          case _ =>
            CLI.error()
            play(game)
        }
    }

  def main(args: Array[String]): Unit = {
    CLI.start()
    play(Game.newGame(if (args.isEmpty) Pool.getRandomWord else args.head))
  }
}
