package caro.controller.controllerComponent.controllerBaseImpl

import caro.model.Board
import caro.util.Command
class CorrectionCommand(row:Int, col:Int, controller:Controller) extends Command {
  val oldboard:Board = controller.board
  override def doStep(): Unit = {
    controller.board = controller.board.replaceCell(row, col, controller.board.getLastColor)
  }

  override def undoStep(): Unit = {
    controller.board = oldboard
  }

  override def redoStep(): Unit = {
    controller.board = controller.board.replaceCell(row, col, controller.board.getLastColor)
  }
}