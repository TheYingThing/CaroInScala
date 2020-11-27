package caro.aview

import caro.controller.Controller
import caro.util.Observer


class ScalaTui(controller: Controller) extends Observer{
  controller.add(this)
  val center = 9

  def processInputLine(input: String):Unit = {
    input match {
      case "board" => update
      case "start" => controller.newBoard("player1", "player2")
      case _ => input.split(" ").toList match {
        case first::color::Nil =>
          if (first.equals("first")) {
            controller.putCell(center, center, color)
          } else {
            update
          }
        case row::column::color::Nil => controller.putCell(row.toInt+2 , column.toInt+2, color)
        case player::name::Nil =>
          if(player.equals("player1")){
            controller.updateNames("player1", name)
          } else if(player.equals("player2")){
            controller.updateNames("player2", name)
          }
        //case names::Nil => if (names.equals("names")) {println("Player1: " + name1 + "player2: " + name2)}
        case _ => println("Not a valid Command!")
      }
    }
  }

  override def update: Unit = println(controller.boardToString)
}

