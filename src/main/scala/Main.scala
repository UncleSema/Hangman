import console.CLI

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    CLI.initialize()
    while (true) {
      if (StdIn.readLine() == "exit") {
        return
      }
      CLI.noSuchCommand()
    }
  }
}
