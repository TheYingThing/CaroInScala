package caro.aview

import caro.controller.Controller
import caro.model._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class ScalaTuiSpec extends AnyWordSpec with should.Matchers{

  "A Caro Tui" should {
    val board = Board()
    val cont = new Controller(board)
    val tui = new ScalaTui(cont)

    "print the board on input 'board" in {
      tui.processInputLine("board")
      cont.board should be(board)
    }

    "create a new board on input 'start'" in {
      tui.processInputLine("start")
      cont.board.isEmpty should be(true)
    }

    "set a tile on input 'first red'" in {
      tui.processInputLine("first red")
      cont.board.getCell(9, 9).getColor should be ("red")
    }

    "set a tile on input 'put 9 10 black'" in {
      tui.processInputLine("put 7 8 black")
      cont.board.getCell(9, 10).getColor should be("black")
    }

    "set a name for player1 on input 'player1 Sam'" in {
      tui.processInputLine("player1 Sam")
      cont.board.player1.name should be("Sam")
      cont.board.player2.name should be("player2")
    }

    "set a name for player2 on input 'player2 Mike'" in {
      tui.processInputLine("player2 Mike")
      cont.board.player2.name should be("Mike")
      cont.board.player1.name should be("Sam")
    }

    "exit the game on input'quit'" in {
      tui.processInputLine("quit") should be()
    }

    "not do anything on wrong input" in {
      tui.processInputLine("wrong") should be()
    }
   }
}
