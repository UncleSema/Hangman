import console.CLI
import org.scalatest.flatspec.AnyFlatSpec

import java.io.{ByteArrayOutputStream, StringReader}

class MainSpec extends AnyFlatSpec {

  "Main" should "print that game has started" in test(
    "Hello",
    "exit",
    before("*****"),
    CLI.FINISH
  )

  it should "say whether some command is not exist" in test(
    "Hello",
    "some command\none more\nexit",
    before("*****") + CLI.ERROR + "\n" +
      before("*****") + CLI.ERROR + "\n" +
      before("*****"),
    CLI.FINISH
  )

  it should "guess the letter" in test(
    "Hello",
    "? h\n? H\n? l\n? H\nexit",
    before("*****") + CLI.WRONG(1, 5) + "\n" +
      before("*****") + CLI.RIGHT + "\n" +
      before("H****") + CLI.RIGHT + "\n" +
      before("H*ll*") + CLI.ASKED(2, 5) + "\n" +
      before("H*ll*"),
    CLI.FINISH
  )

  it should "win" in test(
    "HangMan",
    "? H\n? a\n? n\n? g\n? M\n",
    before("*******") + CLI.RIGHT + "\n" +
      before("H******") + CLI.RIGHT + "\n" +
      before("Ha***a*") + CLI.RIGHT + "\n" +
      before("Han**an") + CLI.RIGHT + "\n" +
      before("Hang*an") + CLI.RIGHT + "\n",
    CLI.WIN
  )

  it should "lose" in test(
    "LoseMan",
    "? L\n? o\n? O\n? o\n? L\n? w\n? Z\n",
    before("*******") + CLI.RIGHT + "\n" +
      before("L******") + CLI.RIGHT + "\n" +
      before("Lo*****") + CLI.WRONG(1, 5) + "\n" +
      before("Lo*****") + CLI.ASKED(2, 5) + "\n" +
      before("Lo*****") + CLI.ASKED(3, 5) + "\n" +
      before("Lo*****") + CLI.WRONG(4, 5) + "\n" +
      before("Lo*****") + CLI.WRONG(5, 5) + "\n",
    CLI.LOSE
  )

  def interact(word: String, commands: String): String = {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) { Console.withIn(new StringReader(commands)) { Main.main(Array(word)) } }
    out.toString
  }

  def test(word: String, input: String, output: String, end: String): Unit = assert(
    interact(word, input) == CLI.START + "\n" + output + end + "\n"
  )

  def before(expected: String): String = CLI.WORD + expected + "\n" + CLI.LETTER + "\n"

}
