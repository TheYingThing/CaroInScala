package caro.controller.controllerComponent.controllerBaseImpl

import caro.controller.controllerComponent._
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.{Board, Player}
import caro.util._

class Controller(var board:BoardInterface) extends ControllerInterface {
  private val undoManager = new UndoManager
  def newBoard(p1:String, p2:String):Unit = {
    val nplayer1:Player = Player(p1)
    val nplayer2:Player = Player(p2)
    board = Board(player1 = nplayer1, player2 = nplayer2)
    notifyObservers()
  }

  def boardToString: String = board.toString

  def putCell(row: Int, col: Int, color:String):Unit = {
    undoManager.doStep(new ReplaceCommand(row, col, color, this))
    notifyObservers()
  }

  def correctCell(row: Int, col:Int):Unit = {
    undoManager.doStep(new CorrectionCommand(row, col, this))
    notifyObservers()
  }

  def getPlayerOneName:String = board.getPlayerOne.getName

  def getPlayerTwoName:String = board.getPlayerTwo.getName

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers()
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers()
  }

  override def playerOneToString: String = board.getPlayerOne.toString

  override def playerTwoToString: String = board.getPlayerTwo.toString

  override def getBoardStatus: String = board.getStatus

  override def getCellColor(row: Int, col: Int): String = board.getCell(row, col).getColor

  override def getMoves: Int = board.getMoves
}
