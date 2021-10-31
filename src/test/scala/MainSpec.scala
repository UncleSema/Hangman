import console.CLI
import org.scalatest.flatspec.AnyFlatSpec

import java.io.{ByteArrayOutputStream, StringReader}

class MainSpec extends AnyFlatSpec {

  "Main" should "print that game has started" in test("exit", CLI.START_COMMAND)

  it should "say whether some command is not exist" in
    test("some command\none more\nexit", CLI.START_COMMAND + "\n" + CLI.ERROR_COMMAND + "\n" + CLI.ERROR_COMMAND)

  def interact(commands: String): String = {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) { Console.withIn(new StringReader(commands)) { Main.main(Array.empty) } }
    out.toString
  }

  def test(input: String, output: String): Unit = assert(interact(input) == output + "\n")
}
