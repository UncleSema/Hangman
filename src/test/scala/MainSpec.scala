import console.CLI
import game.Game
import org.scalatest.flatspec.AnyFlatSpec

import java.io.{ByteArrayOutputStream, StringReader}

class MainSpec extends AnyFlatSpec {

  val game: Game = Game.newGame("Hello")

  "Main" should "print that game has started" in test("exit", beforeCommand(game))

  it should "say whether some command is not exist" in
    test(
      "some command\none more\nexit",
      beforeCommand(game) + CLI.ERROR_COMMAND + "\n" + beforeCommand(game) + CLI.ERROR_COMMAND + "\n" + beforeCommand(
        game
      )
    )

  def interact(commands: String): String = {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) { Console.withIn(new StringReader(commands)) { Main.main(Array.empty) } }
    out.toString
  }

  def test(input: String, output: String): Unit = assert(
    interact(input) == CLI.START_COMMAND + "\n" + output + CLI.FINISH_COMMAND + "\n"
  )
  def beforeCommand(game: Game): String = CLI.WORD_COMMAND + game.currentWord() + "\n" + CLI.LETTER_COMMAND + "\n"

}
