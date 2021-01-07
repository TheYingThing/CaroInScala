package caro.controller.controllerComponent

import caro.model.{Board, Cell, Player}
import caro.util._

trait ControllerInerface extends Observable {

  def newBoard(p1:String, p2:String):Unit
  def boardToString:String
  def putCell(row:Int, col:Int, color:String):Unit
  def correctCell(row:Int, col:Int):Unit
  def getPlayerOneName:String
  def getPlayerTwoName:String
  def playerOneToString:String
  def playerTwoToString:String
  def getBoardStatus:String
  def getCellColor(row:Int, col:Int):String
  def getMoves:Int
  def undo:Unit
  def redo:Unit
}
