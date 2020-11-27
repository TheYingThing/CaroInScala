package caro.aview

import caro.controller
import caro.controller.Controller
import caro.model._
import org.scalatest.matchers._
import org.scalatest.wordspec._

class ScalaTuiSpec extends AnyWordSpec with should.Matchers{

  "A Caro Tui" should {
    val board = new Board()
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

    "set a tile on input '9 10 black'" in {
      tui.processInputLine("7 8 black")
      cont.board.getCell(9, 10).getColor should be("black")
    }

    "set an name for player1 on input 'player1 Ying'" in {
      tui.processInputLine("start")
      tui.processInputLine("player1 Ying")
      tui.processInputLine("player2 Rebecca")
      cont.board.player2.name should be("Rebecca")
    }
   }
}
